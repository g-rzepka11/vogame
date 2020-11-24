package com.vogame.service;

import com.vogame.dto.word.*;
import com.vogame.dto.word.response.GetWordPackageByIdResponse;
import com.vogame.dto.word.response.GetWordPackagesResponse;
import com.vogame.dto.word.response.IsWordPackageByNameExistsResponse;
import com.vogame.dto.word.response.ModifyWordPackageResponse;
import com.vogame.entity.WordPackage;
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

    public GetWordPackagesResponse getWordPackages(Long userId) {
        GetWordPackagesResponse response = new GetWordPackagesResponse();

        List<WordPackageDataDTO> wordPackageDataDTOS = wordPackageRepository.findByUserId(userId).stream()
                .map(wordPackage -> modelMapper.map(wordPackage, WordPackageDataDTO.class))
                .collect(Collectors.toList());

        response.setPayload(wordPackageDataDTOS);

        return response;
    }

    public GetWordPackageByIdResponse getWordPackageById(Long id) {
        return GetWordPackageByIdResponse.builder()
                .payload(modelMapper.map(wordPackageRepository.findById(id).get(), WordPackageDTO.class))
                .build();
    }

    public ModifyWordPackageResponse modifyWordPackage(WordPackageDTO wordPackageDTO) {
        WordPackage wordPackage = modelMapper.map(wordPackageDTO, WordPackage.class);
        return ModifyWordPackageResponse.builder()
                .payload(modelMapper.map(wordPackageRepository.save(wordPackage), WordPackageDTO.class))
                .build();
    }

    public IsWordPackageByNameExistsResponse isWordPackageByNameExists(String wordPackageName) {
        return IsWordPackageByNameExistsResponse.builder()
                .payload(wordPackageRepository.existsByWordPackageName(wordPackageName)).build();
    }
}
