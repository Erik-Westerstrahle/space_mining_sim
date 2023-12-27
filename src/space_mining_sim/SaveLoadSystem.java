package space_mining_sim;

import java.io.*;

public class SaveLoadSystem {

    public static void saveGame(finances_player playerFinances, ship_stats shipStats) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("game_save.txt"));
            writer.write(playerFinances.getFinances() + "\n");
            writer.write(playerFinances.getDebt() + "\n");
            writer.write(shipStats.getHullIntegrity() + "\n");
            writer.write(shipStats.getFuelAmount() + "\n");
            // ... Write other game states
            writer.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the game: " + e.getMessage());
        }
    }

    public static void loadGame(finances_player playerFinances, ship_stats shipStats) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("game_save.txt"));
            playerFinances.setFinances(Integer.parseInt(reader.readLine()));
            playerFinances.setDebt(Integer.parseInt(reader.readLine()));
            shipStats.setHullIntegrity(Integer.parseInt(reader.readLine()));
            shipStats.setFuelAmount(Integer.parseInt(reader.readLine()));
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
