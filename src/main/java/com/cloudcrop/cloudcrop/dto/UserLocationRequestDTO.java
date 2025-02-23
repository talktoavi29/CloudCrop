package com.cloudcrop.cloudcrop.dto;

public class UserLocationRequestDTO {
    private double latitude;
    private double longitude;
    private String unit;

    // Getters
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getUnit() {
        return unit;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}