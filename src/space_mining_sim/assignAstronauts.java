package space_mining_sim;

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
    
    private static Scanner scanner = new Scanner(System.in);
    
public void choiceAssingAstronauts()
{
  
	System.out.println("Enter choice for assigning astronauts:");
	String input = scanner.nextLine();
}
    
	
	 public static void assignMinerToShip(Astronauts astronaut, ship_stats shipStats_instance)
	 {
		 
		 if(assignedMiner !=null)
		 {
			 System.out.println("An astronauts has already been assigned to the miner jobb" + assignedMiner.getName() + ". Unassign the current miner before assigning a new one.");
		 
			 System.out.println("Debug: Current astronaut" +  assignedMiner.getName() + " is assigned to the astrogator jobb");
		 }
		 
		 
		 System.out.println(astronaut.getName() + " has been assigned to the miner jobb");
		 System.out.println(astronaut);
		 assignedMiner = astronaut;
		 shipStats_instance.setAvailableCrewSpots(astronaut.getMinerSkillAstronautsClass());
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
		 System.out.println("astronaut has the miner skill value: "+shipStats_instance.getAstrogatorSkillValue());
		 
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
	 
	// public static void unassignMiner2()
	// {
//		 if (assignedMiner != null)
//		 {
//			 
//		 }
	// }

	    
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

}
