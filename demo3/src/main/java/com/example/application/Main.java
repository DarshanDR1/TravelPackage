package com.example.application;

import java.util.List;

/**
 * Main Class
 */
public class Main {
    public static void main(String[] args) {
        Activity activity1 = new Activity();
        activity1.setName("Trekking");
        activity1.setCost(2500.00);
        activity1.setCapacity(40);
        activity1.setDescription("4km of Trekking ");

        Activity activity2 = new Activity();
        activity2.setName("SkubaDiving");
        activity2.setCost(4000.00);
        activity2.setCapacity(30);
        activity2.setDescription("Skuba Diving for 30 mins");

        Activity activity3 = new Activity();
        activity3.setName("Site see and Boating");
        activity3.setCost(449.99);
        activity3.setCapacity(42);
        activity3.setDescription("Boating for 1hr && Site see");

        Activity activity4 = new Activity();
        activity4.setName("View Point");
        activity4.setCost(0.00);
        activity4.setCapacity(42);
        activity4.setDescription("Raja View Point ");

        Activity activity5 = new Activity();
        activity5.setName("Temple Visit");
        activity5.setCost(70.00);
        activity5.setCapacity(42);
        activity5.setDescription("Spend Temple till Departure");

        Destination destination1 = new Destination();
        destination1.setName("Bandajje");
        destination1.setActivities(List.of(activity1, activity4));

        Destination destination2 = new Destination();
        destination2.setName("Murudeshwara");
        destination2.setActivities(List.of(activity2, activity5));

        Destination destination3 = new Destination();
        destination3.setName("Honnavara");
        destination3.setActivities(List.of(activity2));

        Passenger passenger1 = new Passenger();
        passenger1.setName("Darshan");
        passenger1.setBalance(15000.00);
        passenger1.setPassengerNumber(1);
        // List.of(activity1, activity2, activity3, activity4, activity5)
        passenger1.setSignedUpActivities(List.of(activity1, activity4));
        passenger1.setType(PassengerType.STANDARD);

        Passenger passenger2 = new Passenger();
        passenger2.setName("Vinay");
        passenger2.setBalance(3900.00);
        passenger2.setPassengerNumber(2);
        // List.of(activity1, activity2, activity3, activity4, activity5)
        passenger2.setSignedUpActivities(List.of(activity2));
        passenger2.setType(PassengerType.GOLD);

        Passenger passenger3 = new Passenger();
        passenger3.setName("Bharath");
        passenger3.setBalance(100.00);
        passenger3.setPassengerNumber(3);
        // List.of(activity1, activity2, activity3, activity4, activity5)
        passenger3.setSignedUpActivities(List.of(activity2));
        passenger3.setType(PassengerType.PREMIUM);

        Passenger passenger4 = new Passenger();
        passenger4.setName("Sudeep");
        passenger4.setBalance(3500.00);
        passenger4.setPassengerNumber(3);
        // List.of(activity1, activity2, activity3, activity4, activity5)
        passenger4.setSignedUpActivities(List.of(activity1));
        passenger4.setType(PassengerType.GOLD);

        Passenger passenger5 = new Passenger();
        passenger5.setName("Amith");
        passenger5.setBalance(7100.00);
        passenger5.setPassengerNumber(3);
        // List.of(activity1, activity2, activity3, activity4, activity5)
        passenger5.setSignedUpActivities(List.of(activity2));
        passenger5.setType(PassengerType.GOLD);

        TravelPackage travelPackage = new TravelPackage(List.of(passenger1, passenger2, passenger3));
        travelPackage.setName("One Day to Murudeshwar");
        travelPackage.setPassengerCapacity(3);
        travelPackage.setItinerary(List.of(destination2));

        TravelPackage travelPackage1 = new TravelPackage();
        travelPackage1.setName("One Day to Bandajje");
        travelPackage1.setPassengerCapacity(5);
        travelPackage1.setItinerary(List.of(destination1));

        TravelPackage travelPackage2 = new TravelPackage();
        travelPackage2.setName("One Day to Honnavara");
        travelPackage2.setPassengerCapacity(4);
        travelPackage2.setItinerary(List.of(destination3));

        TravelPackage travelPackage3 = new TravelPackage();
        travelPackage3.setName("Two Day of Trip Honnavara and Murudeshwara");
        travelPackage3.setPassengerCapacity(4);
        travelPackage3.setItinerary(List.of(destination3, destination2));

        TravelPackage travelPackage4 = new TravelPackage();
        travelPackage4.setName("Three Days of Trip");
        travelPackage4.setPassengerCapacity(3);
        travelPackage4.setItinerary(List.of(destination3, destination1, destination2));
        System.out.println("Iternary List:");
        for (String ele : travelPackage.printItinerary()) {
            System.out.println(ele + "\n");
        }

        System.out.println("Passenger Details: \n" + travelPackage.printPassengerDetails(passenger5) + "\n");
        travelPackage.printPassengerList();

        System.out.println("Printing Passnger List: \n");
        for (String ele : travelPackage.printPassengerList()) {
            System.out.println(ele + "\n");
        }

        System.out.println(travelPackage.signUpForActivity(passenger5, activity5));
        // travelPackage.signUpForActivity(passenger5, activity5); // Checking for
        // singingup

    }

}
