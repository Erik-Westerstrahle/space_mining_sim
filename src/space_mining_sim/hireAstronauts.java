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
    private static timeManager timeManagerInstance = new timeManager();
	
    private static Astronauts assignedMiner = null;
    private static Astronauts assignedAstrogator = null;
    private static int nextAstronautId = 1;
    private static assignAstronauts assignAstronautsInstance = new assignAstronauts();
    


 
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

            // Assign a unique number to the astronaut
            selectedAstronaut.setId(nextAstronautId++);
            
            // Save the selected astronaut
            saveHiredAstronaut(selectedAstronaut);

            System.out.println("Astronaut " + selectedAstronaut.getName() + " has been hired and assigned number " + selectedAstronaut.getId() + ".");
        } else {
            System.out.println("Invalid selection.");
        }
    }

	
    

	
	  // Method to save hired astronaut to a file
    private static void saveHiredAstronaut(Astronauts astronaut) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hired_astronauts.txt", true))) {
            writer.write(astronaut.toString());
            writer.newLine();
            System.out.println("Astronaut " + astronaut.getName() + " has been hired and assigned number " + astronaut.getId() + ".");
        }
    }
    
    // Method to view hired astronauts
    public static void viewHiredAstronauts() throws IOException {
        try {
            // Debug: Log the attempt to retrieve astronauts
            System.out.println("DEBUG: Attempting to retrieve hired astronauts.");

            // Get the list of hired astronauts
            List<Astronauts> hiredAstronauts = getHiredAstronauts();

            // Debug: Log the size of the retrieved list
            System.out.println("DEBUG: Number of hired astronauts retrieved: " + hiredAstronauts.size());

            // Check if the list is empty
            if (hiredAstronauts.isEmpty()) {
                System.out.println("No hired astronauts found.");
                System.out.println("DEBUG: The list of hired astronauts is empty.");
                return;
            }

            // Display the hired astronauts
            System.out.println("Hired Astronauts:");
            for (Astronauts astronaut : hiredAstronauts) {
                System.out.println(astronaut.getId() + ". " + astronaut);
                // Debug: Log each hired astronaut's details
                System.out.println("DEBUG: Viewing hired astronaut: " + astronaut);
            }
        } catch (IOException e) {
            // Catch and log any IO exceptions
            System.out.println("Error reading hired astronauts: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for further debugging
        } catch (Exception e) {
            // Catch and log any other exceptions
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for further debugging
        }
    }

    
    public static void getHiredAstronautsSkills() throws IOException {
    	  try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
    		
    		  
    	  }
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
    
    // Method to get the astronaut with the highest astrogator skill
    public int getAstronautWithHighestAstrogatorSkill() throws IOException {
        List<Astronauts> hiredAstronauts = getHiredAstronauts();
        Astronauts highestAstrogatorSkillAstronaut = null;
        int highestSkill = 0;

        for (Astronauts astronaut : hiredAstronauts) {
            if (astronaut.getAstrogatorSkill() > highestSkill) {
                highestSkill = astronaut.getAstrogatorSkill();
                highestAstrogatorSkillAstronaut = astronaut;
            }
        }

        return highestSkill;
    }
    
    

    
    public static List<Astronauts> getHiredAstronauts() throws IOException {
        List<Astronauts> hiredAstronauts = new ArrayList<>();
        // Regex pattern matching the format of Astronaut toString() output
        Pattern pattern = Pattern.compile(
                "Astronaut\\{id=(\\d+), name='(.*?)', origin='(.*?)', personality='(.*?)', skillLevel=(\\d+), " +
                "occupation='(.*?)', salaryRequirement=(\\d+), astrologySign='(.*?)', background='(.*?)', " +
                "geologistSkill=(\\d+), astrogatorSkill=(\\d+), mechanicSkill=(\\d+), minerSkill=(\\d+)\\}"
            );

        // Debug: Log the start of file reading
        System.out.println("DEBUG: Starting to read from hired_astronauts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Debug: Log each line read
                System.out.println("DEBUG: Read line: " + line);

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    // Extract data from the matcher
                    int id = Integer.parseInt(matcher.group(1).trim());
                    String name = matcher.group(2).trim();
                    String origin = matcher.group(3).trim();
                    String personality = matcher.group(4).trim();
                    int skillLevel = Integer.parseInt(matcher.group(5).trim());
                    String occupation = matcher.group(6).trim();
                    int salaryRequirement = Integer.parseInt(matcher.group(7).trim());
                    String astrologySign = matcher.group(8).trim();
                    String background = matcher.group(9).trim();
                    int geologistSkill = Integer.parseInt(matcher.group(10).trim());
                    int astrogatorSkill = Integer.parseInt(matcher.group(11).trim());
                    int mechanicSkill = Integer.parseInt(matcher.group(12).trim());
                    int minerSkill = Integer.parseInt(matcher.group(13).trim());

                    //  Astronaut instance with the extracted data
                    Astronauts astronaut = new Astronauts(
                        id,
                        name,
                        skillLevel,
                        salaryRequirement,
                        occupation,
                        origin,
                        personality,
                        astrologySign,
                        background,
                        geologistSkill,
                        astrogatorSkill,
                        mechanicSkill,
                        minerSkill,
                        timeManagerInstance,
                        assignAstronautsInstance 
                    );

                    // Add the astronaut to the list
                    hiredAstronauts.add(astronaut);

                    // Debug: Log the successfully parsed astronaut
                    System.out.println("DEBUG: Parsed astronaut: " + astronaut);
                } else {
                    // Debug: Log if the line did not match the pattern
                    System.out.println("DEBUG: Line did not match pattern: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading hired astronauts: " + e.getMessage());
            throw e; // Re-throw the exception to be caught by the calling method
        }

        // Debug: Log the completion of file reading
        System.out.println("DEBUG: Completed reading from hired_astronauts.txt");
        
        return hiredAstronauts;
    }

    
    


// 
// public static void assignMinerToShip(Astronauts astronaut, ship_stats shipStats_instance)
// {
//	 if(assignedMiner !=null)
//	 {
//		 System.out.println("An astronauts has already been assigned to the miner jobb" + assignedMiner.getName() + ". Unassign the current miner before assigning a new one.");
//	 
//		 System.out.println("Debug: Current astronaut" +  assignedMiner.getName() + " is assigned to the astrogator jobb");
//	 }
//	 
//	 
//	 System.out.println(astronaut.getName() + " has been assigned to the miner jobb");
//	 System.out.println(astronaut);
//	 assignedMiner = astronaut;
//	 shipStats_instance.setAvailableCrewSpots(astronaut.getMinerSkillAstronautsClass());
//	 System.out.println("Astronaut " + astronaut.getName() + " has been assigned as the miner.");
//	 System.out.println("astronaut has the miner skill value: "+shipStats_instance.getMinerSkillValue());
//	 
// }
// 
// public static void unassignMiner() {
//	    if (assignedMiner != null) {
//	        System.out.println("Unassigned " + assignedMiner.getName() + " from the miner job.");
//	        // Debug: Log the unassigned astronaut's details
//	        System.out.println("DEBUG: Unassigned astronaut: " + assignedMiner);
//	        assignedMiner = null;
//	    } else {
//	        System.out.println("No miner is currently assigned.");
//	        System.out.println("DEBUG: Attempted to unassign but no miner is assigned.");
//	    }
//	}
// 
// public static void assignAstrogatorToShip(Astronauts astronaut, ship_stats shipStats_instance)
// {
//	 if(assignedAstrogator !=null)
//	 {
//		 System.out.println("An astronauts has already been assigned to the Astrogator jobb" + assignedAstrogator.getName() + ". Unassign the current astrogator before assigning a new one.");
//	 
//		 System.out.println("Debug: Current astronaut" +  assignedAstrogator.getName() + " is assigned to the astrogator jobb");
//	 }
//	 
//	 
//	 System.out.println(astronaut.getName() + " has been assigned to the miner jobb");
//	 System.out.println(astronaut);
//	 assignedAstrogator = astronaut;
//	 shipStats_instance.setAstrogatorSkillValue(astronaut.getAstrogatorSkill());
//	 System.out.println("Astronaut " + astronaut.getName() + " has been assigned as the astrogator.");
//	 System.out.println("astronaut has the miner skill value: "+shipStats_instance.getAstrogatorSkillValue());
//	 
// }
// 
// public static void unassignAstrogator() {
//	    if (assignedAstrogator != null) {
//	        System.out.println("Unassigned " + assignedAstrogator.getName() + " from the miner job.");
//	        // Debug: Log the unassigned astronaut's details
//	        System.out.println("DEBUG: Unassigned astronaut: " + assignedAstrogator);
//	        assignedAstrogator = null;
//	    } else {
//	        System.out.println("No astrogator is currently assigned.");
//	        System.out.println("DEBUG: Attempted to unassign but no astrogator is assigned.");
//	    }
//	}
// 
//
//    
////Method to get the assigned miner
//public static Astronauts getAssignedMiner() {
//  // Debug: Log the current assigned miner, if any
//  if (assignedMiner != null) {
//      System.out.println("DEBUG: Returning current assigned miner: " + assignedMiner.getName());
//  } else {
//      System.out.println("DEBUG: No miner is currently assigned.");
//  }
//  return assignedMiner;
//}
//
//
//public static int getAssignedMinerGeologistSkill()
//{
//	if(assignedMiner !=null)
//	{
//		  return assignedMiner.getGeologistSkill();
//	}
// else {
//    System.out.println("No miner is currently assigned.");
//    return 0; // Return 0 if no miner is assigned
//}
//}
//
//public static int getAssignedAstrogatorSkill()
//{
//	if(assignedAstrogator !=null)
//	{
//		  return assignedAstrogator.getAstrogatorSkill();
//	}
// else {
//    System.out.println("No astrogator is currently assigned.");
//    return 0; // Return 0 if no astrogator is assigned
//}
//}


}
