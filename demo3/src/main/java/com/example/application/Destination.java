package com.example.application;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destination {
    private String name;
    private List<Activity> activities;

    @Override
    public String toString() {
        return "Destination [name=" + name + ", activities=" + activities + "]";
    }
}
