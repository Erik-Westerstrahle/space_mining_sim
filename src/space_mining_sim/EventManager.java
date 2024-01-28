package space_mining_sim;

import java.util.Random;
import java.util.Scanner;

//here the events of the game are managed

public class EventManager {
	//ship_stats shipStats_instance = new ship_stats();
	 //finances_player playerFinances = new finances_player();
	 //playerStats playerStatsInstance = new playerStats();
	 //timeManager timeManager_instance = new timeManager();
	 private ship_stats shipStatsInstance;
	 private timeManager timeManagerInstance;
	 private finances_player playerFinancesInstance;
	 private playerStats playerStatsInstance;
	 
	 public EventManager(ship_stats shipStats, timeManager timeManager, finances_player playerFinances) {
        this.shipStatsInstance = shipStats;
        this.timeManagerInstance = timeManager;
        this.playerFinancesInstance = playerFinances;
    }
	
	public void eventTankExplode() {
		 Random random = new Random();
		 int costToFixFuelTank = 100;
		 int chance = random.nextInt(1000);
		 int chanceEventTankExplode =1;
		 if (chance <= chanceEventTankExplode) {
		        System.out.println("one of the ships fuel tanks ruptured and exploded it will cost " +costToFixFuelTank + " to fix");
		        if(playerFinancesInstance.getFinances()<costToFixFuelTank)
		        {
		        	System.out.println("you do not have enough money to pay the cost of the tank. There has not been a fail state impelemented for this in the game yet");
		        }
		        else
		        {
		        	playerFinancesInstance.decrease_finances(costToFixFuelTank);
		        	
		    } 
	}

}
	
	
	public void encounterDeadAstronaut() {
		 Random random = new Random();
		
		 int chance = random.nextInt(100);
		 int chanceToEncounterDeadAstronaut =1;
		 int extraTimeToRevocerDeadAstronaut = 1;
		 int increaseInReputationForRevoceringDeadAstronaut = 5;
		 
		 if (chance <= chanceToEncounterDeadAstronaut) {
		        System.out.println("your scanners detect what probably is a dead astronaut in the asterois field. You can retrive the body back to the station for a funeral. This will take "+ extraTimeToRevocerDeadAstronaut + " day/days however your reputation will inrease by 5 if you do so");
		        System.out.println("input 1 to recover the astronaut or 2 to continue on");
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        playerStatsInstance.increasePlayersReputation(increaseInReputationForRevoceringDeadAstronaut);
		        timeManagerInstance.increaseTimeDay(extraTimeToRevocerDeadAstronaut);
		        
		      
		        break;
		        case "2":
		        	
		        	
		        System.out.println("You have chosen to continue the expedition.");
                break;
                default:
                System.out.println("Invalid choice. Continuing the expedition.");
                break;
	}

}		
}
	
	public void eventDistressCallFromShip() {
		 Random random = new Random();
		
		 int chance = random.nextInt(100);
		 int chanceToEncounterEventDistressCallFromShip =1;
		 int extraTimeToHelpDistressedShip = 1;
		 int increaseInReputationForHelpingDistressedShip = 5;
		 
		 if (chance <= chanceToEncounterEventDistressCallFromShip) {
		        System.out.println("you receive a distress call from a ship in distress it will take "+ extraTimeToHelpDistressedShip + " day/days to help however your reputation will inrease by 5 if you do so");
		        System.out.println("input 1 to recover the astronaut or 2 to continue on");
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        playerStatsInstance.increasePlayersReputation(increaseInReputationForHelpingDistressedShip);
		        timeManagerInstance.increaseTimeDay(extraTimeToHelpDistressedShip);
		        
		      
		        break;
		        case "2":
		        	
		        	
		        System.out.println("You have chosen to continue the expedition.");
               break;
               default:
               System.out.println("Invalid choice. Continuing the expedition.");
               break;
	}

}		
}
	
	
	
	
}
