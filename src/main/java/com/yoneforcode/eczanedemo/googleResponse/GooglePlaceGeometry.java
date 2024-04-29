package com.yoneforcode.eczanedemo.googleResponse;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GooglePlaceGeometry {
    private GooglePlaceLocation location;

    public GooglePlaceLocation getLocation() {
        return location;
    }

    public void setLocation(GooglePlaceLocation location) {
        this.location = location;
    }
}
