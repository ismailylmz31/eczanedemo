package com.yoneforcode.eczanedemo.service;

import com.yoneforcode.eczanedemo.entity.Pharmacy;
import com.yoneforcode.eczanedemo.googleResponse.GooglePlaceResult;
import com.yoneforcode.eczanedemo.googleResponse.GooglePlacesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@Service
public class PharmacySearchService {

    @Value("${google.api.key}")
    private String apiKey;

    //private final String API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location={latitude},{longitude}&radius={radius}&type={type}&keyword={keyword}&key={apiKey}";
    private final String API_KEY = "AIzaSyBV84Yaw5YZhQDZCWlUOAxfYErWumJkAXk";
    private final String API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location={latitude},{longitude}&radius={radius}&type={type}&keyword={keyword}&key=" + API_KEY;




    private final RestTemplate restTemplate;

    public PharmacySearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Pharmacy> findNearbyPharmacies(double latitude, double longitude, int radius) {
        String url = API_URL
                .replace("{latitude}", String.valueOf(latitude))
                .replace("{longitude}", String.valueOf(longitude))
                .replace("{radius}", String.valueOf(radius))
                .replace("{type}", "pharmacy")
                .replace("{keyword}", "pharmacy")
                .replace("{apiKey}", apiKey);

        ResponseEntity<GooglePlacesResponse> responseEntity = restTemplate.getForEntity(url, GooglePlacesResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            GooglePlacesResponse response = responseEntity.getBody();
            if (response != null && response.getResults() != null) {
                return mapToPharmacyList(response.getResults());
            }
        }
        return null;
    }

    private List<Pharmacy> mapToPharmacyList(GooglePlaceResult[] results) {
        return Arrays.stream(results)
                .map(result -> {
                    Pharmacy pharmacy = new Pharmacy();
                    pharmacy.setName(result.getName());
                    pharmacy.setAddress(result.getVicinity());
                    pharmacy.setLatitude(result.getGeometry().getLocation().getLat());
                    pharmacy.setLongitude(result.getGeometry().getLocation().getLng());
                    return pharmacy;
                })
                .toList();
    }
}

