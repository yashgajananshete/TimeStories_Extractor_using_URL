package com.example.timestories.controller;

import com.example.timestories.model.Story;
import com.example.timestories.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/getTimeStories")
    public List<Story> getLatestStories() throws Exception {
        return storyService.getLatestStories();
    }
}