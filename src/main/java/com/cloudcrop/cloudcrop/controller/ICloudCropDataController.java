package com.cloudcrop.cloudcrop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface ICloudCropDataController {

    @PostMapping("/fetchData")
    ResponseEntity<?> fetchDataFromAPIs(@RequestBody Map<String, String> requestBody);
}
