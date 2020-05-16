package com.vogame.service;

import com.vogame.dto.GameDTO;
import com.vogame.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<GameDTO> getGameByOwnerId(Long ownerId) {
        return gameRepository.findByOwner(ownerId).stream()
                .map(wordPackage -> modelMapper.map(wordPackage, GameDTO.class))
                .collect(Collectors.toList());
    }

    public GameDTO getGameById(Long id) {
        return modelMapper.map(gameRepository.findById(id).get(), GameDTO.class);
    }
}
