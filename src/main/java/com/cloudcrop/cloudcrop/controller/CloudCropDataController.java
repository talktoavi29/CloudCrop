package com.cloudcrop.cloudcrop.controller;

import com.cloudcrop.cloudcrop.dto.NewsResponseDTO;
import com.cloudcrop.cloudcrop.dto.UserLocationRequestDTO;
import com.cloudcrop.cloudcrop.dto.WeatherResponseDTO;
import com.cloudcrop.cloudcrop.service.CloudCropDataService;
import com.cloudcrop.cloudcrop.service.NewsService;
import com.cloudcrop.cloudcrop.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cloudcrop")
public class CloudCropDataController implements ICloudCropDataController{

    @Autowired
    private CloudCropDataService cloudCropDataService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NewsService newsService;

    public CloudCropDataController(WeatherService weatherService, NewsService newsService) {
        this.weatherService = weatherService;
        this.newsService = newsService;
    }


    @PostMapping("/fetchData")
    @Override
    public ResponseEntity<?> fetchDataFromAPIs(@RequestBody Map<String, String> requestBody) {
        String requestDataType = requestBody.get("requestDataType");

        if (requestDataType == null || requestDataType.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request: requestDataType is missing");
        }
        String response = cloudCropDataService.fetchDataFromAPIs(requestDataType);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fetchWeather")
    public ResponseEntity<WeatherResponseDTO> fetchWeather(@RequestBody UserLocationRequestDTO requestDTO) {
        WeatherResponseDTO response = weatherService.fetchWeatherData(requestDTO.getLatitude(), requestDTO.getLongitude(), requestDTO.getUnit()).block();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)  // Ensures response is JSON
                .body(response);
    }

    @GetMapping("/fetchNews")
    public Mono<ResponseEntity<NewsResponseDTO>> fetchNews() {
        return newsService.fetchNewsData()
                .map(ResponseEntity::ok);
    }
}
