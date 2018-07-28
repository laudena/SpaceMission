package com.company;


import java.util.Random;

/*
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)

* */
public class Falcon1 extends Rocket {

    public Falcon1(){ super(100000000, 10000, 18000); }
    @Override
    public boolean launch() {
        Random rand = new Random();
        double res = rand.nextLong();
        //Chance of launch explosion = 5% * (cargo carried / cargo limit)
        double explosionProb = 0.05 * this.getCargoWeight() / this.getCargoWeightUsage();
        if (res < explosionProb)
            return true;
        else
            return false;
    }

    @Override
    public boolean land() {
        Random rand = new Random();
        double res = rand.nextLong();
        //Chance of launch explosion = 5% * (cargo carried / cargo limit)
        double explosionProb = 0.01 * this.getCargoWeight() / this.getCargoWeightUsage();
        if (res < explosionProb)
            return true;
        else
            return false;
    }
}
