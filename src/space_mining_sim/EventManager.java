package space_mining_sim;

import java.util.Random;
import java.util.Scanner;

//here the events of the game are managed

public class EventManager {
	ship_stats shipStats_instance = new ship_stats();
	 finances_player playerFinances = new finances_player();
	 playerStats playerStatsInstance = new playerStats();
	 timeManager timeManager_instance = new timeManager();
	
	
	public void eventTankExplode() {
		 Random random = new Random();
		 int costToFixFuelTank = 100;
		 int chance = random.nextInt(1000);
		 int chanceEventTankExplode =1;
		 if (chance <= chanceEventTankExplode) {
		        System.out.println("one of the ships fuel tanks ruptured and exploded it will cost " +costToFixFuelTank + " to fix");
		        if(playerFinances.getFinances()<costToFixFuelTank)
		        {
		        	System.out.println("you do not have enough money to pay the cost of the tank. There has not been a fail state impelemented for this in the game yet");
		        }
		        else
		        {
		        	playerFinances.decrease_finances(costToFixFuelTank);
		        	
		    } 
	}

}
	
	
	public void encounterDeadAstronaut() {
		 Random random = new Random();
		
		 int chance = random.nextInt(1000);
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
		        timeManager_instance.increaseTimeDay(extraTimeToRevocerDeadAstronaut);
		        
		      
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
