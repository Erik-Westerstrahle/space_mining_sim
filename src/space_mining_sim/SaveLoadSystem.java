// SaveloadSystem.java

package space_mining_sim;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class SaveLoadSystem {
	  Shop_space_mining_sim shop = new Shop_space_mining_sim();
	   playerStats playerStatsInstance = new playerStats(); 
	   static boolean firstTimeStartGameBoolean = true;
    
    
	  // Method to save game state to a file
	   // the save game is currently a txt file. This migt be changed later
    public static void saveGame(finances_player playerFinances, ship_stats shipStats,Shop_space_mining_sim shop_instance,  playerStats playerStatsInstance,assignAstronauts assignAstronautsInstance) {
        try {
        	  // Using BufferedWriter for efficient writing to a file
            BufferedWriter writer = new BufferedWriter(new FileWriter("game_save.txt"));
            // Writing player's finances and debt to the file
            writer.write( playerFinances.getFinances() + "\n");
            writer.write( playerFinances.getDebt() + "\n");
            
         // Writing ship's hull integrity and fuel amount to the file
            writer.write( shipStats.getHullIntegrity() + "\n");
            writer.write( shipStats.getFuelAmount() + "\n");
            
            // Writing information about purchased items (mining arm, fusion engine)
            writer.write( shop_instance.hasBoughtMiningArm() + "\n");
            writer.write(shop_instance.getHaveBoughtFusionEngine() + "\n"); // Save fusion engine state
            
            //writing player experience and skill to file
            writer.write(playerStatsInstance.getPlayerName() + "\n");
            writer.write(playerStatsInstance.getGeologistExperiencePlayer() + "\n");
            writer.write(playerStatsInstance.getLevelAstrogatorSkillPlayer() + "\n");
            writer.write(playerStatsInstance.getEngineeringExperiencePlayer() + "\n");
            writer.write(playerStatsInstance.getLevelGeologistSkillPlayer() + "\n");
            writer.write(playerStatsInstance.getAstrogatorExperiencePlayer() + "\n");
            writer.write(playerStatsInstance.getEngineeringExperiencePlayer() + "\n");
            writer.write(shipStats.getShipName()+ "\n");
            writer.write(firstTimeStartGameBoolean + "\n");
            
            
            writer.write(assignAstronautsInstance.getAssignedMiner() != null ? assignAstronautsInstance.getAssignedMiner().getId() + "\n" : "-1\n");
            writer.write(assignAstronautsInstance.getAssignedAstrogator() != null ? assignAstronautsInstance.getAssignedAstrogator().getId() + "\n" : "-1\n");
            writer.write(assignAstronauts.getAssignedMechanic() != null ? assignAstronautsInstance.getAssignedMechanic().getId() + "\n" : "-1\n");
            
            
            
            // Write other game states here
            
            // Closing the writer to ensure data is saved and resources are released
            writer.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the game: " + e.getMessage());
        } 
    }
    
    
    // Method to load game state from a file
    public static void loadGame(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance, playerStats playerStatsInstance, assignAstronauts assignAstronautsInstance, hireAstronauts hireAstronautsInstance)
 {
        try {
        	 boolean nameLoaded = false;
            BufferedReader reader = new BufferedReader(new FileReader("game_save.txt"));
            playerFinances.setFinances(Integer.parseInt(reader.readLine()));
            playerFinances.setDebt(Integer.parseInt(reader.readLine()));
            shipStats.setHullIntegrity(Integer.parseInt(reader.readLine()));
            shipStats.setFuelAmount(Integer.parseInt(reader.readLine()));
         //   boolean hasBoughtMiningArm = Boolean.parseBoolean(reader.readLine().split(": ")[1]);
           shop_instance.setHaveBoughtMiningArm(Boolean.parseBoolean(reader.readLine()));
           shop_instance.setHaveBoughtFusionEngine(Boolean.parseBoolean(reader.readLine())); // Load fusion engine state
           
           playerStatsInstance.setPlayerName(reader.readLine());
           playerStatsInstance.setGeologistExperiencePlayer(Integer.parseInt(reader.readLine()));
           playerStatsInstance.setLevelGeologistSkillPlayer(Integer.parseInt(reader.readLine()));
           playerStatsInstance.setLevelAstrogatorSkillPlayer(Integer.parseInt(reader.readLine()));
           playerStatsInstance.setLevelGeologistSkillPlayer(Integer.parseInt(reader.readLine()));
           firstTimeStartGameBoolean=Boolean.parseBoolean(reader.readLine());
           shipStats.setShipName(reader.readLine());
           
           int minerId = Integer.parseInt(reader.readLine());
           int astrogatorId = Integer.parseInt(reader.readLine());
           int mechanicId = Integer.parseInt(reader.readLine());
           
           
           List<Astronauts> hiredAstronauts = hireAstronautsInstance.getHiredAstronauts();
           
           assignAstronautsInstance.setAssignedMiner(findAstronautById(hiredAstronauts, minerId));
           assignAstronautsInstance.setAssignedAstrogator(findAstronautById(hiredAstronauts, astrogatorId));
           assignAstronautsInstance.setAssignedMechanic(findAstronautById(hiredAstronauts, mechanicId));
           
            // ... Read other game states
            reader.close();
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading the game: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in saved data format: " + e.getMessage());
        }
    }
    

    static boolean getFirstTimeStartGameBoolean()
    {
    	
		return firstTimeStartGameBoolean;
    }
    
    public  void setFirstTimeStartGameBoolean(boolean newSetFirstTimeStartGameBoolean) {
    	// TODO Auto-generated method stub
    	//this.fuel_amount = newFuelAmount;

    	SaveLoadSystem.firstTimeStartGameBoolean = newSetFirstTimeStartGameBoolean;
    }
  
    private static void startNewGame_old(finances_player playerFinances, Shop_space_mining_sim shop_instance, ship_stats shipStats_instance, playerStats playerStatsInstance, timeManager timeManager_instance, SaveLoadSystem SaveLoadSystemInstance, Scanner scanner) {
        // Reset game state
        playerFinances.resetFinances();
        shop_instance.resetShop();
        shipStats_instance.resetShipStats();
        playerStatsInstance.resetPlayerStats();
        timeManager_instance.resetTimeManager();
    }
    
    private static Astronauts findAstronautById(List<Astronauts> astronauts, int id)
{
    	for (Astronauts astronaut : astronauts) {
    		if (astronaut.getId()== id)
    		{
    			return astronaut;
    		}
    	}
	return null;
}
    

    

}
