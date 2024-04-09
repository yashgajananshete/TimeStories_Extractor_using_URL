package com.example.timestories.service;

import com.example.timestories.model.Story;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoryService {

    private static final String TIME_URL = "https://time.com";
    private static final String STORY_TAG = "<li class=\"latest-stories__item\">";
    private static final String TITLE_TAG = "<h3 class=\"latest-stories__item-headline\">";
    private static final String LINK_TAG = "href=\"";

    public List<Story> getLatestStories() throws Exception {
        List<Story> stories = new ArrayList<>();
        URL url = new URL(TIME_URL);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        boolean insideStory = false;
        Story currentStory = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains(STORY_TAG)) {
                insideStory = true;
                currentStory = new Story();
            } else if (insideStory) {
                if (line.contains(TITLE_TAG)) {
                    currentStory.setTitle(extractText(line, TITLE_TAG, "</h3>"));
                } else if (line.contains(LINK_TAG)) {
                    currentStory.setLink(extractText(line, LINK_TAG, "\""));
                    stories.add(currentStory);
                    if (stories.size() == 6) {
                        break; // We only need 6 stories
                    }
                }
            } 
        }
        reader.close();
        return stories;
    }

    private String extractText(String line, String startTag, String endTag) {
        int startIndex = line.indexOf(startTag) + startTag.length();
        int endIndex = line.indexOf(endTag, startIndex);
        return line.substring(startIndex, endIndex);
    }
}
