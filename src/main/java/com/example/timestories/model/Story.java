package com.example.timestories.model;

public class Story {
    private String title;
    private String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Story(String title, String link) {
		super();
		this.title = title;
		this.link = link;
	}
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructor, Getters and Setters
    
    
}