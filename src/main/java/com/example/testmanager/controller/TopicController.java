package com.example.testmanager.controller;

import com.example.testmanager.dto.TopicDTO;
import com.example.testmanager.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping(value ="/save-topic")
    public ResponseEntity<Object> saveTopic(@RequestBody TopicDTO topicDTO ){

        topicService.saveTopic(topicDTO);
        return new ResponseEntity<>("A new Topic is created/updated successsfully", HttpStatus.CREATED);
    }

}
