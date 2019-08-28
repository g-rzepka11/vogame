package com.vogame.service;

import com.vogame.dto.GetWordPackagesResponse;
import com.vogame.dto.WordPackageDTO;
import com.vogame.dto.WordPackageDataDTO;
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

    public GetWordPackagesResponse getWordPackages() {
        GetWordPackagesResponse response = new GetWordPackagesResponse();

        List<WordPackageDataDTO> wordPackageDataDTOS = wordPackageRepository.findAll().stream()
                .map(wordPackage -> modelMapper.map(wordPackage, WordPackageDataDTO.class))
                .collect(Collectors.toList());

        response.setWordPackageDataDTOS(wordPackageDataDTOS);

        return response;
    }

    public WordPackageDTO getWordPackageById(Long id) {
        return modelMapper.map(wordPackageRepository.findById(id).get(), WordPackageDTO.class);
    }

}
