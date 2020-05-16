package com.vogame.service;

import com.vogame.dto.word.GetWordPackagesResponse;
import com.vogame.dto.word.WordPackageDTO;
import com.vogame.dto.word.WordPackageDataDTO;
import com.vogame.entity.WordPackage;
import com.vogame.repository.WordPackageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

        response.setWordPackageDataDTOS(wordPackageDataDTOS);

        return response;
    }

    public WordPackageDTO getWordPackageById(Long id) {
        return modelMapper.map(wordPackageRepository.findById(id).get(), WordPackageDTO.class);
    }

    public void modifyWordPackage(WordPackageDTO wordPackageDTO) {
        WordPackage wordPackage = modelMapper.map(wordPackageDTO, WordPackage.class);
        wordPackageRepository.save(wordPackage);
    }

}
