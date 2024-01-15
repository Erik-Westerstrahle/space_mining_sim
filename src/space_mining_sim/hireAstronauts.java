package space_mining_sim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class hireAstronauts {
	
	
	// Example of hiring in the BootScreen main method or a separate method

    public static void hireAstronautPersonel(finances_player playerFinances) throws IOException {
        System.out.println("Available Astronauts: ");
        Astronauts[] availableAstronauts = new Astronauts[5];
        for (int i = 0; i < 5; i++) {
            availableAstronauts[i] = AstronautGenerator.generateAstronaut();
            System.out.println((i + 1) + ". " + availableAstronauts[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an astronaut to hire (1-5): ");
        int choice = scanner.nextInt();
        
        // Assuming the player has enough funds to hire an astronaut
        // Further code to check and update finances can be added here
        saveHiredAstronaut(availableAstronauts[choice - 1]);
    }
	
	
	  // Method to save hired astronaut to a file
    private static void saveHiredAstronaut(Astronauts astronaut) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hired_astronauts.txt", true))) {
            writer.write(astronaut.toString());
            writer.newLine();
            System.out.println("Astronaut " + astronaut.getName() + " has been hired.");
        }
    }
    
    // Method to view hired astronauts
    public static void viewHiredAstronauts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
            System.out.println("Hired Astronauts:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
	
	
	
//	  public static void hireAstronautPersonel(finances_player playerFinances) throws IOException {
//	        System.out.println("Available Astronauts: ");
//	        Astronauts[] availableAstronauts = new Astronauts[5];
//	        for(int i =0; i <5; i++)
//	        {
//	        	
//	        }
//	  }


}
