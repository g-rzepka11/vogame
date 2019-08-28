package com.vogame.controller;

import com.vogame.dto.WordPackageDTO;
import com.vogame.service.WordPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordPackageController {

    @Autowired
    private WordPackageService wordPackageService;

    @GetMapping("/wordpackages")
    public List<WordPackageDTO> getWordPackages() {
        return wordPackageService.getWordPackages();
    }

    @GetMapping("/wordpackages/{id}")
    public WordPackageDTO getWordPackageById(@PathVariable("id") Long id) {
        return wordPackageService.getWordPackageById(id);
    }

}
