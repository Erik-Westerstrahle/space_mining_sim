package space_mining_sim;

import java.util.List;
import java.util.Random;

public class storyDescriptionsText {
	
    public void chanceForStationDescriptions()
    {
    	  Random random = new Random();
  	    int chance = random.nextInt(100); // Generate a number between 0 and 99
  	    int chanceForStationDescriptions = 60; // % chance to occur

  	    if (chance <= chanceForStationDescriptions) {
  	    	System.out.println("");
  	    	printRandomStationDescription();
  	    	System.out.println("");
  	    } else {
  	    	 
  	    	
  	
  	    }
    }
	
    // Array of station descriptions
	//Station descriptions are stored in an array for efficeny
    private static final String[] stationDescriptions = {
        "Entering the station you feel the smell of the ozone from the air cleaners. It is good to be back.",
        "Arriving back at the station you are surprised by the large crowds.",
        "You remember the old saying space is clean, humans are not as you step into the station. It smells horrible here.",
        "111111111111111111111111111111111 ",
        "There is a lot traffic at the station. It took forever to dock ",
        "You had to qeue to dock with the station, Somebody was arguing with control",
        "You feel dead tired after the last mining expedition you just want to sleep",
        "As you step onto the station you wonder what your family is doing back home",
        "A painful beeping sound played from the radio",
    };
    
    // Randomly selects and prints a station description
    public void printRandomStationDescription() {
        Random random = new Random();
        // stationDescriptions.length gets the length of the array
        int index = random.nextInt(stationDescriptions.length); // Get a random index
        System.out.println(stationDescriptions[index]); // Print the selected description
    }
	
//	public void stationDescription1 ()
//	{
//		System.out.println("Entering the station you feel the smell of the ozone from the air cleaners. It is good to be back");
//	}
//	
//	public void stationDescription2 ()
//	{
//		System.out.println("Arraving back att station you are suprised by the large crowds");
//	}
//	
//	public void stationDescription3 ()
//	{
//		System.out.println("You remember the old saying space is clean, humans are not as you step into the station. It smells horrible here");
//	}
    
    public void chanceToEncounterRadioChatter()
    {
    	  Random random = new Random();
  	    int chance = random.nextInt(100); // Generate a number between 0 and 99
  	    int chanceToEncounterRadioChatter = 60; // % chance to occur

  	    if (chance <= chanceToEncounterRadioChatter) {
  	    	System.out.println("");
  	    	printRandomRadioChatter();
  	    	System.out.println("");
  	    } else {
  	    	 
  	    	
  	      //  System.out.println("It was radio silence during you mining expedition");
  	    }
    }
    
    private static final String[] radioChatter = {
            "All ships beware. Report any ship flying whitout an active transponder.",
            "This is the ship Gwynewhere requesting nav data",
            "66 55 89 34 11 33 44 66 84 99 10 01 76 72",
            "you hear strange music on the radio. You cannot identify what genre it is",
            "It sounds like screaming, but it might be static. You should probably hurry up and get out of here",
            " You heard two people aruing intensly over the radio. You do not understand the language they are arguing in",
            "A commercial plays on the radio offering ship insurance",
            "You heard some staticy classical music on the radio. this signal mus be wery old"
        };
        
        // Randomly selects and prints a station description
        public void printRandomRadioChatter() {
            Random random = new Random();
 
            int index = random.nextInt(radioChatter.length); // Get a random index
            System.out.println("While on mining expedition in the ring you overheard a radio transmission");
            System.out.println(radioChatter[index]); // Print the selected description
        }

}
