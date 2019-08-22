package com.vogame.controller;

import com.vogame.dto.WordPackageDTO;
import com.vogame.entity.WordPackage;
import com.vogame.repository.WordPackageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WordPackageController {

    @Autowired
    private WordPackageRepository wordPackageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/wordpackages")
    public List<WordPackageDTO> getWordPackages() {
        return wordPackageRepository.findAll().stream()
                .map(wordPackage -> modelMapper.map(wordPackage, WordPackageDTO.class))
                .collect(Collectors.toList());
    }

}
