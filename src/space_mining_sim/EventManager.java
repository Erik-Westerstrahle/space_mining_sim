package space_mining_sim;

import java.util.Random;

//here the events of the game are managed

public class EventManager {
	ship_stats shipStats_instance = new ship_stats();
	 finances_player playerFinances = new finances_player();
	
	
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
}
