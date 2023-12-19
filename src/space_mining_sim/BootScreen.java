package space_mining_sim;

import java.util.Scanner;

public class BootScreen {
	
	// test comment for github

    public static void main(String[] args) throws InterruptedException {
        final int loadingBarWidth = 30; // The width of the loading bar
        final int sleepTime = 1000 / loadingBarWidth; // Time to sleep in milliseconds
        final int infinityTimerStop = 200;
        boolean loadingSuccessful = false;
        finances_player playerFinances = new finances_player();
        ship_stats shipStats = new ship_stats();

        System.out.println("Booting Spaceship OS...");
        try {

        // Display an ASCII loading bar
        for (int i = 0; i <= loadingBarWidth; i++) {
            System.out.print("\r[");
            int j = 0;
            for (; j < i; j++) {
                System.out.print("#");
            }
            for (; j < loadingBarWidth; j++) {
                System.out.print(" ");
            }
            System.out.print("]");
            Thread.sleep(sleepTime); // Pause to simulate loading time
        }
        loadingSuccessful = true;
       } catch (InterruptedException e) {
           System.err.println("\nError during loading: " + e.getMessage());
           // Handle the error as needed
       }
       if (loadingSuccessful) {
           System.out.println("\nBoot Complete. Welcome to Spaceship OS!");
           System.out.println(" ");
           
           Scanner scanner = new Scanner(System.in);
           String input = ""; // Declare input before the loop

           while (!input.equals("exit")) {
               System.out.println("Press 'a' to see ship stats");
               System.out.println("Press 'v' to view your ship");
               System.out.println("Press 'f' to view your finances");
               System.out.println("Press 'e' to go on a mining expedition");
               System.out.println("Type 'exit' to quit");

               input = scanner.nextLine(); // Assign new input value here, don't redeclare

               
               
               //ship_stats shipStats = new ship_stats();
               ascii_art ascii_art = new ascii_art();
               Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();
              // finances_player finances_player = new finances_player();
              // finances_player playerFinances = new finances_player();
               mining_expedition_simulation mining_expedition_instance = new mining_expedition_simulation();

               // Use switch statement to handle the input
               switch (input) {
                   case "a":
                       shipStats.displayStats();
                       break;
                   case "v":
                       ascii_art.ascii_spaceship();
                       break;
                   case "f":
                	   playerFinances.print_finances();
                       break;
                   case "e":
                	   
                	   mining_expedition_instance.go_on_mining_expedition(playerFinances, shipStats);
                	   shipStats.wear_and_tear(); // Apply wear and tear after expedition
                	   shipStats.fuel_comsumption();
                	   shipStats.displayStats();
                	   playerFinances.print_finances();
                	   
                	   
                       break;
                   case "s":
                	   
                	   spaceship_parts_store_instance.spaceship_parts_store();
                       break;
                   default:
                       System.out.println("Invalid command.");
                       break;
               }
           }

           scanner.close(); // Close the scanner after the loop

           
           
       } else {
           System.out.println("\nBoot Failed. Please try again or contact support.");
       }

     //   System.out.println("\nBoot Complete. Welcome to Spaceship OS!");
    }
}
