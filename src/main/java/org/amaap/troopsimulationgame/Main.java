package org.amaap.troopsimulationgame;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.controller.ArmyCampController;
import org.amaap.troopsimulationgame.controller.BarrackController;
import org.amaap.troopsimulationgame.service.ArmyCampService;
import org.amaap.troopsimulationgame.service.BarrackService;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidTroopDataException {
        Injector injector = Guice.createInjector(new TroopModule());
        BarrackService barrackService = injector.getInstance(BarrackService.class);
        BarrackController barrackController = injector.getInstance(BarrackController.class);
        ArmyCampService armyCampService = injector.getInstance(ArmyCampService.class);
        ArmyCampController armyCampController = injector.getInstance(ArmyCampController.class);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("troop-training > start-training");
            System.out.println("1. Train troops");
            System.out.println("2. View troop camp");
            System.out.println("3. Exit");
            System.out.print("What do you want to do? ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int troopChoice = 0;
                    while (true) {
                        System.out.println("1. Archer");
                        System.out.println("2. Barbarian");
                        System.out.print("Which troop do you want to train? ");
                        troopChoice = scanner.nextInt();
                        if (troopChoice == 1 || troopChoice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid troop choice. Please enter 1 for Archer or 2 for Barbarian.");
                        }
                    }

                    int troopCount = 0;
                    boolean validCount = false;
                    while (!validCount) {
                        System.out.print("How many troops do you want to train? ");
                        troopCount = scanner.nextInt();
                        try {
                            if (troopCount <= 0) {
                                throw new InvalidTroopCountException("" + troopCount);
                            }
                            if (troopCount > 10) {
                                System.out.println("Maximum 10 troops can be trained. Please enter a valid number.");
                            } else {
                                validCount = true;
                            }
                        } catch (InvalidTroopCountException e) {
                            System.out.println("Troop count must be greater than zero. Please enter a valid number.");
                        }
                    }

                    String troopType = (troopChoice == 1) ? "Archer" : "Barbarian";

                    barrackController.create(troopCount, troopType);
                    barrackController.trainTroopers();
                    armyCampService.calculateTroopCount("archer");
                    armyCampService.calculateTroopCount("barbarian");
                    break;

                case 2:
                    System.out.println("Trained Archer: " + armyCampService.getTroopersCountFor("archer"));
                    System.out.println("Trained Barbarian: " + armyCampService.getTroopersCountFor("barbarian"));
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using Troop Simulation Game!!");
    }
}
