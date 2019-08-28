package com.vogame.service;

import com.vogame.dto.WordPackageDTO;
import com.vogame.repository.WordPackageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordPackageService {

    @Autowired
    private WordPackageRepository wordPackageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<WordPackageDTO> getWordPackages() {
        return wordPackageRepository.findAll().stream()
                .map(wordPackage -> modelMapper.map(wordPackage, WordPackageDTO.class))
                .collect(Collectors.toList());
    }

    public WordPackageDTO getWordPackageById(Long id) {
        return modelMapper.map(wordPackageRepository.findById(id).get(), WordPackageDTO.class);
    }

}
