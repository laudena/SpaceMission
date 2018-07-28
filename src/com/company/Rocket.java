package com.company;
import java.util.*;

public class Rocket implements ISpaceship {
    private double cost;
    private double ownWeight;
    private double maxWeight;
    private List<Item> cargo = new ArrayList<Item>();


    public Rocket(double cost, double ownWeight, double maxWeight){
        this.cost = cost;
        this.ownWeight = ownWeight;
        this.maxWeight = maxWeight;
        this.cargo.clear();
    }
    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return checkExtraWeight(item.getWeight());
    }

    public boolean carry(Item item) {
        if (checkExtraWeight(item.getWeight())) {
            this.cargo.add(item);
            return true;
        }
        else{
            return false;
        }
    }
    public List<Item> getCargo() {
        return cargo;
    }
    public double getCargoWeight(){

        double total = 0;
        for (Item item : this.cargo){
          total += item.getWeight();
        }
        return total;
    }
    private boolean checkExtraWeight(double weight)
    {
        if (weight + this.getCargoWeight() + this.ownWeight <= this.maxWeight)
            return true;
        else
            return true;
    }
    protected double getCargoWeightUsage()
    {
        return this.getCargoWeight() / (this.maxWeight - this.ownWeight);

    }
}
