package space_mining_sim;
import java.util.Scanner;

public class Shop_space_mining_sim {
	
	// Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();
	
	private boolean haveBoughtMiningArm = false;
	private boolean haveBoughtFusionEngine = false;
	private boolean haveFusionEngine = false;
	private boolean haveBoughtBasicCrewQuarters = false;
	private boolean haveBoughtBasicRadar = false;
	private double incomeMultiplier =1.0;
	private double timeTakeWithFusionEngine =1.0;
	
	
	
	int priceFusionEngine = 200;
	int priceMiningArm = 100;
	int priceBasicCrewQuarters = 100;
		
	//ship_stats shipStats_instance = new ship_stats();
	   ship_stats shipStats_instance = new ship_stats();
	  //private ship_stats shipStats_instance;
       playerStats playerStatsInstance = new playerStats(); 
       timeManager timeManager_instance = new timeManager();
       storyDescriptionsText storyDescriptionsTextInstance = new storyDescriptionsText();
    //   mining_expedition_simulation miningExpedition;
	//   finances_player playerFinances = new finances_player();
       
       private mining_expedition_simulation miningExpedition;
       private finances_player playerFinances;

	   

	  
	  
	    public void setShipStatsInstance(ship_stats shipStats_instance) {
	        this.shipStats_instance = shipStats_instance;
	    }
	    
	    
	    public void setMiningExpedition(mining_expedition_simulation miningExpedition) {
	        this.miningExpedition = miningExpedition;
	    }

	    public void setPlayerFinances(finances_player playerFinances) {
	        this.playerFinances = playerFinances;
	    }
	    
	    

	
	public void spaceship_parts_store(finances_player playerFinances)
	{
		 System.out.println("1. Purchase mining arm " + priceMiningArm + " credits");
		 System.out.println("2.fusion engine " + priceFusionEngine + " credits");
		 System.out.println("3. basic crew quarters " + priceBasicCrewQuarters + " credits");
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
	        case "3":
	        	purchaseBasicCrewQuarters(playerFinances);
	              
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
	                shipStats_instance.updateShipFeatures();
	              //  shipStats_instance.checkIfShipHasMiningArm();  // Update ship stats
	            } else {
	                System.out.println("Not enough credits to purchase the mining arm.");
	        	}
	        	
	        }
	
	private void purchaseBasicRadar(finances_player playerFinances) {
    	
    	if (haveBoughtBasicRadar==true) // checks if you have already bought the radar
    	{
    		System.out.println("You have already purchased the basic radar.");
    	} else if (playerFinances.getFinances() >= 100) {
            playerFinances.decrease_finances(100);
            haveBoughtBasicRadar = true;
 
           
            System.out.println("basic radar purchased successfully!");
            shipStats_instance.updateShipFeatures();
          //  shipStats_instance.checkIfShipHasMiningArm();  // Update ship stats
        } else {
            System.out.println("Not enough credits to purchase the basic radar.");
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
            shipStats_instance.updateShipFeatures();
       
        } else {
            System.out.println("Not enough credits to purchase the fusion engine.");
    	}
    	
    }
	
	
	
	public void purchaseBasicCrewQuarters(finances_player playerFinances) {
		System.out.println("shipStats_instance "+shipStats_instance);
	    if (haveBoughtBasicCrewQuarters) {
	        System.out.println("You have already purchased the basic crew quarters.");
	    } else if (playerFinances.getFinances() >= priceBasicCrewQuarters) {
	        playerFinances.decrease_finances(priceBasicCrewQuarters);
	        haveBoughtBasicCrewQuarters = true;
	
	        if (shipStats_instance != null) {
	            shipStats_instance.upgradeToBasicCrewQuarters(); // Update ship stats
	        } else {
	            System.out.println("Error: Ship stats instance is not initialized.");
	        }
	        System.out.println("Basic crew quarters purchased successfully!");
	        shipStats_instance.updateShipFeatures();

	    } else {
	        System.out.println("Not enough credits to purchase the basic crew quarters.");
	    }
    	
    }
	
	// this function is used when the player starts a new game
    public void resetShop() {
        this.haveBoughtMiningArm = false;
        this.haveBoughtFusionEngine = false;
        this.haveFusionEngine = false;
        this.haveBoughtBasicCrewQuarters = false;
        this.haveBoughtBasicRadar = false;
        this.incomeMultiplier = 1.0;
        this.timeTakeWithFusionEngine = 1.0;
    }
 
		 
		 
		 
		 // checks if the player has bought the Mining arm
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
	        
	        boolean getHaveBoughtBasicRadar() {
	            return haveBoughtBasicRadar;
	        }
	        
	        public void setHaveBoughtFusionEngine(boolean newHaveBoughtFusionEngine) {
	        	// TODO Auto-generated method stub
	        	this.haveBoughtFusionEngine = newHaveBoughtFusionEngine;
	        }
	        
	        public void setHaveBoughtBasicRadar(boolean newHaveBoughtBasicRadar) {
	        	// TODO Auto-generated method stub
	        	this.haveBoughtBasicRadar = newHaveBoughtBasicRadar;
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
	
	public void sellResourceUnits() {
	    int copperAmount = miningExpedition.getCopperAmount();
	    int silverAmount = miningExpedition.getSilverAmount();
	    int goldAmount = miningExpedition.getGoldAmount();
	    
	    System.out.println("Debug: Copper = " + copperAmount + ", Silver = " + silverAmount + ", Gold = " + goldAmount);

	    int moneySellingCopperResourceUnits = copperAmount * 10;
	    int moneySellingSilverResourceUnits = silverAmount * 50;
	    int moneySellingGoldResourceUnits = goldAmount * 100;

	    int totalCredits = moneySellingCopperResourceUnits + moneySellingSilverResourceUnits + moneySellingGoldResourceUnits;

	    System.out.println(" you sold all your resource units. You get = " + totalCredits + " Credits");
	    playerFinances.increase_finances(totalCredits);

	    // Reset resources
	    miningExpedition.resetResources();
	}




			

}
