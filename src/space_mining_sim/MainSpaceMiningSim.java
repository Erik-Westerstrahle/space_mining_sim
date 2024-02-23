package space_mining_sim;

import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class MainSpaceMiningSim {
	
// TODO

	// 



	// make the event system more effivent
	// add better ways to store data
	// add more story descriptions

// Done
	// add astrogator player skill lowers travel time
	// make mining expedition code more cleaner
	// add more events
	

    public static void main(String[] args) throws InterruptedException, LineUnavailableException, IOException {
        
    	

    	
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";
    	
    	
    	final int loadingBarWidth = 30; // The width of the loading bar
        final int sleepTime = 1000 / loadingBarWidth; // Time to sleep in milliseconds
        final int infinityTimerStop = 200;
        boolean loadingSuccessful = false;
        
        
     // Creating instances of the game's main components
        finances_player playerFinances = new finances_player();
    
        Shop_space_mining_sim shop_instance = new Shop_space_mining_sim();
        ship_stats shipStats_instance = new ship_stats(shop_instance);
        shop_instance.setShipStatsInstance(shipStats_instance); // this exists for dependincis
   
        playerStats playerStatsInstance = new playerStats(); 
        timeManager timeManager_instance = new timeManager();
        mining_expedition_simulation miningExpedition = new mining_expedition_simulation(timeManager_instance, playerStatsInstance, shipStats_instance);
        SaveLoadSystem SaveLoadSystemInstance = new SaveLoadSystem();
        SoundGenerator SoundGeneratorInstance = new SoundGenerator();
        hireAstronauts hireAstronautsInstance = new hireAstronauts();
        EventManager eventManagerInstance = new EventManager(shipStats_instance, timeManager_instance, playerFinances);

     //   Shop_space_mining_sim shop_instance = new Shop_space_mining_sim();
        
        
        // Generate and save astronauts at the start of the program
        generateAndSaveAstronauts();
        
     // If loading is successful, display welcome messages and load game data
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
           System.out.println("Welcome to my game ");
           System.out.println("You have bought a mining space ship and you need to pay of your debt by mining to complete the game ");
           
           shipStats_instance.updateShipFeatures();
           
           SaveLoadSystemInstance.loadGame(playerFinances, shipStats_instance,shop_instance, playerStatsInstance);
   
           
           Scanner scanner = new Scanner(System.in);
           String input = ""; // Declare input before the loop
           
           // Main game loop
           while (!input.equals("exit")) {
        	   timeManager_instance.printCurrentDate();
        	   System.out.println("Type 'help' to see available commands");
//        	   System.out.println("time unil next debt payment is "+timeManager_instance.getTimeUnitlDeadline());
//               System.out.println("Press 'a' to see ship stats");
//               System.out.println("Press 'v' to view your ship");
//               System.out.println("Press 'f' to view your finances");
//               System.out.println("Press 'e' to go on a mining expedition");
//               System.out.println("Press 'r' to refuel");
//               System.out.println("Press 'b' to access store");
//               System.out.println("Press 'p' to pay of your debts");
//               System.out.println("Press 's' to save the game");
//               System.out.println("Press 'l' to load the game");
//               System.out.println("Press 'h' to hire astronauts");
//               System.out.println("Press 'view' to see hired astronauts");
//               System.out.println("Press 'c' to view your stats");
             //  System.out.println("Press 'k' for leasson you ought to remember");
               System.out.println("Type 'exit' to quit");

               input = scanner.nextLine(); // Assign new input value here, don't redeclare

               
               
          
               ascii_art ascii_art = new ascii_art();
   
               mining_expedition_simulation mining_expedition_instance = new mining_expedition_simulation(timeManager_instance, playerStatsInstance, shipStats_instance);
               
               
               
               
               

               // Use switch statement to handle the input
               switch (input) {
                   case "a":
                       shipStats_instance.displayStats();
                       System.out.println("You can press 'p' to equip parts to hardpoints.");
                   //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "v":
                       ascii_art.ascii_spaceship();
                    //   SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "f":
                	   playerFinances.print_finances();
                	 //  SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "r":
                	   shop_instance.refuel_spaceship(shipStats_instance, playerFinances);
                	 //  SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                	   break;
                   case "k":
                	   shipStats_instance.test_for_parameter(shop_instance);
                	//   SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                	   break;
                   case "e":
                	   
                	   //mining_expedition_instance.go_on_mining_expedition(playerFinances, shipStats_instance);
                	   mining_expedition_instance.select_where_go_mining(playerFinances, shipStats_instance, shop_instance, timeManager_instance, shipStats_instance);

                	   shipStats_instance.wear_and_tear(); // Apply wear and tear after expedition
                	   shipStats_instance.fuel_comsumption();
                	 //  shipStats_instance.displayStats();
                	 //  playerFinances.print_finances();
                	   
                	   if(timeManager_instance.isDebtDeadlinePassed()) {
                		   playerFinances.payDebtIstallment(timeManager_instance);
                	   }
                	   else
                	   {
                		   int daysUntilDeadline = timeManager_instance.getTimeUnitlDeadline();
                		   System.out.println("Days until next debt payment deadline: " + daysUntilDeadline + " days");
                	   }
                	   
                	  
                	   
                	 //  SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "b":
                	   
                	   shop_instance.spaceship_parts_store(playerFinances);
                	   //SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "p":
                	   
                	   playerFinances.payOffPlayerDebt();
                	   playerFinances.print_finances();
                	   if(playerFinances.getDebt() <=0)
                	   {
                		   timeManager_instance.resetDebtDeadline();
                	   }
                	   playerFinances.print_finances();
                	  // SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "s":
                	   
                	   SaveLoadSystemInstance.saveGame(playerFinances, shipStats_instance,shop_instance, playerStatsInstance);
                	   //SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                	  
                       break;
                   case "h":
                	   
                	   hireAstronauts.hireAstronautPersonel(playerFinances, shipStats_instance);
                	   //SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                	  
                       break;
                   case "view":
                       hireAstronauts.viewHiredAstronauts();
                       break;
                   case "l":
                	   
                	   SaveLoadSystemInstance.loadGame(playerFinances, shipStats_instance,shop_instance, playerStatsInstance);
                	  // SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                	  
                       break;
                   case "c":
                	   System.out.println("Your geology levet is : "+ playerStatsInstance.getLevelGeologistSkillPlayer());
                	   System.out.println("Your Astrogator levet is : "+ playerStatsInstance.getAstrogatorExperiencePlayer());
                	   System.out.println("Your Engineering levet is : "+ playerStatsInstance.getEngineeringExperiencePlayer());
                	   
                	   break;
                   case "u":
                	   shipStats_instance.displayHardpoints();
                	    System.out.println("Select a hardpoint to equip (1-6):");
                	    int hardpoint = scanner.nextInt();
                	    scanner.nextLine(); // Consume the newline

                	    System.out.println("Select a part to equip:");
                	    System.out.println("1. Basic Radar");
                	    System.out.println("2. Advanced Mining Laser");
                	    // Add more parts as needed
                	    int partId = scanner.nextInt();
                	    scanner.nextLine(); // Consume the newline

                	    shipStats_instance.equipPartToHardpoint(hardpoint, partId);
                	    break;
                   	  case "help":
                   		  
                   	   //System.out.println("time unil next debt payment is "+timeManager_instance.getTimeUnitlDeadline());
                       System.out.println("Press 'a' to see ship stats");
                       System.out.println("Press 'v' to view your ship");
                       System.out.println("Press 'f' to view your finances");
                       System.out.println("Press 'e' to go on a mining expedition");
                       System.out.println("Press 'r' to refuel");
                       System.out.println("Press 'b' to access store");
                       System.out.println("Press 'p' to pay of your debts");
                       System.out.println("Press 's' to save the game");
                       System.out.println("Press 'l' to load the game");
                       System.out.println("Press 'h' to hire astronauts");
                       System.out.println("Press 'view' to see hired astronauts");
                       System.out.println("Press 'c' to view your stats");
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
    
 // Method to generate and save astronaut data to a file
    private static void generateAndSaveAstronauts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("astronauts.txt"))) {
            for (int i = 0; i < 5; i++) {
                Astronauts astronaut = AstronautGenerator.generateAstronaut();
                writer.write(astronaut.toString());
                writer.newLine();
            }
            System.out.println("5 astronauts have been generated and saved to astronauts.txt");
        } catch (IOException e) {
            System.out.println("Error writing to astronauts.txt: " + e.getMessage());
        }
    }
    
    
    
    
    



}
