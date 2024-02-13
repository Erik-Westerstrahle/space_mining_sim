package space_mining_sim;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class mining_expedition_simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	ship_stats shipStats_instance = new ship_stats();
	


	private timeManager timeManager_instance;
	

	 private playerStats playerStatsInstance;
	
	//dependency injection
	  public mining_expedition_simulation(timeManager timeManager_instance, playerStats playerStatsInstance) {
	        this.timeManager_instance = timeManager_instance;
	        this.playerStatsInstance = playerStatsInstance;
	        // Other initializations...
	    }
	  
	  EventManager eventManagerInstance = new EventManager(shipStats_instance, timeManager_instance, null);
	// timeManager timeManager_instance = new timeManager();
	


	// dependency injection 
	public void go_on_mining_expedition(finances_player playerFinances, ship_stats shipStats) {
		
		int receive_money = 300;
	    
        System.out.println("Went mining");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats.setWentOnMiningExpedition(true); // Set flag on the passed shipStats instance
	}
	
	
	
	public void select_where_go_mining(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance, timeManager timeManager) throws IOException
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
                  timeManager.advanceTime(5 * 0.6*playerStatsInstance.bonusesFromAstrogatorPlayerSkill());
        		  System.out.println("fusion engine lowered time");
        		  playerStatsInstance.increaseEngineeringExperiencePlayer(5);
        	  }
        	  else
        	  {
        		    go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                    timeManager.advanceTime(5*playerStatsInstance.bonusesFromAstrogatorPlayerSkill());
                    System.out.println("took 5 days to mine");
                    playerStatsInstance.increaseEngineeringExperiencePlayer(5);
        	  }
          
              break;
          case "2":

              if(shop_instance.getHaveBoughtFusionEngine()==true)
        	  {
        		  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                  timeManager.advanceTime(10 * 0.6);
        		  System.out.println("fusion engine lowered time");
        		  playerStatsInstance.increaseEngineeringExperiencePlayer(15);
        	  }
        	  else
        	  {
        		    go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                    timeManager.advanceTime(10);
                    System.out.println("took 10 days to mine");
                    playerStatsInstance.increaseEngineeringExperiencePlayer(5);
        	  }
              break;
          case "3":

              if(shop_instance.getHaveBoughtFusionEngine()==true)
        	  {
        		  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
                  timeManager.advanceTime(15 * 0.6);
        		  //sSystem.out.println("fusion engine lowered time");
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

	
	public void go_on_mining_outer_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) throws IOException {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 2; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	 List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
	        System.out.println("Went mining outer ring");
	        
	        //events that can happen are listed here
	        eventManagerInstance.eventTankExplode();
	        eventManagerInstance.encounterDeadAstronaut();
	        
	        playerStatsInstance.increaseGeologistExperiencePlayer(5);
	        playerStatsInstance.levelUpGeologistPlayer();
	        
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	       // playerStatsInstance.increaseGeologistExperiencePlayer(5);
	       
	       
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	//    List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	}
	
	public void go_on_mining_mid_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) throws IOException {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 1; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	 List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
	        System.out.println("Went mining mid ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	        playerStatsInstance.increaseGeologistExperiencePlayer(5);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	public void go_on_mining_inner_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) throws IOException {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 1; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	    } else {
	    	 List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
	        System.out.println("Went mining inner ring");
	        playerFinances.increase_finances(receive_money); // Increase finances
	        System.out.println("You received " + receive_money);
	        timeManager_instance.printCurrentDate();
	        playerStatsInstance.increaseGeologistExperiencePlayer(5);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	
	
	
	public void bonusesFromHiredAstronauts()
	{
		try
		{
			int totalSkillLevel = getTotalSkillLevelFromHiredAstronauts();
			double bonusMultiplier = 1 + (totalSkillLevel / 100.0);
			 System.out.println("total level bonus " + bonusMultiplier);
			
		}
		 catch (IOException e) {
	            System.out.println("Error reading hired astronauts: " + e.getMessage());
	        }
		
			  
	}
	
	private int getTotalSkillLevelFromHiredAstronauts() throws IOException {
		int totalSkill = 0;

		  try (BufferedReader reader = new BufferedReader(new FileReader("hired_astronauts.txt"))) {
			  String line;
			  while ((line = reader.readLine()) !=null) {
				  totalSkill += extractSkillLevel(line);
				  
			  }
		  }
		  return totalSkill;
	}
	
	private int extractSkillLevel(String astronautData)
	{
		 String skillLevelPart = astronautData.split(",")[1].trim(); // "skillLevel=X"
		 return Integer.parseInt(skillLevelPart.split("=")[1]); // X
	}
	
	
	
		
		  
	
	
    // Method to calculate income considering the multiplier
    private int calculateIncome(int baseIncome, double multiplier,List<Astronauts> hiredAstronauts) {
    	double geologistBonusFromAstronauts = 1.0;
    	double geologistBonusFromPlayer = 1.0;
    	double[] levelBonuses = {0.0, 0.1, 0.3, 0.6}; // Index 0 is unused, levels start from 1
    for(Astronauts astronaut : hiredAstronauts) {
    
        if(astronaut.getOccupation().equalsIgnoreCase("Geologist"))
        {
        	geologistBonusFromAstronauts += 0.1;
        	   System.out.println("geologist bonus was applied  from player stats") ;
        }
    }
    
    int level = playerStatsInstance.getLevelGeologistSkillPlayer();
    if (level > 0 && level < levelBonuses.length) {
        geologistBonusFromPlayer += levelBonuses[level];
        System.out.println("bonus from geologist level ") ;
    }
    
    
    return (int) (baseIncome * multiplier * geologistBonusFromAstronauts* geologistBonusFromPlayer); 
    
}  
}
