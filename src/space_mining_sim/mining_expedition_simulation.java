package space_mining_sim;

import java.util.Scanner;
import java.util.Random;


public class mining_expedition_simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	ship_stats shipStats_instance = new ship_stats();
	

	// dependency injection 
	public void go_on_mining_expedition(finances_player playerFinances, ship_stats shipStats) {
		
		int receive_money = 300;
	    
        System.out.println("Went mining");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats.setWentOnMiningExpedition(true); // Set flag on the passed shipStats instance
	}
	
	
	
	public void  select_where_go_mining(finances_player playerFinances, ship_stats shipStats_instance, Shop_space_mining_sim shop)
	{
		 Scanner scanner = new Scanner(System.in);
		  System.out.println("press 1 to mine outer_ring");
		  System.out.println("press 2 to mine mid ring");
		  System.out.println("press 3 to mine inner ring");
		  String choice = scanner.nextLine();
		  
		  switch(choice)
		  {
          case "1":
              go_on_mining_outer_ring(playerFinances, shipStats_instance, shop );
              break;
          case "2":
              go_on_mining_mid_ring(playerFinances, shipStats_instance, shop);
              break;
          case "3":
              go_on_mining_inner_ring(playerFinances, shipStats_instance, shop);
              break;
          default:
              System.out.println("Invalid choice.");
              break;
		  }
	}

	
	public void go_on_mining_outer_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 2; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	int receive_money = calculateIncome(100, shop.getIncomeMultiplier());
	        System.out.println("Went mining outer ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	public void go_on_mining_mid_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 10; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	int receive_money = calculateIncome(200, shop.getIncomeMultiplier());
	        System.out.println("Went mining mid ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	public void go_on_mining_inner_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 100; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	 int receive_money = calculateIncome(300, shop.getIncomeMultiplier());
	        System.out.println("Went mining inner ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
    // Method to calculate income considering the multiplier
    private int calculateIncome(int baseIncome, double multiplier) {
        return (int) (baseIncome * multiplier);
    }
}
