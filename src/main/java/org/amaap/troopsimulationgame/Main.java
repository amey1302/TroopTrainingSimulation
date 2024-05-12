package org.amaap.troopsimulationgame;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.service.ArmyCampService;
import org.amaap.troopsimulationgame.service.BarrackService;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidTroopDataException {
        Injector injector = Guice.createInjector(new TroopModule());
        BarrackService barrackService = injector.getInstance(BarrackService.class);
        ArmyCampService armyCampService = injector.getInstance(ArmyCampService.class);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("troop-training > start-training");
            System.out.println("1. train troops ");
            System.out.println("2. view troop camp");
            System.out.println("3. exit");
            System.out.print("What do you want to do ? ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Archer");
                    System.out.println("2. Barbarian");
                    System.out.print("Which troop do you want to train ? ");
                    int troopChoice = scanner.nextInt();
                    System.out.print("How many troops do you want to train ? ");
                    int troopCount = scanner.nextInt();

                    String troopType;
                    switch (troopChoice) {
                        case 1:
                            troopType = "Archer";
                            break;
                        case 2:
                            troopType = "Barbarian";
                            break;
                        default:
                            System.out.println("Invalid troop choice.");
                            continue;
                    }

                    barrackService.create(troopCount, troopType);
                    barrackService.train();
                    armyCampService.calculateTroopCount("archer");
                    armyCampService.calculateTroopCount("barbarian");
                    break;

                case 2:
                    System.out.println("Trained Archer:" + armyCampService.getTroopersCountFor("archer"));
                    System.out.println("Trained Barbarian:" + armyCampService.getTroopersCountFor("barbarian"));
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for Using Troop Simulation Game!!");
    }

}

