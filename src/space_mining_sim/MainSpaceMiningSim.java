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
import java.util.List; 

public class MainSpaceMiningSim {
	
// TODO


    
	

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
        ship_stats shipStats_instance = new ship_stats(playerFinances, shop_instance);
        shop_instance.setShipStatsInstance(shipStats_instance);
        playerStats playerStatsInstance = new playerStats();
        timeManager timeManager_instance = new timeManager();
        storyDescriptionsText storyDescriptionsTextInstance = new storyDescriptionsText();
        hireAstronauts hireAstronautsInstance = new hireAstronauts();
        assignAstronauts assignAstronautsInstance = new assignAstronauts();
        Astronauts assignedAstrogator = assignAstronautsInstance.getAssignedAstrogator();
        EventManager eventManagerInstance = new EventManager(shipStats_instance, timeManager_instance, playerFinances, playerStatsInstance, hireAstronautsInstance, assignAstronautsInstance);

        mining_expedition_simulation miningExpedition = new mining_expedition_simulation(
        		timeManager_instance, 
        		playerStatsInstance, 
        		shipStats_instance, 
        		storyDescriptionsTextInstance, 
        		eventManagerInstance, 
        		assignAstronautsInstance, 
        		null, 
        		assignedAstrogator);
        QuestManager QuestManagerInstance = new QuestManager(playerFinances, shop_instance, shipStats_instance, playerStatsInstance, timeManager_instance, storyDescriptionsTextInstance, miningExpedition);
        
        //sets the QuestManagerInstance in the existing miningExpedition instance
        miningExpedition.setQuestManager(QuestManagerInstance);
        
        
        shop_instance.setMiningExpedition(miningExpedition);
        shop_instance.setPlayerFinances(playerFinances);
        SaveLoadSystem SaveLoadSystemInstance = new SaveLoadSystem();
        SoundGenerator SoundGeneratorInstance = new SoundGenerator();
        optionsSpaceMiningSim optionsSpaceMiningSimInstance = new optionsSpaceMiningSim();
        AudioAndMusic audioAndMusicInstance = new AudioAndMusic(optionsSpaceMiningSimInstance);
        
   

    
        
        
        // Generate and save astronauts at the start of the program
        generateAndSaveAstronauts();
       // DisplayImageAnimation2_instance.displayAnimation();
        audioAndMusicInstance.playMenuSelectionSound();
        
       
      
       
        
     // If loading is successful, display welcome messages and load game data
        System.out.println("Booting Spaceship OS...");
        
   
        try {
        
        	if(optionsSpaceMiningSimInstance.getStartupLoadingBarIsActive()==true) {
        		
        	   
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
        	}else {
        		
        	}
        	
        loadingSuccessful = true;
       } catch (InterruptedException e) {
           System.err.println("\nError during loading: " + e.getMessage());
           
           // Handle the error as needed
       }
       if (loadingSuccessful) {
    	  
           System.out.println("\nBoot Complete. Welcome to Spaceship OS!");
           System.out.println(" ");
           
           
           
 
           
 // This keeps the game loop going
           while (true) {

               
           
        	 
           

           
    

    
           shipStats_instance.updateShipFeatures();
           
           
           
           SaveLoadSystemInstance.loadGame(playerFinances, shipStats_instance, shop_instance, playerStatsInstance, assignAstronautsInstance, hireAstronautsInstance);

           
           
           
           if(playerStatsInstance.getPlayerName() == null || playerStatsInstance.getPlayerName().isEmpty())
    	   {
        	   System.out.println("Welcome to my game");
        	   System.out.println("To win you need to earn money by mining and pay of your debt to fully own your own ship");
        	   System.out.println("");
    	   }
    	   else
    	   {
    		  
    	   }
   
           
           Scanner scanner = new Scanner(System.in);
           String input = ""; // Declare input before the loop
           // here checks if the player has already entered their name and saved
           if(playerStatsInstance.getPlayerName()==null || playerStatsInstance.getPlayerName().isEmpty())
           {
        	   System.out.println("Please enter your character's name:");
        	   String playerName = scanner.nextLine();
        	   System.out.println("Welcome, " + playerName + "!");
        	   playerStatsInstance.setPlayerName(playerName);
        	 //  setFirstTimeStartGameBoolean();
           }
           else {
        	   System.out.println("Welcome back, " + playerStatsInstance.getPlayerName() + "!");
           }
           
           if (shipStats_instance.getShipName() == null || shipStats_instance.getShipName().isEmpty())
           {
        	   System.out.println("Please enter your ship's name:");
        	   String shipName = scanner.nextLine();
        	   shipStats_instance.setShipName(shipName);
        	   System.out.println("Your ship is named: " + shipName);
           }
           else
        	   {
        	   System.out.println("Your ship is named: " + shipStats_instance.getShipName());
        	   
        	   }
           
        	   
           

         
           // Main game loop
           while (!input.equals("exit")) {
        	   
               if (gameFailstate(playerFinances, shipStats_instance)) {
                   break; // Exit the main game loop if a fail state is reached
               }
        	   timeManager_instance.printCurrentDate();
        	   System.out.println("Type 'help' to see available commands");

               System.out.println("Type 'exit' to quit");

         
               input = scanner.nextLine(); // Assign new input value here, don't redeclare

               
               
          
               ascii_art ascii_art = new ascii_art();
   
             //  mining_expedition_simulation mining_expedition_instance = new mining_expedition_simulation(timeManager_instance, playerStatsInstance, shipStats_instance, storyDescriptionsTextInstance);
               
               
               
               audioAndMusicInstance.playMenuSelectionSound();
               

               // Use switch statement to handle the input
               switch (input) {
                   case "a":
                       shipStats_instance.displayStats();
                       String subInput = scanner.nextLine();
                       if (subInput.equals("r")) {
                           shipStats_instance.renameShip();
                       } else if (subInput.equals("e")) {
                           System.out.println("You can press 'p' to equip parts to hardpoints.");
                       }
                       
                 
                       break;
                   case "v":
                       ascii_art.ascii_spaceship();
                 
                
                       break;
                   case "f":
                	   playerFinances.print_finances();
                	 
                	 
                       break;
                   case "r":
                	   shop_instance.refuel_spaceship(shipStats_instance, playerFinances);
            
                	   break;
                   case "k":
                	   shipStats_instance.test_for_parameter(shop_instance);
               
                	   break;
                   case "e":
                	
                		  
                	 
                	 //  System.out.println("astronaut highest geologist skill "+    assignAstronautsInstance.getAssignedMinerGeologistSkill());
                	   miningExpedition.setShipFlightMode(shipStats_instance);
                	   miningExpedition.select_where_go_mining(playerFinances, shipStats_instance, shop_instance, timeManager_instance, shipStats_instance);
                	   shop_instance.sellResourceUnits();
                	 //  miningExpedition.resetResources();

                	   shipStats_instance.wear_and_tear(); // Apply wear and tear after expedition
                	   shipStats_instance.fuel_comsumption(6);
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
                	   QuestManagerInstance.miningSurveyQuestEasyDifficulty(1000,1);
                	   QuestManagerInstance.collectIceQuest(1000);
                	   
                	  
                	   
                	 //  SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
                       break;
                   case "b":
                	   shop_instance.check_what_have_bought();
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
                	   playerFinances.checkIFDebtHasBeenPaid(); // victory condition
                	;
                       break;
                   case "s":
                	   
                	   SaveLoadSystemInstance.saveGame(playerFinances, shipStats_instance,shop_instance, playerStatsInstance, assignAstronautsInstance);
                	
                	  
                       break;
                   case "h":
                	   
                	   hireAstronauts.hireAstronautPersonel(playerFinances, shipStats_instance);
                	 
                	  
                       break;
                   case "view":
                       hireAstronauts.viewHiredAstronauts();
                       break;
                   case "l":
                	   
                	   SaveLoadSystemInstance.loadGame(playerFinances, shipStats_instance, shop_instance, playerStatsInstance, assignAstronautsInstance, hireAstronautsInstance);

                	
                	  
                       break;
                   case "c":
                	   playerStatsInstance.printPlayerStats();
               // 	   System.out.println("Your geology levet is : "+ playerStatsInstance.getLevelGeologistSkillPlayer());
                //	   System.out.println("Your Astrogator levet is : "+ playerStatsInstance.getAstrogatorExperiencePlayer());
                	//   System.out.println("Your Engineering levet is : "+ playerStatsInstance.getEngineeringExperiencePlayer());
                	   
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
                	    

                      case "o":
                    	  //System.out.print("input your options");
                    	  optionsSpaceMiningSimInstance.printOptions();
                    	  String subInputOptions = scanner.nextLine();
                    	 
                    	  optionsSpaceMiningSimInstance.userInputOptions(subInputOptions);

                 	   break;
                      case "n":

                    	  // here assign astronauts to different jobs
                    	  assignAstronautsInstance.choiceAssingAstronauts(hireAstronautsInstance);
                    	
                    	  assignedAstrogator = assignAstronautsInstance.getAssignedAstrogator();
                    	  miningExpedition.setAssignedAstrogator(assignedAstrogator);

                    	
                    	
                    	    break;
                    	    
                    	    
                      case "d":
                    	    // Code to unassign the current miner
                    	  assignAstronauts.unassignMiner();
                    	   
                 	   break;
                 	   
                      case "q":
                  	    // Code to unassign the current miner
                  	  QuestManagerInstance.availableQuests();
                  	QuestManagerInstance.chooseQuest();
                  	   
               	   break;
                      case "repair":
                   	   
                    	  shipStats_instance.repairHullSpecificAmountShipStats();
                   	 
                   	  
                          break;
                   case "z":
                	    startNewGame(playerFinances, shop_instance, shipStats_instance, playerStatsInstance, timeManager_instance, SaveLoadSystemInstance, scanner);
                	    main(new String[]{});
                	    shipStats_instance.renameShip();
                        return;
                	   // break;
               
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
                       System.out.println("Press 'z' to start a new game");
                	   break;
                      case "exit":
                          System.out.println("Exiting the game. Goodbye!");
                          scanner.close(); //closing the scanner before exiting
                          System.exit(0); // This terminates the program
                          break;
                   default:
                       System.out.println("Invalid command.");
                       break;
               }
           }

           scanner.close(); // Close the scanner after the loop

           
           
       }} else {
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
    
    
    // Method to start a new game
    private static void startNewGame(finances_player playerFinances, Shop_space_mining_sim shop_instance, ship_stats shipStats_instance, playerStats playerStatsInstance, timeManager timeManager_instance, SaveLoadSystem SaveLoadSystemInstance, Scanner scanner) {
        // Reset game state
        playerFinances.resetFinances();
        shop_instance.resetShop();
        shipStats_instance.resetShipStats();
        playerStatsInstance.resetPlayerStats();
        timeManager_instance.resetTimeManager();
      //  SaveLoadSystemInstance.saveGame(playerFinances, shipStats_instance, shop_instance, playerStatsInstance);
        System.out.println("New game started!");
        
        // Prompt for player and ship name
        System.out.println("Please enter your character's name:");
        String playerName = scanner.nextLine();
        playerStatsInstance.setPlayerName(playerName);
        System.out.println("Welcome, " + playerName + "!");

        System.out.println("Please enter your ship's name:");
        String shipName = scanner.nextLine();
        shipStats_instance.setShipName(shipName);
        System.out.println("Your ship is named: " + shipName);
    }
    
    
//
//    static boolean getFirstTimeStartGameBoolean()
//    {
//    	return firstTimeStartGameBoolean;
//    }
//    
//    public static void setFirstTimeStartGameBoolean() {
//    	// TODO Auto-generated method stub
//    	//this.fuel_amount = newFuelAmount;
//    	firstTimeStartGameBoolean = false;
//    }
//  

    // this function checks if the game is over every input
   private static boolean gameFailstate(finances_player playerFinances, ship_stats shipStats_instance)
   {
	   if(shipStats_instance.getHullIntegrity()<=0)
	   {
		   System.out.println("Your ship has been destroyed");
		   System.out.println("game is over");
		   System.out.println("reload an earlier save file or start a new game");
		   handleGameOver();
		   return true;
	   }
	   
	   if(shipStats_instance.getCrewMorale()<=0)
	   {
		   System.out.println("Your crew morale is 0");
		   System.out.println("game is over");
		   System.out.println("reload an earlier save file or start a new game");
		   handleGameOver();
		   return true;
	   }
	   
	   if(playerFinances.getFinances()<=0)
	   {
		   System.out.println("Your have 0 money and have gone bankrupt");
		   System.out.println("game is over");
		   System.out.println("reload an earlier save file or start a new game");
		   handleGameOver();
		   return true;
	   }
	   
	return false;
	   
   }
   private static void handleGameOver() {
	    System.out.println("Game Over. Exiting...");
	    System.exit(0); // Exit the program
	}





}
