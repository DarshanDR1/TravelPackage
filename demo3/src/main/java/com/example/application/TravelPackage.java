package com.example.application;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage() {
    }

    public TravelPackage(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<String> printItinerary() {
        List<String> destList = new ArrayList<>();
        for (Destination element : itinerary) {
            destList.add(element.toString());
        }
        return destList;

    }

    public List<String> printPassengerList() {
        List<String> passengerList = new ArrayList<>();

        for (Passenger listOfpassengers : passengers) {
            passengerList.add(listOfpassengers.toString());
        }
        return passengerList;
    }

    public String printPassengerDetails(Passenger passenger) {
        return passenger.toString();
    }

    public List<String> printAvailableActivities() {
        List<String> activityList = new ArrayList<>();
        for (Destination element : itinerary) {
            for (Activity activities : element.getActivities()) {
                activityList.add(activities.toString());
            }
        }
        return activityList;
    }

    public Boolean signUpForActivity(Passenger passenger, Activity activity) {
        boolean singupValue = false;
        if (activity.getCapacity() > 0) {
            boolean x = passenger.getSignedUpActivities().stream().anyMatch(act -> act != null &&
                    activity.getName() != null &&
                    act.getName().equalsIgnoreCase(activity.getName()));
            if (!x) {

                switch (passenger.getType().toString()) {
                    case "GOLD":
                        if (passenger.getBalance() >= ((double) 90 / (double) 100) * activity.getCost()) {
                            List<Activity> actvity = new ArrayList<>();
                            int i = 0;
                            while (i < passenger.getSignedUpActivities().size()) {
                                actvity.add(passenger.getSignedUpActivities().get(i));
                                i++;
                            }
                            actvity.add(activity);
                            passenger.setSignedUpActivities(actvity);
                            passenger.setBalance(passenger.getBalance() - ((double) 90 / (double) 100)
                                    * activity.getCost());
                            activity.setCapacity(activity.getCapacity() - 1);
                            System.out.println(passenger.getName() + " has Singed up for activity");
                            singupValue = true;
                        } else {

                            System.out.println("Balance not sufficient");
                        }

                        break;
                    case "STANDARD":
                        if (passenger.getBalance() >= activity.getCost()) {
                            List<Activity> actvity = passenger.getSignedUpActivities();
                            actvity.add(activity);
                            passenger.setSignedUpActivities(actvity);
                            passenger.setBalance(passenger.getBalance() - activity.getCost());
                            activity.setCapacity(activity.getCapacity() - 1);
                            System.out.println(passenger.getName() + " has Singed up for activity");
                            singupValue = true;

                        } else {
                            System.out.println("Balance not sufficient");
                        }

                        break;
                    case "PREMIUIM":

                        List<Activity> actvity = passenger.getSignedUpActivities();
                        actvity.add(activity);
                        passenger.setSignedUpActivities(actvity);
                        activity.setCapacity(activity.getCapacity() - 1);
                        System.out.println(passenger.getName() + " has Singed up for " + activity.getName());
                        singupValue = true;

                        break;

                    default:

                        break;
                }

            } else {
                System.out.println("Already Enroled for this Activity");
            }
        } else {
            System.out.println("Reached its maximum capacity");
        }
        return singupValue;
    }

    @Override
    public String toString() {
        return "TravelPackage [name=" + name + ", passengerCapacity=" + passengerCapacity + ", itinerary=" + itinerary
                + ", passengers=" + passengers + "]";
    }
}
