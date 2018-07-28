package com.company;
import java.util.*;

public class Rocket implements ISpaceship {
    private static int rocketNumner = 0;
    private double cost;
    private double ownWeight;
    private double maxWeight;
    private List<Item> cargo = new ArrayList<Item>();


    public Rocket(double cost, double ownWeight, double maxWeight){
        rocketNumner++;
        this.cost = cost;
        this.ownWeight = ownWeight;
        this.maxWeight = maxWeight;
        this.cargo.clear();
    }

    public static int getRocketNumner() {
        return rocketNumner;
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
            this.cargo.add(item);
            return true;
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
        boolean result = weight + this.getCargoWeight() + this.ownWeight <= this.maxWeight;
        //System.out.println( "w:" + weight + " c:"+ this.getCargoWeight() + " own:" + this.ownWeight + " max:" +this.maxWeight + " RESULT:" + result);
        if (result)
            return true;
        else
            return false;
    }
    protected double getCargoWeightUsage()
    {
        //System.out.println("usage:" + (int) (100 * this.getCargoWeight() / (this.maxWeight - this.ownWeight)));
        return this.getCargoWeight() / (this.maxWeight - this.ownWeight);

    }

    public double getCost() {
        return cost;
    }
}
