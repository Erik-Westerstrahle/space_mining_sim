package space_mining_sim;

import java.util.Random;

public class storyDescriptionsText {
	
    // Array of station descriptions
	//Station descriptions are stored in an array for efficeny
    private static final String[] stationDescriptions = {
        "Entering the station you feel the smell of the ozone from the air cleaners. It is good to be back.",
        "Arriving back at the station you are surprised by the large crowds.",
        "You remember the old saying space is clean, humans are not as you step into the station. It smells horrible here."
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

}
