package com.capricove.capricove.backend.data;

import com.google.maps.model.Distance;
import com.google.maps.model.Duration;

public class DeliveryDTO {

    private Distance distance;
    private Duration duration;
    private String destination;
    private int deliveryFee;

    public DeliveryDTO(){
        this.distance = null;
        this.duration = null;
        this.destination = null;
    }

    public DeliveryDTO(Distance distance, Duration duration, String destination, int deliveryFee) {
        this.distance = distance;
        this.duration = duration;
        this.destination = destination;
        this.deliveryFee = deliveryFee;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
}
