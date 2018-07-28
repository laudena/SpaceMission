package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int simulationsCount = 1000;
        String file1 = "D:\\Documents\\GitHub\\SpaceMissionSimulation\\SpaceMission\\src\\com\\company\\phase1.txt";
        String file2 = "D:\\Documents\\GitHub\\SpaceMissionSimulation\\SpaceMission\\src\\com\\company\\phase2.txt";
        try {
            System.out.println("*** Simulation Started ***");
            Simulation sim1 = new Simulation();
            Simulation sim2 = new Simulation();

            double averageCost = 0;
            double averageExplosions= 0;

            ArrayList<Item> itemList = sim1.loadItems(file1);
            ArrayList<Rocket> rocketList = sim1.loadFalcon_1_Rockets(itemList);
            for (int i=0 ; i < simulationsCount ; i++) {
                double cost1 = sim1.runSimulation(rocketList);
                averageCost += cost1 / simulationsCount;
                averageExplosions += (double)(sim1.getExplosions()) / simulationsCount;
            }
            itemList = sim2.loadItems(file2);
            rocketList = sim2.loadFalcon_1_Rockets(itemList);
            for (int i=0 ; i < simulationsCount ; i++) {
                double cost2 = sim2.runSimulation(rocketList);
                averageCost += cost2 / simulationsCount;
                averageExplosions += (double)(sim2.getExplosions()) / simulationsCount;
            }
            System.out.printf("\nTotal average cost of Falcon-1: M$%.0f, average explosions: %.2f" ,averageCost/1000000, averageExplosions);

            itemList = sim1.loadItems(file1);
            rocketList = sim1.loadFalcon_2_Rockets(itemList);
            averageCost = 0;
            for (int i=0 ; i < simulationsCount ; i++) {
                double cost1 = sim1.runSimulation(rocketList);
                averageCost += cost1 / simulationsCount;
                averageExplosions += (double)(sim1.getExplosions()) / simulationsCount;
            }
            itemList = sim2.loadItems(file2);
            rocketList = sim2.loadFalcon_2_Rockets(itemList);
            for (int i=0 ; i < simulationsCount ; i++) {
                double cost2 = sim2.runSimulation(rocketList);
                averageCost += cost2 / simulationsCount;
                averageExplosions += (double)(sim2.getExplosions()) / simulationsCount;
            }
            System.out.printf("\nTotal average cost of Falcon-2: M$%.0f, average explosions: %.2f" ,averageCost/1000000, averageExplosions);


        }
        catch (FileNotFoundException ex){
            System.out.println("Bad file name. " + ex.getMessage());
        }
    }
}
