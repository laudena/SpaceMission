package com.company;


import java.util.Random;

/*
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)

* */
public class Falcon2 extends Rocket {

    public Falcon2(){
        super(120000000, 18000, 29000);
    }
    @Override
    public boolean launch() {
        Random rand = new Random();
        double res = rand.nextLong();
        //Chance of launch explosion = 4% * (cargo carried / cargo limit)
        double explosionProb = 0.04 * this.getCargoWeight() / this.getCargoWeightUsage();
        if (res < explosionProb)
            return true;
        else
            return false;
    }

    @Override
    public boolean land() {
        Random rand = new Random();
        double res = rand.nextLong();
        //Chance of launch explosion = 8% * (cargo carried / cargo limit)
        double explosionProb = 0.08 * this.getCargoWeight() / this.getCargoWeightUsage();
        if (res < explosionProb)
            return true;
        else
            return false;
    }
}
