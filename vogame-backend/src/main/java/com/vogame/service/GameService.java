package com.vogame.service;

import com.vogame.dto.SelectNextRequest;
import com.vogame.dto.enums.GameStatus;
import com.vogame.dto.CheckWordRequest;
import com.vogame.dto.GameDTO;
import com.vogame.entity.Game;
import com.vogame.repository.GameRepository;
import com.vogame.repository.WordRepository;
import com.vogame.util.HashUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    private ModelMapper modelMapper;

    @Autowired
    private HashUtils hashUtils;

    public List<GameDTO> getGameByUserId(Long userId) {
        return gameRepository.findByUserId(userId).stream()
                .map(wordPackage -> modelMapper.map(wordPackage, GameDTO.class))
                .collect(Collectors.toList());
    }

    public GameDTO getGameById(Long id) {
        return modelMapper.map(gameRepository.findById(id).get(), GameDTO.class);
    }

    public GameDTO updateHash(Long id) {
        Game game = gameRepository.findById(id).get();
        if(game != null) {
            game.setHashedWord(hashUtils.updateHash(game.getHashedWord(), game.getWord().getText()));
            game.setWordTime(new Date());
        }

        gameRepository.save(game);

        return modelMapper.map(game, GameDTO.class);
    }

    public GameDTO updateDateAndHash(Long id) {
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

        return modelMapper.map(game, GameDTO.class);
    }

    private int getUpdateTimes(Date wordTime, int hashedSignCount) {
        if(wordTime == null) {
            return 0;
        }
        long diff = new Date().getTime() - wordTime.getTime();
        long differenceInSeconds = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
        return Math.min(hashedSignCount, (int)Math.floorDiv(differenceInSeconds, 10L));
    }

    public boolean checkWord(CheckWordRequest checkWordRequest) {
        Game game = gameRepository.findById(checkWordRequest.getGameId()).get();

        if(game != null) {
            if(game.getWord().getText().equals(checkWordRequest.getWord())) {
                return true;
            }
        }
        return false;
    }

    public GameDTO wordGuessed(Long id) {
        Game game = gameRepository.findById(id).get();
        game.setStatus(GameStatus.SELECT.getStatusId());
        game.setWordTime(null);
        //TODO: update score
        gameRepository.save(game);
        return modelMapper.map(game, GameDTO.class);
    }

    public GameDTO selectNext(SelectNextRequest request) {
        Game game = gameRepository.findById(request.getGameId()).get();
        game.setCurUser(request.getUserId());
        game.setWord(wordRepository.findById(request.getWordId()).get());
        game.setHashedWord(hashUtils.getHashOfWord(game.getWord().getText()));
        game.setStatus(GameStatus.ACTION.getStatusId());

        gameRepository.save(game);
        return modelMapper.map(game, GameDTO.class);
    }
}
