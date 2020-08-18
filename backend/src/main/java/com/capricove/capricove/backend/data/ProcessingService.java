package com.capricove.capricove.backend.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ProcessingService {

    @Autowired
    GeoAPIService geoAPIService;


    public DeliveryDTO getDeliveryDTO(String location) throws InterruptedException, ApiException, IOException {
        String[] cpc = {"Capri Cove Cafe and Restaurant"};
        String[] dest = {"Mahidol University"};

        try{
            DistanceMatrix distanceMatrix = DistanceMatrixApi.getDistanceMatrix(geoAPIService.getContext(), cpc, new String[]{location}).await();
            String destination = distanceMatrix.destinationAddresses[0];
            DistanceMatrixRow[] distanceMatrixRows = distanceMatrix.rows;
            DistanceMatrixRow distanceMatrixRow = distanceMatrixRows[0];
            DistanceMatrixElement distanceMatrixElement = distanceMatrixRow.elements[0];
            Duration duration = distanceMatrixElement.duration;
            Distance distance = distanceMatrixElement.distance;
            int deliveryFee = calculateDeliveryFee((int) distance.inMeters);
            return new DeliveryDTO(distance, duration, destination, deliveryFee);
        }
        catch(Exception e){
            return new DeliveryDTO();
        }


    }

    public int calculateDeliveryFee(int distance) {
        return 0;
    }
}
