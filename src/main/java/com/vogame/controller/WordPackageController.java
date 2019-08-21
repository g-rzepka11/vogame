package com.vogame.controller;

import com.vogame.entity.WordPackage;
import com.vogame.repository.WordPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordPackageController {

    @Autowired
    private WordPackageRepository wordPackageRepository;

    @GetMapping("/wordpackages")
    public List<WordPackage> getWordPackages() {
        return wordPackageRepository.findAll();
    }

}
