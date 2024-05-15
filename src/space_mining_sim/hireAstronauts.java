// hireAstronauts.java

package space_mining_sim;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class hireAstronauts {
    ship_stats shipStats_instance = new ship_stats();
	
	
	// Example of hiring in the BootScreen main method or a separate method

    public static void hireAstronautPersonel(finances_player playerFinances, ship_stats shipStats_instance) throws IOException {
        System.out.println("Available Astronauts: ");
        Astronauts[] availableAstronauts = new Astronauts[5];
        for (int i = 0; i < 5; i++) {
            availableAstronauts[i] = AstronautGenerator.generateAstronaut();
            System.out.println((i + 1) + ". " + availableAstronauts[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an astronaut to hire (1-5): ");
        int choice = scanner.nextInt() - 1; // adjust for 0-based index

        if (choice >= 0 && choice < availableAstronauts.length) {
            Astronauts selectedAstronaut = availableAstronauts[choice]; // Use this object

            // Check if there's space for more crew and if the player has enough funds
            // Assume these checks are done elsewhere in your code

            // Save the selected astronaut
            saveHiredAstronaut(selectedAstronaut);

            System.out.println("Astronaut " + selectedAstronaut.getName() + " has been hired.");
        } else {
            System.out.println("Invalid selection.");
        }
        // Avoid closing the scanner here if it's System.in as it will close System.in for the entire application
    }

	
    
    // Method to count the number of hired astronauts
    private static int getNumberOfHiredAstronauts() throws IOException {
        int count = 0;
        // the number of astronauts that have been hired are saved to a text file. This migh need to be changed later
        try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
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
    
    public static void getHiredAstronautsSkills() throws IOException {
    	  try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
    		
    		  
    	  }
    }
    
    
    // learn this later
//    public static List<Astronauts> getHiredAstronauts() throws IOException {
//        List<Astronauts> hiredAstronauts = new ArrayList<>();
//        Pattern pattern = Pattern.compile("Astronaut\\{name='(.*?)', skillLevel=(\\d+), occupation=(.*?), salaryRequirement=(\\d+)}, \"personalityAstronaut\\\\{name='(.*?)', \\\"home\\\\\\\\{name='(.*?)'");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Matcher matcher = pattern.matcher(line);
//                if (matcher.find()) {
//                    String name = matcher.group(1).trim();
//                    int skillLevel = Integer.parseInt(matcher.group(2).trim());
//                    String occupation = matcher.group(3).trim();
//                    int salaryRequirement = Integer.parseInt(matcher.group(4).trim());
//
//                    hiredAstronauts.add(new Astronauts(fullName, skillLevel, salary, occupation, home, personalityAstronaut, home, astrologySign));
//                }
//            }
//        }
//        return hiredAstronauts;
//    }
    
    public static List<Astronauts> getHiredAstronauts() throws IOException {
        List<Astronauts> hiredAstronauts = new ArrayList<>();
        Pattern pattern = Pattern.compile("Astronaut\\{name='(.*?)', origin='(.*?)', personality='(.*?)', skillLevel=(\\d+), occupation='(.*?)', salaryRequirement=(\\d+), astrologySign='(.*?)', background='(.*?)'\\}");

        try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String name = matcher.group(1).trim();
                    String origin = matcher.group(2).trim();
                    String personality = matcher.group(3).trim();
                    int skillLevel = Integer.parseInt(matcher.group(4).trim());
                    String occupation = matcher.group(5).trim();
                    int salaryRequirement = Integer.parseInt(matcher.group(6).trim());
                    String astrologySign = matcher.group(7).trim();
                    String background = matcher.group(8).trim();

                    hiredAstronauts.add(new Astronauts(name, skillLevel, salaryRequirement, occupation, origin, personality, astrologySign, background));
                }
            }
        }
        return hiredAstronauts;
    }

}
