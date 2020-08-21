package com.capricove.capricove.backend.services;

import com.google.maps.GeoApiContext;
import org.springframework.stereotype.Service;

@Service
public class GeoAPIService {

    private GeoApiContext context;


    GeoAPIService(){
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyCi9xPyMPms_3MrowQQmyvSzMZnZr9eLvs")
                .build();

        this.context = context;
    }

    public GeoApiContext getContext() {
        return context;
    }

    public void setContext(GeoApiContext context) {
        this.context = context;
    }





}
