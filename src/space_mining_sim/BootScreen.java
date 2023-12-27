package space_mining_sim;

import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

public class BootScreen {
	
	// test comment for github
	
	
	
	//add window later


	

    public static void main(String[] args) throws InterruptedException {
        
    	
    	// add window later
//        // Schedule a job for the event dispatch thread:
//        // creating and showing this application's GUI.
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
    	
    	
    	final int loadingBarWidth = 30; // The width of the loading bar
        final int sleepTime = 1000 / loadingBarWidth; // Time to sleep in milliseconds
        final int infinityTimerStop = 200;
        boolean loadingSuccessful = false;
        
        
        finances_player playerFinances = new finances_player();
        ship_stats shipStats_instance = new ship_stats();
        Shop_space_mining_sim shop = new Shop_space_mining_sim();
        mining_expedition_simulation miningExpedition = new mining_expedition_simulation();
        timeManager timeManager_instance = new timeManager();

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
          // System.out.println(timeManager_instance.printCurrentDate());
           timeManager_instance.printCurrentDate();
           
           Scanner scanner = new Scanner(System.in);
           String input = ""; // Declare input before the loop

           while (!input.equals("exit")) {
               System.out.println("Press 'a' to see ship stats");
               System.out.println("Press 'v' to view your ship");
               System.out.println("Press 'f' to view your finances");
               System.out.println("Press 'e' to go on a mining expedition");
               System.out.println("Press 'r' to refuel");
               System.out.println("Press 's' to access store");
               System.out.println("Press 'l' for leasson you ought to remember");
               System.out.println("Type 'exit' to quit");

               input = scanner.nextLine(); // Assign new input value here, don't redeclare

               
               
               //ship_stats shipStats_instance = new ship_stats();
               ascii_art ascii_art = new ascii_art();
               Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();
              // finances_player finances_player = new finances_player();
              // finances_player playerFinances = new finances_player();
               mining_expedition_simulation mining_expedition_instance = new mining_expedition_simulation();
               
               
               

               // Use switch statement to handle the input
               switch (input) {
                   case "a":
                       shipStats_instance.displayStats();
                       break;
                   case "v":
                       ascii_art.ascii_spaceship();
                       break;
                   case "f":
                	   playerFinances.print_finances();
                       break;
                   case "r":
                	   spaceship_parts_store_instance.refuel_spaceship(shipStats_instance, playerFinances);
                	   break;
                   case "l":
                	   shipStats_instance.test_for_parameter(spaceship_parts_store_instance);
                	   break;
                   case "e":
                	   
                	   //mining_expedition_instance.go_on_mining_expedition(playerFinances, shipStats_instance);
                	   mining_expedition_instance.select_where_go_mining(playerFinances, shipStats_instance, shop, timeManager_instance);

                	   shipStats_instance.wear_and_tear(); // Apply wear and tear after expedition
                	   shipStats_instance.fuel_comsumption();
                	   shipStats_instance.displayStats();
                	   playerFinances.print_finances();
                	   // Print the updated date after a mining expedition
                	    timeManager_instance.printCurrentDate();
                	   
                	   
                       break;
                   case "s":
                	   
                	   spaceship_parts_store_instance.spaceship_parts_store(playerFinances);
                       break;
                   case "p":
                	   
                	   playerFinances.payOffPlayerDebt();
                	   playerFinances.print_finances();
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
    
    
    
    
    
   // add window later 


}
