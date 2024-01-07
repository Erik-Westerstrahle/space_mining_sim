package space_mining_sim;

import java.util.Scanner;

class hireAstronauts {
	
	
	// Example of hiring in the BootScreen main method or a separate method

	public static void hireAstronautPersonel(finances_player playerFinances) {
	    System.out.println("Available Astronauts: ");
	    for (int i = 0; i < 5; i++) { // Generate 5 random astronauts
	        Astronauts astronaut = AstronautGenerator.generateAstronaut();
	        System.out.println((i + 1) + ". " + astronaut);
	    }

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Select an astronaut to hire (1-5): ");
	    int choice = scanner.nextInt();
	    // Further code to handle hiring logic, updating finances, etc.
	}


}
