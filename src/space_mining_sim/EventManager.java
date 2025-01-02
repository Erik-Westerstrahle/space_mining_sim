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
	 private Astronauts astronautsInstance;
	 private hireAstronauts hireAstronautsInstance;
	 private assignAstronauts assignAstronautsInstance;
	 
	 public EventManager(ship_stats shipStats, timeManager timeManager, finances_player playerFinances, playerStats playerStatsInstance,hireAstronauts hireAstronautsInstance,assignAstronauts assignAstronautsInstance ) {
        this.shipStatsInstance = shipStats;
        this.timeManagerInstance = timeManager;
        this.playerFinancesInstance = playerFinances;
        this.playerStatsInstance = playerStatsInstance;
        //this.astronautsInstance=astronautsInstance;
        this.hireAstronautsInstance = hireAstronautsInstance;
        this.assignAstronautsInstance =assignAstronautsInstance;
    }
	 
	 // add that skill check gets bonus from astronauts
private boolean performSkillCheck(int playerSkillLevels, int astronautSkillLevel,int difficulty)
{
	 Random random = new Random();
	 int roll = random.nextInt(100) + 1;
	 int total = roll + playerSkillLevels+astronautSkillLevel;
	 System.out.println("Roll: " + roll + ", Skill Level: "+ playerSkillLevels+"bonus from astronaut skill" +astronautSkillLevel);
	 System.out.println("Difficulty was " + difficulty);
	 return total >= difficulty;
	 
	 
}
	
	public void eventTankExplode() {
		 Random random = new Random();
		 int costToFixFuelTank = 100;
		 int chance = random.nextInt(1000);
		 int chanceEventTankExplode =1;
		 if (chance <= chanceEventTankExplode) {
		        System.out.println("one of the ships fuel tanks ruptured and exploded it will cost " +costToFixFuelTank + " to fix");
		        shipStatsInstance.reduceShipHull(5);
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
		 //diceRoll = random.nextInt(100);
		 int chance = random.nextInt(100);
		// chance = random.nextInt(100);
		 int chanceToEncounterDeadAstronaut =90;
		 int extraTimeToRevocerDeadAstronaut = 1;
		 int increaseInReputationForRevoceringDeadAstronaut = 5;
		 int chanceSucceedEncounterDeadAstronautEvent =50;
		 
		  System.out.println("event dead astronaut dice rolled "+chance);
		 
		 if (chance >= chanceToEncounterDeadAstronaut) {
		
		        System.out.println("your scanners detect what probably is a dead astronaut in the asterois field. You can retrive the body back to the station for a funeral. This will take "+ extraTimeToRevocerDeadAstronaut + " day/days however your reputation will inrease by 5 if you do so");
		        System.out.println("input 1 to recover the astronaut or 2 to continue on");
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        // 	 if(playerStatsInstance.rollD100()+playerStatsInstance.getLevelAstrogatorSkillPlayer()>chanceSucceedEncounterDeadAstronautEvent||playerStatsInstance.rollD100()+playerStatsInstance.getLevelAstrogatorSkillPlayer()==chanceSucceedEncounterDeadAstronautEvent)
		        	  if(performSkillCheck(playerStatsInstance.getLevelAstrogatorSkillPlayer(),assignAstronautsInstance.getAssignedAstrogatorSkill(), chanceSucceedEncounterDeadAstronautEvent))
		    		  {
		         		 
		         		 System.out.println("Suceeded with skill check");
		         		System.out.println("you rolled "+playerStatsInstance.getRollD100()+" + Player astrogator skill "+ playerStatsInstance.getLevelAstrogatorSkillPlayer());
		         		int totalRoll = playerStatsInstance.getRollD100()+ playerStatsInstance.getLevelAstrogatorSkillPlayer();
		         		System.out.println("Total: "+ totalRoll );
                		playerStatsInstance.increasePlayersReputation(increaseInReputationForRevoceringDeadAstronaut);
          		        timeManagerInstance.increaseTimeDay(extraTimeToRevocerDeadAstronaut);
          		        shipStatsInstance.increaseCrewMorale(5);
                	 }
		         	 else
		         	 {
		         		System.out.println("failed skill check");
		         		System.out.println("you rolled "+playerStatsInstance.getRollD100()+" + Player astrogator skill "+ playerStatsInstance.getLevelAstrogatorSkillPlayer());
		         		int totalRoll = playerStatsInstance.getRollD100()+ playerStatsInstance.getLevelAstrogatorSkillPlayer();
		         		System.out.println("Total: "+ totalRoll );
		         		System.out.println("the body is lost");
		         		 break; 
		         	 }
		    
		        
		      
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
		
		// int chance = random.nextInt(100)+1;
		 int chance = random.nextInt(100);
		 int chanceToEncounterEventDistressCallFromShip =90;
		 int extraTimeToHelpDistressedShip = 1;
		 int increaseInReputationForHelpingDistressedShip = 5;
		 int chanceToSucceedEventDistressCallFromShip =25;
		 
		 if (chance >= chanceToEncounterEventDistressCallFromShip) {
		        System.out.println("you receive a distress call from a ship in distress it will take "+ extraTimeToHelpDistressedShip + " day/days to help however your reputation will inrease by 5 if you do so");
		        System.out.println("input 1 to help the ship or 2 to continue on");
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        	
		       	 if(performSkillCheck(playerStatsInstance.getLevelAstrogatorSkillPlayer(),assignAstronautsInstance.getAssignedAstrogatorSkill(), chanceToSucceedEventDistressCallFromShip))
            	 {	
		       		 
		 //      	System.out.println("Suceeded with skill check");
		 //       System.out.println("you rolled "+playerStatsInstance.getRollD100()+" + Player astrogator skill "+ playerStatsInstance.getLevelAstrogatorSkillPlayer());
		 //        int totalRoll = playerStatsInstance.getRollD100()+ playerStatsInstance.getLevelAstrogatorSkillPlayer();
		   //     System.out.println("Total: "+ totalRoll );	 
		        playerStatsInstance.increasePlayersReputation(increaseInReputationForHelpingDistressedShip);
		        timeManagerInstance.increaseTimeDay(extraTimeToHelpDistressedShip);
		        shipStatsInstance.increaseCrewMorale(10);
            	 }
		      
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
	
	
	public void eventEncounterAbandonedAsteroideMine() {
		 Random random = new Random();
		
		// int chance = random.nextInt(100)+1;
		 int chance = random.nextInt(100);
		 int chanceToEncounterAbandonedAsteroideMine =90;

		 
		 if (chance >= chanceToEncounterAbandonedAsteroideMine) {
		        System.out.println("you encountered an abandoned asteroid mine. It was abandoned a long time ago. There is nothing here you continue onwards");
		 
		 }
		 else {
			 
		 }
			 
		 
			 
	
}
	
	public void eventExtortionFromMiner() {
		 Random random = new Random();
			
		 int chance = random.nextInt(1000);
		 int chanceToEncounterThisEvent =1;
		 int moneyToPayToExtortionists = 300;
		int chanceToSucceedEventExtortionFromMiner =25;
		 
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
		        	
		        	
		       	 if(performSkillCheck(playerStatsInstance.getLevelAstrogatorSkillPlayer(),assignAstronautsInstance.getAssignedMinerGeologistSkill(), chanceToSucceedEventExtortionFromMiner))
            	 {		
		        System.out.println("You have chosen to continue the expedition.");
		  
            	 }
		       	 else
		       	 {
		             int damagedHull = shipStatsInstance.getHullIntegrity();
				        shipStatsInstance.setHullIntegrity(damagedHull-5); 
		       	 }
	              
		      
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
		 int chanceToSucceedEncounterDerelictShip = 25;
		 
		 if (chance <= chanceToEncounterThisEvent) {
			 
		
			   System.out.println("You encounter a derelict ship in the planetary rings");
			   System.out.println("You can salvage the ship for money but it will take extra time");
			   
			   
		        Scanner scanner = new Scanner(System.in);
		        String choice = scanner.nextLine();
		        switch(choice)
				  {
		        case "1":
		        	
		        	if(performSkillCheck(playerStatsInstance.getLevelEngineeringSkillPlayer(),assignAstronautsInstance.getAssignedMechanicSkill() ,chanceToSucceedEncounterDerelictShip))
		        	{
		        	 System.out.println("You earn "+ earnMoneyFromShipSalvage +" from salvaging the ship and selling the salvage");
		        	playerFinancesInstance.increase_finances(earnMoneyFromShipSalvage);
		        	  timeManagerInstance.increaseTimeDay(5);// set here how much time this event should take
		        	}
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
			 System.out.println("You receive a strange radio message saying: This patroll ship the Buffalo. Stop your engines and prepare to be scanned for weapons and contraband");
			 System.out.println("You recognise the ships name. The ship is famous for hunting pirates. It is heavily armed. You know it is better to be scanned instead of running");
			 System.out.println("After a couple of tense minutes the Buffalo sends the message");
			 System.out.println("Your ship is cleared you may proceed");
			 System.out.println("The Munich then starts burning fast. to where you do not know");

		    } 
	}
	public void toxicMaterialAmongOre() {
		Random random = new Random();
		int chance = random.nextInt(100);
		int chanceToxic =1;
		shipStatsInstance.decreaseCrewMorale(5);
		shipStatsInstance.reduceShipHull(5);
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
   
   // cant call this event
   public void eventGoGambling() {
	Random random = new Random();
	
	int amountMoneyGamble = random.nextInt(100);
	int chance = random.nextInt(100);
	int chanceGambling = random.nextInt(100);
	int chanceEventGoGambling =1;
	int chanceWinGambling =20;
	if (chance <= chanceEventGoGambling) 
	{
		 System.out.println("You gamble in an online casino to relax");
		 System.out.println("You gamble "+amountMoneyGamble);
		 if(chanceWinGambling<=chanceGambling)
		 {
			 System.out.println("You win "+(2*amountMoneyGamble));
			 playerFinancesInstance.increase_finances(2*amountMoneyGamble);
		 }
		 else
		 {
			 System.out.println("You lost "+(2*amountMoneyGamble));
		 }

	}

}
   
   public void chancetoSucceedSkillCheck()
   {
	   playerStatsInstance.getLevelAstrogatorSkillPlayer();
   }
	
	public void callAllEvents() {
		eventTankExplode();
		encounterDeadAstronaut();
		eventDistressCallFromShip();
		eventExtortionFromMiner();
		encounterDerelictShip();
		eventFindDroppedCargo();
		eventEncounterEnforcers();
		eventGoGambling();
	}
	
	
	
	
}
