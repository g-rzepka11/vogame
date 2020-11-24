package com.vogame.controller;

import com.vogame.dto.word.*;
import com.vogame.dto.word.response.GetWordPackageByIdResponse;
import com.vogame.dto.word.response.GetWordPackagesResponse;
import com.vogame.dto.word.response.IsWordPackageByNameExistsResponse;
import com.vogame.dto.word.response.ModifyWordPackageResponse;
import com.vogame.service.WordPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordpackages")
public class WordPackageController {

    @Autowired
    private WordPackageService wordPackageService;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<GetWordPackagesResponse> getByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(wordPackageService.getWordPackages(userId));
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<GetWordPackageByIdResponse> getWordPackageById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(wordPackageService.getWordPackageById(id));
    }

    @PostMapping("/modify")
    public ResponseEntity<ModifyWordPackageResponse> modifyWordPackage(@RequestBody WordPackageDTO wordPackageDTO) {
        return ResponseEntity.ok(wordPackageService.modifyWordPackage(wordPackageDTO));
    }

    @GetMapping("/byNameExists/{wordPackageName}")
    public ResponseEntity<IsWordPackageByNameExistsResponse> isWordPackageByNameExists(@PathVariable("wordPackageName") String wordPackageName) {
        return ResponseEntity.ok(wordPackageService.isWordPackageByNameExists(wordPackageName));
    }

}
