package com.vogame.others;

import com.vogame.entities.Test;
import com.vogame.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/all")
    public List<Test> getAll() {
        List<Test> testList = testRepository.findAll();

        return testList;
    }

}
