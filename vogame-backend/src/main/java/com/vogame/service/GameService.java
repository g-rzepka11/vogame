package com.vogame.service;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.enums.GameStatus;
import com.vogame.dto.game.GameDTO;
import com.vogame.dto.game.request.CreateNewGameRequest;
import com.vogame.dto.game.request.SelectNextRequest;
import com.vogame.dto.game.request.StartGameRequest;
import com.vogame.dto.game.response.*;
import com.vogame.entity.*;
import com.vogame.repository.*;
import com.vogame.util.HashUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private WordPackageRepository wordPackageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HashUtils hashUtils;

    public GetGameByUserIdResponse getGameByUserId(Long userId) {
        List<GameDTO> gameDtos = gameRepository.findByUserId(userId).stream()
                .map(wordPackage -> modelMapper.map(wordPackage, GameDTO.class))
                .collect(Collectors.toList());
        return GetGameByUserIdResponse.builder().payload(gameDtos).build();
    }

    public GetGameByIdResponse getGameById(Long id) {
        return GetGameByIdResponse.builder()
                .payload(modelMapper.map(gameRepository.findById(id).get(), GameDTO.class)).build();
    }

    public GameUpdateHashResponse updateHash(Long id) {
        Game game = gameRepository.findById(id).get();
        if(game != null) {
            game.setHashedWord(hashUtils.updateHash(game.getHashedWord(), game.getWord().getText()));
            game.setWordTime(new Date());
        }

        gameRepository.save(game);

        return GameUpdateHashResponse.builder().payload(modelMapper.map(game, GameDTO.class)).build();
    }

    public GameUpdateDateAndHashResponse updateDateAndHash(Long id) {
        Game game = gameRepository.findById(id).get();
        if(game != null) {
            int hashedSignCount = StringUtils.countOccurrencesOf(game.getHashedWord(), "_");
            int updateTimes = getUpdateTimes(game.getWordTime(), hashedSignCount);
            for (int i=0; i<updateTimes; i++) {
                game.setHashedWord(hashUtils.updateHash(game.getHashedWord(), game.getWord().getText()));
            }
            game.setWordTime(new Date());
            gameRepository.save(game);
        }

        return GameUpdateDateAndHashResponse.builder()
                .payload(modelMapper.map(game, GameDTO.class)).build();
    }

    private int getUpdateTimes(Date wordTime, int hashedSignCount) {
        if(wordTime == null) {
            return 0;
        }
        long diff = new Date().getTime() - wordTime.getTime();
        long differenceInSeconds = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
        return Math.min(hashedSignCount, (int)Math.floorDiv(differenceInSeconds, 10L));
    }

    public GameWordGuessedResponse wordGuessed(Long id) {
        Game game = gameRepository.findById(id).get();
        game.setStatus(GameStatus.SELECT.getStatusId());
        game.setWordTime(null);
        //TODO: update score
        gameRepository.save(game);
        return GameWordGuessedResponse.builder()
                .payload(modelMapper.map(game, GameDTO.class)).build();
    }

    public GameSelectNextResponse selectNext(SelectNextRequest request) {
        Game game = gameRepository.findById(request.getGameId()).get();
        game.setCurUser(request.getUserId());
        game.setWord(wordRepository.findById(request.getWordId()).get());
        game.setHashedWord(hashUtils.getHashOfWord(game.getWord().getText()));
        game.setStatus(GameStatus.ACTION.getStatusId());

        gameRepository.save(game);
        return GameSelectNextResponse.builder().payload(modelMapper.map(game, GameDTO.class)).build();
    }

    public CreateNewGameResponse createNewGame(CreateNewGameRequest request) {
        Game game = new Game();
        game.setName(request.getGameName());
        game.setStatus(GameStatus.NOT_STARTED.getStatusId());
        game.setOwner(request.getUserId());
        game.setCurUser(request.getUserId());
        game.setGameUsers(new ArrayList<>());

        User user = userRepository.findById(request.getUserId()).get();
        GameUser gameUser = new GameUser();
        gameUser.setUser(user);
        gameUser.setGame(game);
        gameUser.setModerator(true);
        game.getGameUsers().add(gameUser);

        addWords(game, request.getWordPackageName());

        Game savedGame = gameRepository.save(game);

        inviteUsers(request.getUserId(), game, request.getInvitedUserEmails());

        return CreateNewGameResponse.builder().payload(savedGame.getId()).build();
    }

    private void addWords(Game game, String wordPackageName) {
        WordPackage wordPackage = wordPackageRepository.findFirstByWordPackageName(wordPackageName);
        game.setGameWords(new ArrayList<>());

        wordPackage.getWords().stream().forEach(wp -> {
            GameWord gameWord = new GameWord();
            gameWord.setGame(game);
            gameWord.setWord(wp);
            game.getGameWords().add(gameWord);
        });
    }

    private void inviteUsers(Long userId, Game game, List<String> invitedUserEmails) {
        invitedUserEmails.stream().forEach(userEmail -> {
            Invitation invitation = new Invitation();
            invitation.setGame(game);
            invitation.setCreatedAt(new Date());
            invitation.setHostUser(userId);
            invitation.setInvitee(userRepository.findFirstByEmail(userEmail));
            invitationRepository.save(invitation);
        });
    }

    public AbstractVogameResponse startGame(StartGameRequest startGameRequest) {
        invitationRepository.deleteAllByGame_Id(startGameRequest.getGameId());

        Game game = gameRepository.getOne(startGameRequest.getGameId());
        game.setCurUser(startGameRequest.getUserId());
        game.setStatus(GameStatus.SELECT.getStatusId());
        gameRepository.save(game);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }
}
