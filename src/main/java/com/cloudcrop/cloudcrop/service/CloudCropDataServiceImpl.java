package com.cloudcrop.cloudcrop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Slf4j
@Service
public class CloudCropDataServiceImpl implements CloudCropDataService {

    private final WebClient webClient;

    @Value("${weather-api-url}")
    private String weatherApiUrl;

    @Value("${weather-API-Key}")
    private String weatherApiKey;

    @Value("${news-api-url}")
    private String newsApiUrl;

    @Value("${news-api-key}")
    private String newsApiKey;

    //??
    @Autowired
    public CloudCropDataServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String fetchDataFromAPIs(String requestDataType) {
       switch (requestDataType.toLowerCase()) {
           case "weather":
               return fetchDataWebclient(weatherApiUrl + "?key=" + weatherApiKey + "&q=" + "29.3836" + "," + "-94.9025" + "&units=" + "metric");
           case "news":
               return fetchDataWebclient(newsApiUrl + "?apiKey=" + newsApiKey + "&category=agriculture");
           default:
               return "Invalid request";
       }
    }

    private String fetchDataWebclient(String url) {
        return webClient.get()
                .uri(URI.create(url))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}