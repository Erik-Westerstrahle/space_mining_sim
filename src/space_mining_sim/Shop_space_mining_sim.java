package space_mining_sim;
import java.util.Scanner;

public class Shop_space_mining_sim {
	
	// Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();
	
	private boolean haveBoughtMiningArm = false;
	private boolean haveBoughtFusionEngine = false;
	private boolean haveFusionEngine = false;
	private double incomeMultiplier =1.0;
	private double timeTakeWithFusionEngine =1.0;
	
	int priceFusionEngine = 200;
	int priceMiningArm = 100;
	
	//ship_stats shipStats_instance = new ship_stats();
	
	public void spaceship_parts_store(finances_player playerFinances)
	{
		 System.out.println("1. Purchase mining arm " + priceMiningArm + "credits");
		 System.out.println("2.fusion engine " + priceFusionEngine + "credits");
	        System.out.println("Enter the number of the item you want to purchase, or 'b' to go back:");
		// System.out.println("pres r to repair hull");
		 
	        Scanner scanner = new Scanner(System.in);
	        String choice = scanner.nextLine();
	        
	        switch (choice) {
	        case "1":
	        	 purchaseMiningArm(playerFinances);
	              
	        	 break;
	        case "2":
	        	purchaseFusionEngine(playerFinances);
	              
	        	 break;
	                
	        case "b":
                // Go back
                break;
            default:
                System.out.println("Invalid choice.");
                break;    
	        	
	        }
	}
	        
	private void purchaseMiningArm(finances_player playerFinances) {
	        	
	        	if (haveBoughtMiningArm) {
	        		System.out.println("You have already purchased the mining arm.");
	        	} else if (playerFinances.getFinances() >= 100) {
	                playerFinances.decrease_finances(100);
	                haveBoughtMiningArm = true;
	                incomeMultiplier = 1.2;
	                System.out.println("Mining arm purchased successfully!");
	            } else {
	                System.out.println("Not enough credits to purchase the mining arm.");
	        	}
	        	
	        }
	
	
	private void purchaseFusionEngine(finances_player playerFinances) {
    	
    	if (haveBoughtFusionEngine) {
    		System.out.println("You have already purchased the fusion engine.");
    	} else if (playerFinances.getFinances() >= priceFusionEngine) {
            playerFinances.decrease_finances(priceFusionEngine);
            haveBoughtFusionEngine = true;
            timeTakeWithFusionEngine = 0.1;
            System.out.println("fusion engine purchased successfully!");
        } else {
            System.out.println("Not enough credits to purchase the fusion engine.");
    	}
    	
    }
 
		 
		 
		 
		 
	        boolean hasBoughtMiningArm() {
	            return haveBoughtMiningArm;
	        }
	        
	        public void setHaveBoughtMiningArm(boolean newHaveBoughtMiningArm) {
	        	// TODO Auto-generated method stub
	        	this.haveBoughtMiningArm = newHaveBoughtMiningArm;
	        }

	        public double getIncomeMultiplier() {
	            return incomeMultiplier;
	        }
	        
	        
				 
	        boolean getHaveBoughtFusionEngine() {
	            return haveBoughtFusionEngine;
	        }
	        public void setHaveBoughtFusionEngine(boolean newHaveBoughtFusionEngine) {
	        	// TODO Auto-generated method stub
	        	this.haveBoughtFusionEngine = newHaveBoughtFusionEngine;
	        }
	        
	        public double getTimeTakeWithFusionEngine() {
	            return timeTakeWithFusionEngine;
	        }
	        
		 
	
	
	
	
	public void check_what_have_bought(finances_player playerFinances)
	{
	

			
		 
	}
	
	
	public void spaceship_parts_prices(int engine_price)
	{
	 engine_price = 100;
				 
	 System.out.println(engine_price);	 
		 
	}
	
	
	
								//   remember you can input instance of classes as variables
											//V
	
	public void refuel_spaceship(ship_stats shipStats_instance, finances_player playerFinances)
	{
		 System.out.println(" press f to refuel your ship");
		 

		 shipStats_instance.reset_fuel(100);
		 playerFinances.decrease_finances(10); // Decrease finances by 10
		 playerFinances.print_finances();
		
	}
	
	
	
	public void repair_hull()
	{
		 System.out.println(" press r to refuel your ship");
		
	}



			

}
