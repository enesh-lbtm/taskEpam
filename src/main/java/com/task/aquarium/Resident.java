package com.task.aquarium;

public class Resident {
    private String name;
    private int quantity;
    private int coast;

    public Resident(String name, int quantity, int coast) {
        this.name = name;
        this.quantity = quantity;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + coast +
                '}';
    }
}
