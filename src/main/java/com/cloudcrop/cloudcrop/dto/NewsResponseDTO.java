package com.cloudcrop.cloudcrop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponseDTO {
    @JsonProperty("status")
    private String status;

    @JsonProperty("totalResults")
    private int totalResults;

    @JsonProperty("articles")
    private List<Article> articles;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Article {
    @JsonProperty("source")
    private Source source;

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("urlToImage")
    private String urlToImage;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("content")
    private String content;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Source {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}