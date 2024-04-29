package com.yoneforcode.eczanedemo.googleResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GooglePlacesResponse {

    private GooglePlaceResult[] results;

    public GooglePlaceResult[] getResults() {
        return results;
    }

    public void setResults(GooglePlaceResult[] results) {
        this.results = results;
    }
}

