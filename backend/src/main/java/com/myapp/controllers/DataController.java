package com.myapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class DataController {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public DataController(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/api/data")
    public ResponseEntity<Object> getJsonData() {
        try {
            // Use ResourceLoader to get the resource as an InputStream
            var resource = resourceLoader.getResource("classpath:static/data.json");
            var json = objectMapper.readValue(resource.getInputStream(), Object.class);
            return ResponseEntity.ok(json);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error reading file");
        }
    }
}

