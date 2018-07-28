package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import java.util.ArrayList;

public class Simulation {

    private int explosions = 0;
    //constructor
    public Simulation() {
    }

    //load items from file
    public ArrayList<Item> loadItems(String filePath) throws FileNotFoundException {
        ArrayList<Item> output = new ArrayList<>();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] elements = line.split("=");
            String itemName = elements[0];
            double itemWeight = Double.parseDouble(elements[1]);
            output.add(new Item(itemName, itemWeight));
        }
        //cargoItems = output;
        return output;
    }

    public ArrayList<Rocket> loadFalcon_1_Rockets(ArrayList<Item> cargoItems) {
        ArrayList<Rocket> spaceShips = new ArrayList<>();
        Rocket rocket = new Falcon1();
        for (Item item : cargoItems) {
            if (!rocket.canCarry(item)) {
                spaceShips.add(rocket);
                //System.out.println("loaded rocket #" + rocket.getRocketNumner());
                rocket = new Falcon1();
            } else {
                rocket.carry(item);
            }
        }
        spaceShips.add(rocket);
        // System.out.println("loaded rocket #" + rocket.getRocketNumner());
        return spaceShips;
    }
    public ArrayList<Rocket> loadFalcon_2_Rockets(ArrayList<Item> cargoItems) {
        ArrayList<Rocket> spaceShips = new ArrayList<>();
        Rocket rocket = new Falcon2();
        for (Item item : cargoItems) {
            if (!rocket.canCarry(item) && spaceShips.size() < 100) {
                spaceShips.add(rocket);
                //System.out.println("loaded rocket #" + rocket.getRocketNumner());
                rocket = new Falcon2();
            } else {
                rocket.carry(item);
            }
        }
        //System.out.println("loaded rocket #" + rocket.getRocketNumner());
        spaceShips.add(rocket);
        return spaceShips;
    }
    public double runSimulation (ArrayList<Rocket> spaceShips)
    {
        double cost = 0;
        int count =0 ;
        int successfullRockets =0;
        for (Rocket spaceShip : spaceShips){
            while (!spaceShip.launch() || !spaceShip.land())
            {
                //System.out.print("Boom!!!!");
                cost += spaceShip.getCost();
                count++;
            }
            cost += spaceShip.getCost();
            count++;
            successfullRockets++;
        }
        //System.out.println("Rockets built:" + count +". Landed in Mars: " + successfullRockets);
        this.explosions = count - successfullRockets;
        return cost;
    }

    public int getExplosions() {
        return this.explosions;
    }


}
