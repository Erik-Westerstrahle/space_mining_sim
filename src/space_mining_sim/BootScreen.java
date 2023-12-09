package space_mining_sim;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class BootScreen {
	

    public static void main(String[] args) throws InterruptedException {
    	
    	
    	
    	
    	
        final int loadingBarWidth = 30; // The width of the loading bar
        final int sleepTime = 1000 / loadingBarWidth; // Time to sleep in milliseconds
        final int infinityTimerStop = 200;
        boolean loadingSuccessful = false;
        finances_player playerFinances = new finances_player();

        System.out.println("Booting Spaceship OS...");
        try {

        // Display an ASCII loading bar
        for (int i = 0; i <= loadingBarWidth; i++) {
            System.out.print("\r[");
            int j = 0;
            for (; j < i; j++) {
                System.out.print("#");
            }
            for (; j < loadingBarWidth; j++) {
                System.out.print(" ");
            }
            System.out.print("]");
            Thread.sleep(sleepTime); // Pause to simulate loading time
        }
        loadingSuccessful = true;
       } catch (InterruptedException e) {
           System.err.println("\nError during loading: " + e.getMessage());
           // Handle the error as needed
       }
       if (loadingSuccessful) {
           System.out.println("\nBoot Complete. Welcome to Spaceship OS!");
           System.out.println(" ");
           
           Scanner scanner = new Scanner(System.in);
           String input = ""; // Declare input before the loop

           while (!input.equals("exit")) {
               System.out.println("Press 'a' to see ship stats");
               System.out.println("Press 'v' to view your ship");
               System.out.println("Press 'f' to view your finances");
               System.out.println("Press 'e' to go on a mining expedition");
               System.out.println("Type 'exit' to quit");

               input = scanner.nextLine(); // Assign new input value here, don't redeclare

               ship_stats stats = new ship_stats();
               ascii_art ascii_art = new ascii_art();
               shop_spaceship_parts spaceship_parts_store_instance = new shop_spaceship_parts();
              // finances_player finances_player = new finances_player();
              // finances_player playerFinances = new finances_player();
               mining_expedition_simulation mining_expedition = new mining_expedition_simulation();

               // Use switch statement to handle the input
               switch (input) {
                   case "a":
                       stats.displayStats();
                       break;
                   case "v":
                       ascii_art.ascii_spaceship();
                       break;
                   case "f":
                	   playerFinances.print_finances();
                       break;
                   case "e":
                	   
                	   mining_expedition.go_on_mining_expedition(playerFinances);
                       break;
                   case "s":
                	   
                	   spaceship_parts_store_instance.spaceship_parts_store();
                       break;
                   default:
                       System.out.println("Invalid command.");
                       break;
               }
           }

           scanner.close(); // Close the scanner after the loop

           
           
       } else {
           System.out.println("\nBoot Failed. Please try again or contact support.");
       }

     //   System.out.println("\nBoot Complete. Welcome to Spaceship OS!");
    }
}

