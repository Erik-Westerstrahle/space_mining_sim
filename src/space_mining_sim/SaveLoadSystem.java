package space_mining_sim;

import java.io.*;

public class SaveLoadSystem {
	  Shop_space_mining_sim shop = new Shop_space_mining_sim();

//    public static void saveGame(finances_player playerFinances, ship_stats shipStats,Shop_space_mining_sim shop) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("game_save.txt"));
//            writer.write("Player Finances: " + playerFinances.getFinances() + "\n");
//            writer.write("Player Debt: " + playerFinances.getDebt() + "\n");
//            writer.write("Ship Hull Integrity: " + shipStats.getHullIntegrity() + "\n");
//            writer.write("Ship Fuel Amount: " + shipStats.getFuelAmount() + "\n");
//         //   writer.write("Player has mining arm " + shop.hasBoughtMiningArm() + "\n");
//            // ... Write other game states
//            writer.close();
//            System.out.println("Game saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Error saving the game: " + e.getMessage());
//        } 
//    }
    
    

    public static void saveGame(finances_player playerFinances, ship_stats shipStats,Shop_space_mining_sim shop) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("game_save.txt"));
            writer.write( playerFinances.getFinances() + "\n");
            writer.write( playerFinances.getDebt() + "\n");
            writer.write( shipStats.getHullIntegrity() + "\n");
            writer.write( shipStats.getFuelAmount() + "\n");
            writer.write( shop.hasBoughtMiningArm() + "\n");
            writer.write(shop.getHaveBoughtFusionEngine() + "\n"); // Save fusion engine state
            // ... Write other game states
            writer.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the game: " + e.getMessage());
        } 
    }

    public static void loadGame(finances_player playerFinances, ship_stats shipStats,Shop_space_mining_sim shop) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("game_save.txt"));
            playerFinances.setFinances(Integer.parseInt(reader.readLine()));
            playerFinances.setDebt(Integer.parseInt(reader.readLine()));
            shipStats.setHullIntegrity(Integer.parseInt(reader.readLine()));
            shipStats.setFuelAmount(Integer.parseInt(reader.readLine()));
         //   boolean hasBoughtMiningArm = Boolean.parseBoolean(reader.readLine().split(": ")[1]);
           shop.setHaveBoughtMiningArm(Boolean.parseBoolean(reader.readLine()));
           shop.setHaveBoughtFusionEngine(Boolean.parseBoolean(reader.readLine())); // Load fusion engine state
            // ... Read other game states
            reader.close();
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading the game: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in saved data format: " + e.getMessage());
        }
    }
}
