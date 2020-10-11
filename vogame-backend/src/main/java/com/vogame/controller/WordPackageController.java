package com.vogame.controller;

import com.vogame.dto.word.GetWordPackagesResponse;
import com.vogame.dto.word.WordPackageDTO;
import com.vogame.service.WordPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordpackages")
public class WordPackageController {

    @Autowired
    private WordPackageService wordPackageService;

    @GetMapping("/getByUserId/{userId}")
    public GetWordPackagesResponse getByUserId(@PathVariable("userId") Long userId) {
        return wordPackageService.getWordPackages(userId);
    }

    @GetMapping("/getone/{id}")
    public WordPackageDTO getWordPackageById(@PathVariable("id") Long id) {
        return wordPackageService.getWordPackageById(id);
    }

    @PostMapping("/modify")
    public WordPackageDTO modifyWordPackage(@RequestBody WordPackageDTO wordPackageDTO) {
        return wordPackageService.modifyWordPackage(wordPackageDTO);
    }

}
