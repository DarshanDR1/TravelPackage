package com.example.application;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType type;
    public List<Activity> signedUpActivities;

    @Override
    public String toString() {
        return "Passenger [name=" + name + ", passengerNumber=" + passengerNumber + ", balance=" + balance + ", type="
                + type + ", signedUpActivities=" + signedUpActivities + "]";
    }

}

enum PassengerType {
    STANDARD, GOLD, PREMIUM
}