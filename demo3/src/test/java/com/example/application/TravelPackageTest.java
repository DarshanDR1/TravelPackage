package com.example.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TravelPackageTest {
    Activity activity1 = new Activity();
    Activity activity2 = new Activity();
    Destination destination1 = new Destination();
    Passenger passenger1 = new Passenger();
    Passenger passenger2 = new Passenger();
    Passenger passenger3 = new Passenger();

    TravelPackage travelPackage = new TravelPackage(List.of(passenger1, passenger2, passenger3));

    void utilityFunction() {
        activity1.setName("Trekking");
        activity1.setCost(2500.00);
        activity1.setCapacity(40);
        activity1.setDescription("4km of Trekking ");

        activity2.setName("SkubaDiving");
        activity2.setCost(4000.00);
        activity2.setCapacity(30);
        activity2.setDescription("Skuba Diving for 30 mins");

        destination1.setName("Murudeshwara");
        destination1.setActivities(List.of(activity1, activity2));

        passenger1.setName("Darshan");
        passenger1.setBalance(15000.00);
        passenger1.setPassengerNumber(1);
        passenger1.setSignedUpActivities(List.of(activity1, activity2));
        passenger1.setType(PassengerType.STANDARD);

        passenger2.setName("Vinay");
        passenger2.setBalance(3900.00);
        passenger2.setPassengerNumber(2);
        passenger2.setSignedUpActivities(List.of(activity2));
        passenger2.setType(PassengerType.GOLD);

        passenger3.setName("Bharath");
        passenger3.setBalance(100.00);
        passenger3.setPassengerNumber(3);
        passenger3.setSignedUpActivities(List.of(activity2));
        passenger3.setType(PassengerType.PREMIUM);

        travelPackage.setName("One Day to Murudeshwar");
        travelPackage.setPassengerCapacity(3);
        travelPackage.setItinerary(List.of(destination1));
    }

    @Test
    public void printIternaryTest() {
        utilityFunction();
        assertTrue(travelPackage.printItinerary().get(0).contains("Murudeshwara"));
    }

    @Test
    public void printPassengerDetailsTest() {
        utilityFunction();
        assertTrue(travelPackage.printPassengerDetails(passenger3).contains("Bharath"));
        // assertEquals(3, travelPackage.printPassengerDetails());
    }

    @Test
    public void printPassengerListTest() {
        utilityFunction();
        assertEquals(3, travelPackage.printPassengerList().size());
    }

    @Test
    public void printAvailableActivitiesTest() {
        utilityFunction();
        assertEquals(2, travelPackage.printAvailableActivities().size());
    }

    @Test
    public void checksignUpForActivityTest() {
        utilityFunction();
        assertFalse(travelPackage.signUpForActivity(passenger1, activity1)); // Already enroled
    }

    @Test
    public void checksignUpForActivityTest2() {
        utilityFunction();
        assertTrue(travelPackage.signUpForActivity(passenger2, activity1)); // Enroled for Activity
    }
}
