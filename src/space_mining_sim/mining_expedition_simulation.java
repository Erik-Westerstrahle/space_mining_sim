package space_mining_sim;

import java.util.Scanner;

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
	
	
	
	public void  select_where_go_mining(finances_player playerFinances, ship_stats shipStats_instance)
	{
		 Scanner scanner = new Scanner(System.in);
		  System.out.println("press 1 to mine outer_ring");
		  System.out.println("press 2 to mine mid ring");
		  System.out.println("press 3 to mine inner ring");
		  String choice = scanner.nextLine();
		  
		  switch(choice)
		  {
          case "1":
              go_on_mining_outer_ring(playerFinances, shipStats_instance);
              break;
          case "2":
              go_on_mining_mid_ring(playerFinances, shipStats_instance);
              break;
          case "3":
              go_on_mining_inner_ring(playerFinances, shipStats_instance);
              break;
          default:
              System.out.println("Invalid choice.");
              break;
		  }
	}

	
	public void go_on_mining_outer_ring(finances_player playerFinances, ship_stats shipStats_instance) {
		
		int receive_money = 100;
	    
        System.out.println("Went mining outer ring");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats_instance.setWentOnMiningExpedition(true); // Set flag on the passed shipStats_instance instance
	}
	
	public void go_on_mining_mid_ring(finances_player playerFinances, ship_stats shipStats_instance) {
		
		int receive_money = 200;
	    
        System.out.println("Went mining mid ring");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats_instance.setWentOnMiningExpedition(true); // Set flag on the passed shipStats_instance instance
	}
	
	public void go_on_mining_inner_ring(finances_player playerFinances, ship_stats shipStats_instance) {
		
		int receive_money = 300;
	    
        System.out.println("Went mining innner ring");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats_instance.setWentOnMiningExpedition(true); // Set flag on the passed shipStats_instance instance
	}
}
