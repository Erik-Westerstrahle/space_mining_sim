package space_mining_sim;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class assignAstronauts {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
    ship_stats shipStats_instance = new ship_stats();
    private static timeManager timeManagerInstance = new timeManager();
	
    private static Astronauts assignedMiner = null;
    private static Astronauts assignedAstrogator = null;
    private static Astronauts assignedMechanic = null;
    
    private static Scanner scanner = new Scanner(System.in);
    
public void choiceAssingAstronauts(hireAstronauts hireAstronautsInstance)
{
  
	System.out.println("Enter choice for assigning astronauts:");
	System.out.println("Input 1 if you want to assign an astronaut to the miner jobb");
	System.out.println("Input 2 if you want to assign an astronaut to the astrogator jobb");
	System.out.println("Input 3 if you want to assign an astronaut to the mechanic jobb");
	String input = scanner.nextLine();
	
	 switch (input) {
	 case "1":
		try {
			hireAstronautsInstance.viewHiredAstronauts();
			
			System.out.println("Enter the id number of the astronaut that you want to assign to be the ship miner");
			
			int astronautChoice = scanner.nextInt();
			
			scanner.nextLine();
			
			List<Astronauts> hiredAstronauts = hiredAstronauts = hireAstronautsInstance.getHiredAstronauts();
			Astronauts selectedAstronaut = null;
			for (Astronauts astronaut : hiredAstronauts) {
				if (astronaut.getId() == astronautChoice) {
					selectedAstronaut = astronaut;
			
			 break;
                }
            }

            if (selectedAstronaut != null) {
                assignMinerToShip(selectedAstronaut, shipStats_instance);
                System.out.println( "Miner is"+ getAssignedMiner());
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (IOException e) {
            System.out.println("Error retrieving hired astronauts: " + e.getMessage());
        }
        break;
        
        
	 case "2":
		try {
			hireAstronautsInstance.viewHiredAstronauts();
			
			System.out.println("Enter the id number of the astronaut that you want to assign to be the ship astrogator");
			
			int astronautChoice = scanner.nextInt();
			
			scanner.nextLine();
			
			List<Astronauts> hiredAstronauts = hiredAstronauts = hireAstronautsInstance.getHiredAstronauts();
			Astronauts selectedAstronaut = null;
			for (Astronauts astronaut : hiredAstronauts) {
				if (astronaut.getId() == astronautChoice) {
					selectedAstronaut = astronaut;
			
			 break;
                }
            }

            if (selectedAstronaut != null) {
                assignAstrogatorToShip(selectedAstronaut, shipStats_instance);
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (IOException e) {
            System.out.println("Error retrieving hired astronauts: " + e.getMessage());
        }
        break;
        
        
	 case "3":
		try {
			hireAstronautsInstance.viewHiredAstronauts();
			
			System.out.println("Enter the id number of the astronaut that you want to assign to be the ship mechanic");
			
			int astronautChoice = scanner.nextInt();
			
			scanner.nextLine();
			
			List<Astronauts> hiredAstronauts = hiredAstronauts = hireAstronautsInstance.getHiredAstronauts(); // creates a list hiredAstronauts
			Astronauts selectedAstronaut = null;
			for (Astronauts astronaut : hiredAstronauts) // iterates over the hiredAstronauts lists
			{
				if (astronaut.getId() == astronautChoice) {
					selectedAstronaut = astronaut;
			
			 break;
                }
            }

            if (selectedAstronaut != null) {
                assignMechanicToShip(selectedAstronaut, shipStats_instance);
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (IOException e) {
            System.out.println("Error retrieving hired astronauts: " + e.getMessage());
        }
        break;
        
        
        
    default:
        System.out.println("Invalid choice. Please enter a valid number.");
        break;
}
}
    
	
	 public static void assignMinerToShip(Astronauts astronaut, ship_stats shipStats_instance)
	 {
		 
		 if(assignedMiner !=null)
		 {
			 System.out.println("An astronauts has already been assigned to the miner jobb" + assignedMiner.getName() + ". Unassign the current miner before assigning a new one.");
		 
			 System.out.println("Debug: Current astronaut" +  assignedMiner.getName() + " is assigned to the miner jobb");
		 }
		 
		 
		 System.out.println(astronaut.getName() + " has been assigned to the miner jobb");
		 System.out.println(astronaut);
		 assignedMiner = astronaut;
		 shipStats_instance.setAvailableCrewSpots(astronaut.getMinerSkillAstronautsClass()); // sets miner skill value to shipStats
		 System.out.println("Astronaut " + astronaut.getName() + " has been assigned as the miner.");
		 System.out.println("astronaut has the miner skill value: "+shipStats_instance.getMinerSkillValue());
		 
	 }
	 
	 public static void unassignMiner() {
		    if (assignedMiner != null) {
		        System.out.println("Unassigned " + assignedMiner.getName() + " from the miner job.");
		        // Debug: Log the unassigned astronaut's details
		        System.out.println("DEBUG: Unassigned astronaut: " + assignedMiner);
		        assignedMiner = null;
		    } else {
		        System.out.println("No miner is currently assigned.");
		        System.out.println("DEBUG: Attempted to unassign but no miner is assigned.");
		    }
		}
	 
	 public static void assignAstrogatorToShip(Astronauts astronaut, ship_stats shipStats_instance)
	 {
		 if(assignedAstrogator !=null)
		 {
			 System.out.println("An astronauts has already been assigned to the Astrogator jobb" + assignedAstrogator.getName() + ". Unassign the current astrogator before assigning a new one.");
		 
			 System.out.println("Debug: Current astronaut" +  assignedAstrogator.getName() + " is assigned to the astrogator jobb");
		 }
		 
		 
		 System.out.println(astronaut.getName() + " has been assigned to the miner jobb");
		 System.out.println(astronaut);
		 assignedAstrogator = astronaut;
		 shipStats_instance.setAstrogatorSkillValue(astronaut.getAstrogatorSkill());
		 System.out.println("Astronaut " + astronaut.getName() + " has been assigned as the astrogator.");
		 System.out.println("astronaut has the astrogator skill value: "+shipStats_instance.getAstrogatorSkillValue());
		 
	 }
	 
	 public static void unassignAstrogator() {
		    if (assignedAstrogator != null) {
		        System.out.println("Unassigned " + assignedAstrogator.getName() + " from the miner job.");
		        // Debug: Log the unassigned astronaut's details
		        System.out.println("DEBUG: Unassigned astronaut: " + assignedAstrogator);
		        assignedAstrogator = null;
		    } else {
		        System.out.println("No astrogator is currently assigned.");
		        System.out.println("DEBUG: Attempted to unassign but no astrogator is assigned.");
		    }
		}
	 
	 
	 
	 public static void assignMechanicToShip(Astronauts astronaut, ship_stats shipStats_instance)
	 {
		 if(assignedMechanic !=null)
		 {
			 System.out.println("An astronauts has already been assigned to the Mechanic jobb" + assignedAstrogator.getName() + ". Unassign the current astrogator before assigning a new one.");
		 
			 System.out.println("Debug: Current astronaut" +  assignedMechanic.getName() + " is assigned to the astrogator jobb");
		 }
		 
		 
		 System.out.println(astronaut.getName() + " has been assigned to the mechanic jobb");
		 System.out.println(astronaut);
		 assignedMechanic = astronaut;
		 shipStats_instance.setMechanicSkillValue(astronaut.getMechanicSkill());
		 System.out.println("Astronaut " + astronaut.getName() + " has been assigned as the mechanic.");
		 System.out.println("astronaut has the mechanic skill value: "+shipStats_instance.getMechanicSkillValue());
		 
	 }
	 
	 
	 public static void unassignMechanic() {
		    if (assignedMechanic != null) {
		        System.out.println("Unassigned " + assignedMechanic.getName() + " from the mechanic job.");
		        // Debug: Log the unassigned astronaut's details
		        System.out.println("DEBUG: Unassigned astronaut: " + assignedMechanic);
		        assignedMechanic = null;
		    } else {
		        System.out.println("No astrogator is currently assigned.");
		        System.out.println("DEBUG: Attempted to unassign but no astrogator is assigned.");
		    }
		}
	 


	    
	//Method to get the assigned miner
	public static Astronauts getAssignedMiner() {
	  // Debug: Log the current assigned miner, if any
	  if (assignedMiner != null) {
	      System.out.println("DEBUG: Returning current assigned miner: " + assignedMiner.getName());
	  } else {
	      System.out.println("DEBUG: No miner is currently assigned.");
	  }
	  return assignedMiner;
	}
	
	public static Astronauts getAssignedAstrogator() {
		  // Debug: Log the current assigned miner, if any
		  if (assignedAstrogator != null) {
		      System.out.println("DEBUG: Returning current assigned astrogator: " + assignedAstrogator.getName());
		  } else {
		      System.out.println("DEBUG: No miner is currently assigned.");
		  }
		  return assignedAstrogator;
		}

	
	public static Astronauts getAssignedMechanic() {
		  // Debug: Log the current assigned miner, if any
		  if (assignedMechanic != null) {
		      System.out.println("DEBUG: Returning current assigned miner: " + assignedAstrogator.getName());
		  } else {
		      System.out.println("DEBUG: No miner is currently assigned.");
		  }
		  return assignedAstrogator;
		}


	public static int getAssignedMinerGeologistSkill()
	{
		if(assignedMiner !=null)
		{
			  return assignedMiner.getGeologistSkill();
		}
	 else {
	    System.out.println("No miner is currently assigned.");
	    return 0; // Return 0 if no miner is assigned
	}
	}

	public static int getAssignedAstrogatorSkill()
	{
		if(assignedAstrogator !=null)
		{
			  return assignedAstrogator.getAstrogatorSkill();
		}
	 else {
	    System.out.println("No astrogator is currently assigned.");
	    return 0; // Return 0 if no astrogator is assigned
	}
	}
	
	public static int getAssignedMechanicSkill()
	{
		if(assignedMechanic !=null)
		{
			  return assignedMechanic.getMechanicSkill();
		}
	 else {
	    System.out.println("No astrogator is currently assigned.");
	    return 0; // Return 0 if no astrogator is assigned
	}
	}
	
	public void saveAssignedAstrogatorExperience(BufferedWriter writer) throws IOException {
		if (assignedAstrogator !=null) {
			assignedAstrogator.saveAstronautAstrogatorExperience(writer);
		}
	}
	
	public void loadAssignedAstrogatorExperience(int astrogatorExperience) {
		if (assignedAstrogator !=null) {
			assignedAstrogator.loadAstronautAstrogatorExperience(astrogatorExperience);
		}
	}
	
    public static void setAssignedMiner(Astronauts astronaut) {
        assignedMiner = astronaut;
    }
    
    public static void setAssignedAstrogator(Astronauts astronaut) {
        assignedAstrogator = astronaut;
    }
    
    public static void setAssignedMechanic(Astronauts astronaut) {
        assignedMechanic = astronaut;
    }

}
