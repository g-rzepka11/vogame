package com.vogame.controller;

import com.vogame.dto.GetWordPackagesResponse;
import com.vogame.dto.WordPackageDTO;
import com.vogame.service.WordPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordPackageController {

    @Autowired
    private WordPackageService wordPackageService;

    @GetMapping("/wordpackages")
    public GetWordPackagesResponse getWordPackages() {
        return wordPackageService.getWordPackages();
    }

    @GetMapping("/wordpackages/{id}")
    public WordPackageDTO getWordPackageById(@PathVariable("id") Long id) {
        return wordPackageService.getWordPackageById(id);
    }

}
