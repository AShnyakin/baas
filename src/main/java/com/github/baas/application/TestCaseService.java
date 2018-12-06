package com.github.baas.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.baas.models.TestCase;
import com.github.baas.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class TestCaseService {

    @Autowired
    private ProjectRepository projectRepository;

    public TestCase upload(MultipartFile file) throws IOException {
        InputStream inputStream =  file.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, TestCase.class);
    }

}
