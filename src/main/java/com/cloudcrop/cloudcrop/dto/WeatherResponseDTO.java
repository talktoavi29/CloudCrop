//package com.cloudcrop.cloudcrop.dto;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class WeatherResponseDTO {
//    private LocationDTO location;
//    private double temperature;
//    private String condition;
//    private double windSpeed;
//    private double humidity;
//}

package com.cloudcrop.cloudcrop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {
    @JsonProperty("location")
    private LocationDTO location;

    @JsonProperty("current")
    private CurrentWeatherDTO current;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class LocationDTO {
    @JsonProperty("name")
    private String cityName;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("tz_id")
    private String timeZoneId;

    @JsonProperty("localtime_epoch")
    private long localTimeEpoch;

    @JsonProperty("localtime")
    private String localtime;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class CurrentWeatherDTO {
    @JsonProperty("last_updated_epoch")
    private long lastUpdatedEpoch;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("temp_c")
    private double temperatureCelsius;

    @JsonProperty("temp_f")
    private double temperatureFahrenheit;

    @JsonProperty("is_day")
    private int isDay;

    @JsonProperty("condition")
    private ConditionDTO condition;

    @JsonProperty("wind_mph")
    private double windSpeedMph;

    @JsonProperty("wind_kph")
    private double windSpeedKph;

    @JsonProperty("wind_degree")
    private int windDegree;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("pressure_mb")
    private double pressureMb;

    @JsonProperty("pressure_in")
    private double pressureIn;

    @JsonProperty("precip_mm")
    private double precipMm;

    @JsonProperty("precip_in")
    private double precipIn;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("cloud")
    private int cloudCoverage;

    @JsonProperty("windchill_c")
    private double windchill_c;

    @JsonProperty("windchill_f")
    private double windchill_f;

    @JsonProperty("heatindex_c")
    private double heatindex_c;

    @JsonProperty("heatindex_f")
    private double heatindex_f;

    @JsonProperty("dewpoint_c")
    private double dewpoint_c;

    @JsonProperty("dewpoint_f")
    private double dewpoint_f;

    @JsonProperty("feelslike_c")
    private double feelsLikeCelsius;

    @JsonProperty("feelslike_f")
    private double feelsLikeFahrenheit;

    @JsonProperty("vis_km")
    private double visibilityKm;

    @JsonProperty("vis_miles")
    private double visibilityMiles;

    @JsonProperty("uv")
    private double uvIndex;

    @JsonProperty("gust_mph")
    private double gustSpeedMph;

    @JsonProperty("gust_kph")
    private double gustSpeedKph;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class ConditionDTO {
    @JsonProperty("text")
    private String text;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("code")
    private int code;
}
