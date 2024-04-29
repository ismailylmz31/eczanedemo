package com.yoneforcode.eczanedemo.googleResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GooglePlaceResult {

    private String name;
    private String vicinity;
    private GooglePlaceGeometry geometry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public GooglePlaceGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GooglePlaceGeometry geometry) {
        this.geometry = geometry;
    }
}
