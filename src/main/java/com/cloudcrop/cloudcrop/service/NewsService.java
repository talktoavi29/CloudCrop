package com.cloudcrop.cloudcrop.service;

import com.cloudcrop.cloudcrop.constants.Constants;
import com.cloudcrop.cloudcrop.dto.NewsResponseDTO;
import com.cloudcrop.cloudcrop.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NewsService {

    private final WebClient webClient;

    @Value("${news-api-url}")
    private String newsApiUrl;

    @Value("${news-api-key}")
    private String newsApiKey;

    public NewsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<NewsResponseDTO> fetchNewsData() {
        String url = newsApiUrl + Constants.NEWS_Q + Constants.NEWS_CATEGORY + Constants.NEWS_API_STRING + newsApiKey;

        System.out.println(""+webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).block());

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(NewsResponseDTO.class)
                .onErrorResume(ex -> {
                    System.out.println("URL: " + url);
                    System.out.println("Error fetching news data: " + ex.getMessage());
                    return Mono.empty();
                });
    }
}