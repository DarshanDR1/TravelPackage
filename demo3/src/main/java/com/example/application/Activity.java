package com.example.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    private String name;
    private String description;
    private double cost;

    @Override
    public String toString() {
        return "Activity [name=" + name + ", description=" + description + ", cost=" + cost + ", capacity=" + capacity
                + "]";
    }

    private int capacity;
}
