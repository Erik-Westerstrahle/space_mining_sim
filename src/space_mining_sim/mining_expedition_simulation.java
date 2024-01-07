package space_mining_sim;

import java.util.Scanner;
import java.util.Random;


public class mining_expedition_simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	ship_stats shipStats_instance = new ship_stats();
	// timeManager timeManager_instance = new timeManager();
	
//    private Shop_space_mining_sim shop;
//
//    public mining_expedition_simulation(Shop_space_mining_sim shop_instance) {
//        this.shop_instance = shop_instance;
//        // additional initialization if necessary
//    }
//	

	// dependency injection 
	public void go_on_mining_expedition(finances_player playerFinances, ship_stats shipStats) {
		
		int receive_money = 300;
	    
        System.out.println("Went mining");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats.setWentOnMiningExpedition(true); // Set flag on the passed shipStats instance
	}
	
	
	
	public void select_where_go_mining(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance, timeManager timeManager)
	{
		 Scanner scanner = new Scanner(System.in);
		  System.out.println("press 1 to mine outer_ring, it will take 5 days");
		  System.out.println("press 2 to mine mid ring, it will take 10 days");
		  System.out.println("press 3 to mine inner ring, it will take 15 days");
		  String choice = scanner.nextLine();
		  
		  switch(choice)
		  {
          case "1":
        	  if(shop_instance.getHaveBoughtFusionEngine()==true)
        	  {
        		  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                  //timeManager.advanceTime(5 * shop.getTimeTakeWithFusionEngine());
                  timeManager.advanceTime(5 * 0.6);
        		  System.out.println("fusion engine lowered time");
        	  }
        	  else
        	  {
        		    go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                    timeManager.advanceTime(5);
                    System.out.println("took 5 days to mine");
        	  }
          
              break;
          case "2":
            //  go_on_mining_mid_ring(playerFinances, shipStats_instance, shop, timeManager );
             // timeManager.advanceTime(10);
              if(shop_instance.getHaveBoughtFusionEngine()==true)
        	  {
        		  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                  timeManager.advanceTime(10 * 0.6);
        		  System.out.println("fusion engine lowered time");
        	  }
        	  else
        	  {
        		    go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                    timeManager.advanceTime(10);
                    System.out.println("took 10 days to mine");
        	  }
              break;
          case "3":
           //   go_on_mining_inner_ring(playerFinances, shipStats_instance, shop, timeManager );
          //    timeManager.advanceTime(15);
              if(shop_instance.getHaveBoughtFusionEngine()==true)
        	  {
        		  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                  timeManager.advanceTime(15 * 0.6);
        		  System.out.println("fusion engine lowered time");
        	  }
        	  else
        	  {
        		    go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                    timeManager.advanceTime(15);
                    System.out.println("took 15 days to mine");
        	  }
              break;
          default:
              System.out.println("Invalid choice.");
              break;
		  }
	}

	
	public void go_on_mining_outer_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 2; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	int receive_money = calculateIncome(100, shop_instance.getIncomeMultiplier());
	        System.out.println("Went mining outer ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	public void go_on_mining_mid_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 10; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	int receive_money = calculateIncome(200, shop_instance.getIncomeMultiplier());
	        System.out.println("Went mining mid ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	public void go_on_mining_inner_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 100; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier());
	        System.out.println("Went mining inner ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
    // Method to calculate income considering the multiplier
    private int calculateIncome(int baseIncome, double multiplier) {
        return (int) (baseIncome * multiplier);
    }
}
