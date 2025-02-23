package com.cloudcrop.cloudcrop.service;

import com.cloudcrop.cloudcrop.constants.Constants;
import com.cloudcrop.cloudcrop.dto.WeatherResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WeatherService {

    private final WebClient webClient;

    @Value("${weather-api-url}")
    private String weatherApiUrl;

    @Value("${weather-API-Key}")
    private String weatherApiKey;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<WeatherResponseDTO> fetchWeatherData(double latitude, double longitude, String unit) {
        String url = weatherApiUrl + Constants.WEATHER_KEY_STRING + weatherApiKey + Constants.WEATHER_Q + latitude + Constants.COMMA + longitude + "&units=" + unit;

        System.out.println(""+webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).block());

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherResponseDTO.class)
                .onErrorResume(ex -> {
                    System.out.println("Error fetching weather data: " + ex.getMessage());
                    return Mono.empty();
                });
    }
}
