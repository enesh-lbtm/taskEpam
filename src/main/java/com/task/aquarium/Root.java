package com.task.aquarium;

import java.util.List;

public class Root {
    private String name;
    private List<Resident> resident;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Resident> getResident() {
        return resident;
    }

    public void setResident(List<Resident> resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", resident=" + resident +
                '}';
    }
}
