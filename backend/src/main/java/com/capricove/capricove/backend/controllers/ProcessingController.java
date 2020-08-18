package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.DeliveryDTO;
import com.capricove.capricove.backend.data.ProcessingService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrixRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/processor")
public class ProcessingController {

    @Autowired
    ProcessingService processingService;

    @PostMapping("/get_delivery_fee")
    public DeliveryDTO getDeliveryInfo(String location) throws InterruptedException, ApiException, IOException {
        return processingService.getDeliveryDTO(location);
    }
}
