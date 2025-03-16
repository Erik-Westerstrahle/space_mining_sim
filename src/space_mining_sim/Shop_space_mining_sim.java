	package space_mining_sim;
	import java.util.Scanner;
	
	public class Shop_space_mining_sim {
		
		// Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();
		
		private boolean haveBoughtMiningArm = false;
		private boolean haveBoughtFusionEngine = false;
		private boolean haveFusionEngine = false;
		private boolean haveBoughtBasicCrewQuarters = false;
		private boolean haveBoughtBasicRadar = false;
		private boolean haveBoughtSmallMiningLaser = false;
		private boolean haveBoughtMediumMiningLaser = false;
	
		private double incomeMultiplier =1.0;
		private double timeTakeWithFusionEngine =1.0;

		
		
		int bonusSmallMiningLaser = 1;
		
		
		
		int priceFusionEngine = 200;
		int priceMiningArm = 100;
		int priceBasicCrewQuarters = 100;
		int priceSmallMiningLaser = 100;
		
		int sellValueWaterIce = 300;
		int sellValueCopper = 500;
		int sellValueSilver = 800;
		int sellValueGold = 1000;
		int sellValuePlatinum = 1500;
			
		//ship_stats shipStats_instance = new ship_stats();
		   ship_stats shipStats_instance = new ship_stats();
		  //private ship_stats shipStats_instance;
	       playerStats playerStatsInstance = new playerStats(); 
	       timeManager timeManager_instance = new timeManager();
	       storyDescriptionsText storyDescriptionsTextInstance = new storyDescriptionsText();
	       private stockMarket stockMarketInstance  = new stockMarket();
	    //   mining_expedition_simulation miningExpedition_shop;
		//   finances_player playerFinances = new finances_player();
	       
	       private mining_expedition_simulation miningExpedition_shop;
	       private finances_player playerFinances;
	       
	
	   	
	
		   
	
		  
		  
		    public void setShipStatsInstance(ship_stats shipStats_instance) {
		        this.shipStats_instance = shipStats_instance;
		    }
		    
		    
		    public void setMiningExpedition(mining_expedition_simulation miningExpedition_shop) {
		        this.miningExpedition_shop = miningExpedition_shop;
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
		
		
		private void purchaseSmallMiningLaser(finances_player playerFinances) {
	    	
	    	if (haveBoughtSmallMiningLaser) {
	    		System.out.println("You have already purchased the small mining laser.");
	    	} else if (playerFinances.getFinances() >= priceSmallMiningLaser) {
	            playerFinances.decrease_finances(priceSmallMiningLaser);
	            haveBoughtSmallMiningLaser = true;
	             bonusSmallMiningLaser = 1;
	        
	            System.out.println("small mining laser purchased successfully!");
	            shipStats_instance.updateShipFeatures();
	       
	        } else {
	            System.out.println("Not enough credits to purchase the small mining laser.");
	    	}
	    	
	    }
		
		private void purchaseMediumMiningLaser(finances_player playerFinances) {
	    	
	    	if (haveBoughtSmallMiningLaser) {
	    		System.out.println("You have already purchased the small mining laser.");
	    	} else if (playerFinances.getFinances() >= priceSmallMiningLaser) {
	            playerFinances.decrease_finances(priceSmallMiningLaser);
	            haveBoughtSmallMiningLaser = true;
	             bonusSmallMiningLaser = 1;
	        
	            System.out.println("small mining laser purchased successfully!");
	            shipStats_instance.updateShipFeatures();
	       
	        } else {
	            System.out.println("Not enough credits to purchase the small mining laser.");
	    	}
	    	
	    }
		
		// this function is used when the player starts a new game
	    public void resetShop() {
	        this.haveBoughtMiningArm = false;
	        this.haveBoughtFusionEngine = false;
	        this.haveFusionEngine = false;
	        this.haveBoughtBasicCrewQuarters = false;
	        this.haveBoughtBasicRadar = false;
	        this.haveBoughtSmallMiningLaser = false;
	        this.haveBoughtMediumMiningLaser = false;
	        this.incomeMultiplier = 1.0;
	        this.timeTakeWithFusionEngine = 1.0;
	        this.bonusSmallMiningLaser = 0;
	    }
	 
			 
			 
			 
			 // checks if the player has bought the Mining arm
		        boolean hasBoughtMiningArm() {
		            return haveBoughtMiningArm;
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
		        
		        boolean getHaveBoughtSmallMiningLaser() {
		            return haveBoughtSmallMiningLaser;
		        }
		        
		        int getSmallMiningLaserValue() {
		            return bonusSmallMiningLaser;
		        }
		        
		        
		        
		        public void setHaveBoughtSmallMiningLaser(boolean newHaveBoughtMiningArm) {
		        
		        	this.haveBoughtMiningArm = newHaveBoughtMiningArm;
		        }
		        
		        public void setHaveBoughtMiningArm(boolean newHaveBoughtMiningArm) {
		        	// TODO Auto-generated method stub
		        	this.haveBoughtMiningArm = newHaveBoughtMiningArm;
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
		        
			 
		
		
		
		
		public void check_what_have_bought()
		{
			if(haveBoughtMiningArm)
			{
				 System.out.println("owns  Mining Arm = "+haveBoughtMiningArm);
			}
			
			if(haveBoughtFusionEngine)
			{
				 System.out.println("owns Fusion Engine = "+haveBoughtFusionEngine);
			}
			
			if(haveBoughtBasicRadar)
			{
				System.out.println("owns Basic Radar = "+haveBoughtBasicRadar);
			}
			
			if(haveBoughtMiningArm)
			{
				 System.out.println("haveBoughtMiningArm = "+haveBoughtMiningArm);
			}
			
	
			if(haveBoughtFusionEngine)
			{
				 System.out.println("haveBoughtFusionEngine = "+haveBoughtFusionEngine);
			}
			
			if(haveBoughtBasicRadar)
			{
				System.out.println("haveBoughtBasicRadar = "+haveBoughtBasicRadar);
			}
		
		
			
			 
		}
		
		
		public void spaceship_parts_prices(int engine_price)
		{
		 engine_price = 100;
					 
		 System.out.println(engine_price);	 
			 
		}
		
		
		
	
		
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
		
		// function that lets player repair a specific amount of the hull instead of all
		public void repairHullSpecificAmountShop()
		{
	        Scanner scan = new Scanner(System.in);
	        int choice =  scan.nextInt();
	       
	        int variablerepairHullSpecificAmount = shipStats_instance.getHullIntegrity()+choice;
	        shipStats_instance.setHullIntegrity(variablerepairHullSpecificAmount);
		}
		
		public void sellResourceUnits() {
			 int waterIceAmount = miningExpedition_shop.getWaterIceAmount();
		    int copperAmount = miningExpedition_shop.getCopperAmount();
		    int silverAmount = miningExpedition_shop.getSilverAmount();
		    int goldAmount = miningExpedition_shop.getGoldAmount();
		    int platinumAmount = miningExpedition_shop.getPlatinumAmount();
	
		    System.out.println("Debug: water ice = "+ waterIceAmount + "Debug: Copper = " + copperAmount + ", Silver = " + silverAmount + ", Gold = " + goldAmount+ ", Platinum = " + platinumAmount);
	
		   
		    //int moneySellingCopperResourceUnits = copperAmount * 500; 
		    //int moneySellingSilverResourceUnits = silverAmount * 800; 
		    //int moneySellingGoldResourceUnits = goldAmount * 1000; 
		    //int moneySellingPlatinumResourceUnits = platinumAmount * 1500; 
		    
		    int moneySellingWaterIceResourceUnits = Math.round(waterIceAmount * sellValueWaterIce* stockMarketInstance.getWaterPriceRandom()); 
		    int moneySellingCopperResourceUnits = Math.round(copperAmount * sellValueCopper*stockMarketInstance.getCopperPriceRandom()); 
		    int moneySellingSilverResourceUnits = Math.round(silverAmount * sellValueSilver*stockMarketInstance.getSilverPriceRandom()); 
		    int moneySellingGoldResourceUnits = Math.round(goldAmount * sellValueGold*stockMarketInstance.getGoldPriceRandom()); 
		    int moneySellingPlatinumResourceUnits = Math.round(platinumAmount * sellValuePlatinum*stockMarketInstance.getPlatinumPriceRandom()); 
	
		    int totalCredits = moneySellingWaterIceResourceUnits+ moneySellingCopperResourceUnits + moneySellingSilverResourceUnits + moneySellingGoldResourceUnits+moneySellingPlatinumResourceUnits;
	
		    //System.out.println("DEBUG stock market. Original price: "+ (waterIceAmount * sellValueWaterIce) + " |stockmarket price: "+moneySellingWaterIceResourceUnits );
		    //System.out.println("DEBUG stock market water multiplier "+stockMarketInstance.getWaterPriceRandom());	
		    System.out.println("Money from selling water ice = " + moneySellingWaterIceResourceUnits + " Credits");
		    System.out.println("Money from selling copper = " + moneySellingCopperResourceUnits + " Credits");
		    System.out.println("You sold all your resource units. You get = " + totalCredits + " Credits");
		    playerFinances.increase_finances(totalCredits);
	
		    // Reset resources after selling
		    miningExpedition_shop.resetResources();
		}
	
	
	
	
	
				
	
	}
