// EventManager.java

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
		        shipStatsInstance.increaseCrewMorale(5);
		        
		      
		        break;
		        case "2":
		        	
		        	
		        System.out.println("You have chosen to continue the expedition.");
		        shipStatsInstance.decreaseCrewMorale(5);
                break;
                default:
                System.out.println("Invalid choice. Continuing the expedition.");
                break;
	}

}		
}
	// event where player receives a distress call and the player has to decide on what to do
	
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
		        shipStatsInstance.increaseCrewMorale(10);
		      
		        break;
		        case "2":
		        	
		        	 shipStatsInstance.decreaseCrewMorale(10);	
		        System.out.println("You have chosen to continue the expedition.");
               break;
               default:
               System.out.println("Invalid choice. Continuing the expedition.");
               break;
	}

}		
}
	
	public void eventExtortionFromMiner() {
		 Random random = new Random();
			
		 int chance = random.nextInt(1000);
		 int chanceToEncounterThisEvent =1;
		 int moneyToPayToExtortionists = 300;
		 
		 if (chance <= chanceToEncounterThisEvent) {
			 
			   System.out.println("you are extorted for protection money when you are on an expeition. They demad that you pay " + moneyToPayToExtortionists + " to pass safely");
			   System.out.println(" if you do not pay it it is likey your ship will suffer harm");
			   System.out.println("input 1 to pay up or 2 to try to run");
			   
			   
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        	if(playerFinancesInstance.getFinances()<moneyToPayToExtortionists) {
		        		System.out.println("you do not have enough money to pay the cost of the tank. There has not been a fail state impelemented for this in the game yet");
		        		
		        	}
		        	else {
		        		  playerFinancesInstance.decrease_finances(moneyToPayToExtortionists);
		  		        
		        	}
		 
		        
		      
		        break;
		        case "2":
		        	
		        	
		        System.out.println("You have chosen to continue the expedition.");
		        int damagedHull = shipStatsInstance.getHullIntegrity();
		        shipStatsInstance.setHullIntegrity(damagedHull-5);
	              
		      
               break;
               default:
               System.out.println("Invalid choice. Continuing the expedition.");
               break;
	}
		 }
		
	}
	
	public void encounterDerelictShip() {
		
		 Random random = new Random();
			
		 int chance = random.nextInt(1000);
		 int chanceToEncounterThisEvent =1;
		 int earnMoneyFromShipSalvage = 300;
		 
		 if (chance <= chanceToEncounterThisEvent) {
			 
		
			   System.out.println("You encounter a derelict ship in the planetary rings");
			   System.out.println("You can salvage the ship for money but it will take extra time");
			   
			   
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        	 System.out.println("You earn "+ earnMoneyFromShipSalvage +" from salvaging the ship and selling the salvage");
		        	playerFinancesInstance.increase_finances(earnMoneyFromShipSalvage);
		        	  timeManagerInstance.increaseTimeDay(5);// set here how much time this event should take
		      
		        break;
		        case "2":
		        	
		        	
		        System.out.println("You have chosen to continue the expedition and leave the ship.");
		
	              
		      
             break;
             default:
             System.out.println("Invalid choice. Continuing the expedition.");
             break;
	}
		 }
	
	}
	
	
	public void eventFindDroppedCargo() {
	     
		 Random random = new Random();
		 int valueDroppedCargo = 10000;
		 int chance = random.nextInt(100);
		 int chanceEventFindDroppedCargoe =1;
		 if (chance <= chanceEventFindDroppedCargoe) {
			 playerFinancesInstance.increase_finances(valueDroppedCargo);
			 System.out.println("You scanners found an abandoned cargocontainer filled with valuable ores. From where it came from you do not know");
			 shipStatsInstance.increaseCrewMorale(10);

		    } 
	}
	
	
	
	public void eventEncounterEnforcers() {
		 Random random = new Random();
		
		 int chance = random.nextInt(500);
		 int chanceToEncounterThisEvent =1;
		 if (chance <= chanceToEncounterThisEvent) {
			 System.out.println("You receive a strange radio message saying: This patroll ship the Munich. Stop your engines and prepare to be scanned for weapons and contraband");
			 System.out.println("You recognise the ships name. The ship is famous for hunting pirates. It is heavily armed. You know it is better to be scanned instead of running");
			 System.out.println("After a couple of tense minutes the Munich seds the message");
			 System.out.println("Your ship is cleared you may proceed");
			 System.out.println("The Munich then starts burning fast. to where you do not know");

		    } 
	}
	public void toxicMaterialAmongOre() {
		Random random = new Random();
		int chance = random.nextInt(100);
		int chanceToxic =1;
		shipStatsInstance.decreaseCrewMorale(5);	
		//Normal store don't want to buy, have to find other store or dump ore
   }
	public void eventFamilyrobbed() {
		Random random = new Random();
		int valueRobbed = 1000;
		int chance = random.nextInt(100);
		int chanceEventrobbed =1;
		if (chance <= chanceEventrobbed) {
			playerFinancesInstance.decrease_finances(valueRobbed);
		   } 
   }
   public void eventFamilybonding() {
	Random random = new Random();
	int relationshipChange = 5;
	int chance = random.nextInt(100);
	int chanceEventrobbed =1;

}
	
	public void callAllEvents() {
		eventTankExplode();
		encounterDeadAstronaut();
		eventDistressCallFromShip();
		eventExtortionFromMiner();
		encounterDerelictShip();
		eventFindDroppedCargo();
		eventEncounterEnforcers();
	}
	
	
	
	
}
