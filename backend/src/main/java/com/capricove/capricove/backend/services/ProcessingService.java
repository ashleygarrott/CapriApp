package com.capricove.capricove.backend.services;

import com.capricove.capricove.backend.data.Coordinate;
import com.capricove.capricove.backend.data.DeliveryDTO;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProcessingService {

    @Autowired
    GeoAPIService geoAPIService;


    public DeliveryDTO getDeliveryDTO(Coordinate coordinate) throws InterruptedException, ApiException, IOException {
        String[] cpc = {"Capri Cove Cafe and Restaurant"};
        String[] dest = {Double.toString(coordinate.getLatitude()) + "," + Double.toString(coordinate.getLongitude())};

        try{
            DistanceMatrix distanceMatrix = DistanceMatrixApi.getDistanceMatrix(geoAPIService.getContext(), cpc, dest).await();
            String destination = "";//distanceMatrix.destinationAddresses[0];
            DistanceMatrixRow[] distanceMatrixRows = distanceMatrix.rows;
            DistanceMatrixRow distanceMatrixRow = distanceMatrixRows[0];
            DistanceMatrixElement distanceMatrixElement = distanceMatrixRow.elements[0];
            Duration duration = new Duration(); //distanceMatrixElement.duration;
            Distance distance = new Distance(); //distanceMatrixElement.distance;
            int deliveryFee = calculateDeliveryFee((int) distance.inMeters);
            return new DeliveryDTO(distance, duration, destination, deliveryFee);
        }
        catch(Exception e){
            return new DeliveryDTO();
        }


    }

    public int calculateDeliveryFee(int distance) {
        return 15;
    }
}
