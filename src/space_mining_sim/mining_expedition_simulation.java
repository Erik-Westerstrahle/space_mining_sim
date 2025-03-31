package space_mining_sim;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class mining_expedition_simulation {


	
	
	ship_stats shipStats_instance = new ship_stats();
	private optionsSpaceMiningSim optionsSpaceMiningSimInstance = new optionsSpaceMiningSim();


	private timeManager timeManager_instance;
	

	 private playerStats playerStatsInstance;
	 
	 private storyDescriptionsText storyDescriptionsTextInstance;
	 private EventManager eventManagerInstance;
	 private assignAstronauts assignAstronautsInstance;
	private QuestManager QuestManagerInstance;
	private Astronauts AstronautsInstance;
	private stockMarket stockMarketInstance;
	// private Astronauts AstronautsMiningExpeditionsSimulationInstance;
	 
	
	 // integers for how many resources
	 int waterIceAmount = 0; 
	int ironAmount = 0;
 	int copperAmount = 0; 
 	int silverAmount = 0;
 	int goldAmount = 0; 
	int platinumAmount = 0; 
	int baseTime = 0;
	int bonusSmallMiningLaser =0;
	
	int haveGoneMiningOuterRing =0;
	int haveGoneMiningMidRing =0;
	
	int totalCollectedWaterIceAmount=0;
	int  totalCollectedIronAmount=0;
	int probeQuestProgress = 0;

	
	int probabilityFindWaterIceOuterRing =80;
	int probabilityFindIroneOuterRing =60;
	int probabilityFindCopperOuterRing =50;  
	int probabilityFindSilverOuterRing =30;
	int probabilityFindGoldOuterRing =10;
	int probabilityFindPlatinumOuterRing =1;
	int probabilityFindUraniumOuterRing =5;
	
	int amountGetResourcesOuterRing =10;
	
	
	
	int probabilityFindWaterIceMidRing =40;
	int probabilityFindIronMidRing =30;
	int probabilityFindCopperMidRing =50;  
	int probabilityFindSilverMidRing =40;
	int probabilityFindGoldMidRing =20;
	int probabilityFindPlatinumMidRing =5;
	int probabilityFindUraniumMidRing =10;
	
	int amountGetResourcesMidRing =15;
	
	
	int probabilityFindWaterIceInnerRing =20;
	int probabilityFindIronInnerRing =30;
	int probabilityFindCopperInnerRing =60;  
	int probabilityFindSilverInnerRing =50;
	int probabilityFindGoldInnerRing =25;
	int probabilityFindPlatinumInnerRing =10;
	int probabilityFindUraniumInnerRing =20;
	
	int amountGetResourcesInnerRing =15;
	
	boolean isMiningOuterRing =false;
	boolean isMiningMidRing =false;
	boolean isMiningInnerRing =false;

	
	//dependency injection
    public mining_expedition_simulation(
    		timeManager timeManager_instance, 
    		playerStats playerStatsInstance, 
    		ship_stats shipStats_instance, 
    		storyDescriptionsText storyDescriptionsTextInstance, 
    		EventManager eventManagerInstance, 
    		assignAstronauts assignAstronautsInstance,
    		QuestManager QuestManagerInstance,
    		Astronauts AstronautsInstance) {
        this.timeManager_instance = timeManager_instance;
        this.playerStatsInstance = playerStatsInstance;
        this.shipStats_instance = shipStats_instance;
        this.storyDescriptionsTextInstance = storyDescriptionsTextInstance;
        this.eventManagerInstance = eventManagerInstance;
        this.assignAstronautsInstance = assignAstronautsInstance;
        this.QuestManagerInstance = QuestManagerInstance; 
       this.AstronautsInstance = AstronautsInstance;
    }
	 
	
	  
	


	// dependency injection 
	public void go_on_mining_expedition(finances_player playerFinances, ship_stats shipStats) {
		
		int receive_money = 300;
	    
        System.out.println("Went mining");
        playerFinances.increase_finances(receive_money); // Increase finances
        System.out.println("You received " + receive_money);
        
        shipStats.setWentOnMiningExpedition(true); // Set flag on the passed shipStats instance
	}
	
	
	public void setShipFlightMode(ship_stats shipStats)
	{
		 System.out.println("1 normal speed. It will take longer to travel but it is the fasfest");
		 System.out.println("2 fast speed. It will take the shortest time to travel but it is the most dangerous");
		 Scanner scanner = new Scanner(System.in);
		 String choice = scanner.nextLine();

		 switch(choice)
		 {
	        case "1":
	            shipStats.setFlightMode("normal");
	            System.out.println("Flight mode set to normal.");
	            baseTime = 2;
	            break;
	        case "2":
	            shipStats.setFlightMode("speedy");
	            System.out.println("Flight mode set to speedy.");
	            baseTime = 1;
	            break;
	        case "3":
	            baseTime = 15;
	            break;
	        default:
	            System.out.println("Invalid choice. Flight mode remains " + shipStats.getFlightMode() + ".");
	            break;
		 }
		
	}
	
	
	
	public void select_where_go_mining(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance, timeManager timeManager,ship_stats shipStats_instance) throws IOException
	{
		 Scanner scanner = new Scanner(System.in);
		  System.out.println("press 1 to mine outer ring, it will take 5 days. The outer ring is safe, but the inner ring has been moslty mined empty");
		  System.out.println("press 2 to mine mid ring, it will take 10 days. The mid ring is moderately dangerous, but the is moderat profits to be made here");
		  System.out.println("press 3 to mine inner ring, it will take 15 days.. The inner ring is higly dangerous, but the arnings are high");
		  String choice = scanner.nextLine();
		  
		  switch(choice)
		  {
          case "1":
        	  setIsMiningOuterRing(true);
        	    // Ensure astrogator is assigned
//        	    if (assignAstronautsInstance.getAssignedAstrogator() != null) {
//        	        AstronautsInstance = assignAstronautsInstance.getAssignedAstrogator(); // there can be several astronauts but one has the astrogator jobb. This makes sure that the experience is assigned to the astronaut whith the jobb
//        	    } else {
//        	        System.out.println("No astrogator assigned. Cannot proceed with mining expedition.");
//        	        return;
//        	    }
        	  shipStats_instance.checkIfShipHasFusionEngine();
        	  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
            timeManager.advanceTime(5*baseTime*playerStatsInstance.bonusesFromAstrogatorPlayerSkill()*shipStats_instance.getBonusFusionEngine());
            System.out.println("took "+ 5*baseTime*playerStatsInstance.bonusesFromAstrogatorPlayerSkill()*shipStats_instance.getBonusFusionEngine()+" days to mine");
            storyDescriptionsTextInstance.printRandomStationDescription();
            storyDescriptionsTextInstance.chanceToEncounterRadioChatter();
            
//            if (AstronautsInstance != null) {
//                AstronautsInstance.addAstrogatorExperience(25);
//            } else {
//                System.out.println("No astrogator assigned. Cannot add experience.");
//            }
            setIsMiningOuterRing(false);
            

          
              break;
          case "2":
        	  setIsMiningMidRing(true);
        	  shipStats_instance.checkIfShipHasFusionEngine();
      		  go_on_mining_mid_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
              timeManager.advanceTime(10 * playerStatsInstance.bonusesFromAstrogatorPlayerSkill()*shipStats_instance.getBonusFusionEngine());
    		  
    		  playerStatsInstance.increaseEngineeringExperiencePlayer(15);
    		  QuestManagerInstance.findLostSpaceShipQuest(400);
    		  storyDescriptionsTextInstance.printRandomStationDescription();
    		  storyDescriptionsTextInstance.chanceToEncounterRadioChatter();
    		  setIsMiningMidRing(false);


              break;
          case "3":
        	  
        	  setIsMiningInnerRing(true);
        	  go_on_mining_outer_ring(playerFinances, shipStats_instance, shop_instance, timeManager  );
              timeManager.advanceTime(10 * playerStatsInstance.bonusesFromAstrogatorPlayerSkill()*shipStats_instance.getBonusFusionEngine());
    		  
    		  playerStatsInstance.increaseEngineeringExperiencePlayer(30);
    		  storyDescriptionsTextInstance.printRandomStationDescription();
    		  storyDescriptionsTextInstance.chanceToEncounterRadioChatter();
    		  setIsMiningInnerRing(false);
              break;
		  }
	}

	
	public void go_on_mining_outer_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) throws IOException {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 2; // 1% chance for outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	        shipStats_instance.decreaseCrewMorale(5);
	    } else {
	    	// List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	
	        System.out.println("Went mining outer ring");
	       
	        
	        //events that can happen are listed here
	        eventManagerInstance.callAllEvents();

	        
	        playerStatsInstance.increaseGeologistExperiencePlayer(5);
	        playerStatsInstance.increaseEngineeringExperiencePlayer(10);
            playerStatsInstance.increaseAstrogatorExperiencePlayer(50);
	        playerStatsInstance.levelUpGeologistPlayer();
	        shipStats_instance.increaseCrewMorale(1);
	        shipStats_instance.fuel_comsumption(5);
	        
	        
//	        int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
//	        
//	        playerFinances.increase_finances(receive_money); // Increase finances
//	        System.out.println("You received " + receive_money + " credits");
	        
	        chansToGetResources(
	        		probabilityFindWaterIceOuterRing,
	        		probabilityFindIroneOuterRing,
	        		probabilityFindCopperOuterRing,
	        		probabilityFindSilverOuterRing,
	        		probabilityFindGoldOuterRing,
	        		probabilityFindPlatinumOuterRing,
	        		probabilityFindUraniumOuterRing, 
	        		amountGetResourcesOuterRing,
	        		shop_instance);
	        playerFinances.print_finances();
	       
	        countGoneMiningOuterRing();
	        QuestManagerInstance.miningSurveyQuestEasyDifficulty(1000, 1);
     	   
	        //QuestManagerInstance.transportProbeQuest(1000);
	       
	       
	       
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
	        shipStats_instance.decreaseCrewMorale(5);
	    } else {
	    	 List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
	        System.out.println("Went mining mid ring");
	        

	        if(QuestManagerInstance.getAcceptedProbeQuest())
	        {
	        QuestManagerInstance.transportProbeQuest(10000);
	        }
	        
	        
	        //events that can happen are listed here
	        eventManagerInstance.callAllEvents();
	        
	        shipStats_instance.increaseCrewMorale(3);

	        
	        chansToGetResources(
	        		probabilityFindWaterIceMidRing,
	        		probabilityFindIronMidRing,
	        		probabilityFindCopperMidRing,
	        		probabilityFindSilverMidRing,
	        		probabilityFindGoldMidRing,
	        		probabilityFindPlatinumMidRing,
	        		probabilityFindUraniumMidRing,
	        		amountGetResourcesMidRing, 
	        		shop_instance);
	        
	        timeManager_instance.printCurrentDate();
	        playerStatsInstance.increaseGeologistExperiencePlayer(10);
	        
	    }
	    
	    countGoneMiningMidRing();
        QuestManagerInstance.miningSurveyQuestMediumDifficulty(1000);
        setIsMiningMidRing(true);
	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	
	// the inner ring has the most valuable resources to mi
	public void go_on_mining_inner_ring(finances_player playerFinances, ship_stats shipStats, Shop_space_mining_sim shop_instance,  timeManager timeManager_instance ) throws IOException {
		
	    Random random = new Random();
	    int chance = random.nextInt(100); // Generate a number between 0 and 99
	    int pirateChance = 1; // 1% chance for pirate outer ring

	    if (chance <= pirateChance) {
	        System.out.println("You encountered pirates and earned 0 money!");
	        shipStats_instance.decreaseCrewMorale(5);
	    } else {
	    	 List<Astronauts> hiredAstronauts = hireAstronauts.getHiredAstronauts();
	    	 int receive_money = calculateIncome(300, shop_instance.getIncomeMultiplier(), hiredAstronauts);
	    	 
	    	 
		
		        eventManagerInstance.callAllEvents();
		        shipStats_instance.increaseCrewMorale(5); // player gets
		        shipStats_instance.fuel_comsumption(5);
	    	 
	    	 
	        System.out.println("Went mining inner ring");
	        //playerFinances.increase_finances(receive_money); // Increase finances
	        //System.out.println("You received " + receive_money);
	        
	        chansToGetResources(
	        		probabilityFindWaterIceInnerRing,
	        		probabilityFindIronInnerRing,
	        		probabilityFindCopperInnerRing,
	        		probabilityFindSilverInnerRing,
	        		probabilityFindGoldInnerRing,
	        		probabilityFindPlatinumInnerRing,
	        		probabilityFindUraniumInnerRing,
	        		amountGetResourcesInnerRing, 
	        		shop_instance);
	        timeManager_instance.printCurrentDate();
	        playerStatsInstance.increaseGeologistExperiencePlayer(15);
	    }

	    shipStats_instance.setWentOnMiningExpedition(true);
	}
	
	

	
	
	
	public void bonusesFromHiredAstronauts()
	{
		try
		{
			int totalSkillLevel = getTotalSkillLevelFromHiredAstronauts();
			double bonusMultiplier = 1 + (totalSkillLevel / 100.0);
			 System.out.println("total level bonus from astronauts " + bonusMultiplier);
			
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
	
	

	
	
	public void countGoneMiningOuterRing()
	{
		
	//	haveGoneMiningOuterRing = haveGoneMiningOuterRing++;
		
		if(QuestManagerInstance.getAcceptedMiningSurveyQuestEasyDifficulty()==true) {
		haveGoneMiningOuterRing++;
		//return baseTime;
        //System.out.println("DEBUG: Incremented haveGoneMiningOuterRing to " + haveGoneMiningOuterRing);
    } else {
        //System.out.println("DEBUG: Quest not accepted, counter not incremented.");
    }
		
	}
	
	public int countGoneMiningMidRing() {
	    if (QuestManagerInstance.getAcceptedMiningSurveyQuestMediumDifficulty()) {
	        haveGoneMiningMidRing++;
	        System.out.println("DEBUG: Incremented haveGoneMiningMidRing to " + haveGoneMiningMidRing);
	    } else {
	        System.out.println("DEBUG: Medium difficulty quest not accepted, counter not incremented.");
	    }
	    return haveGoneMiningMidRing;
	}

		
		  
	
	
    // Method to calculate income considering the multiplier
    private int calculateIncome(int baseIncome, double multiplier,List<Astronauts> hiredAstronauts) {
    	if (optionsSpaceMiningSimInstance.getOptionsoftwareTestMode()==true) {
    		System.out.println("[TEST MODE] calculateIncome test is being done") ;
    		int finalIncome = (int) (baseIncome + multiplier);
    		
    		// mutant returns 0
    		//int finalIncome =0;
    		
    		//int finalIncome = (int) (baseIncome - multiplier);
    		
    		return finalIncome; 
    	}
    	else {
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
    
    public void chansToGetResources(
    		int chanceToGetWaterIce, 
    		int chanceToGetIron, 
    		int chanceToGetCopper,
    		int chanceToGetSilver, 
    		int chanceToGetGold,
    		int chanceToGetPlatinum,
    		int chanceToGetUranium,
    		int amountGetResources, 
    		Object shop_instance )
    {
    //	int copperAmount = 0; 
    //	int silverAmount = 0;
    //	int goldAmount = 0; 
    	
    	 Random random = new Random();
    	// int chance = random.nextInt(100);
    	 int chanceWaterIce = random.nextInt(100);
    	 int chanceIron = random.nextInt(100);
    	 int chanceCopper = random.nextInt(100);
    	 int chanceSilver = random.nextInt(100);
    	 int chanceGold = random.nextInt(100);
    	 int chancePlatinum = random.nextInt(100);
    	 int chanceUranium = random.nextInt(100);
    	 
    	  Shop_space_mining_sim shop = (Shop_space_mining_sim) shop_instance;
    	  
    	  int randomRollAmountGatherResources =(int) (random.nextInt(amountGetResources));
    	 int resouceRandomCalculationTimes = randomRollAmountGatherResources+ shop.getSmallMiningLaserValue();
    	 
    	 
    	
    	for (int i = 0; i <= resouceRandomCalculationTimes * shipStats_instance.getCrewMoraleBonus(); i++) {
    		
    		 int chance = random.nextInt(100);
    		 
     		if (chance <= chanceToGetWaterIce ) {
    			// copperAmount = copperAmount +1;
    			this.waterIceAmount++;
    			this.totalCollectedWaterIceAmount++; // this is not reset so it can be used for a quest
		    } 
    		
    		if (chance <= chanceToGetIron) {
    			
    			this.ironAmount++;
    			this.totalCollectedIronAmount++;
		    }
    		
    		if (chance <= chanceToGetCopper) {
    			// copperAmount = copperAmount +1;
    			this.copperAmount++;
		    } 
    		
    		if (chance <= chanceToGetSilver) {
    			silverAmount = silverAmount +1;
		    }
    		if (chance <= chanceToGetGold) {
    			goldAmount = goldAmount +1;
		    }
    		if (chance <= chanceToGetGold) {
    			goldAmount = goldAmount +1;
		    }
    		if (chance <= platinumAmount) {
    			platinumAmount = platinumAmount +1;
		    }
    		if (chance <= platinumAmount) {
    			platinumAmount = platinumAmount +1;
		    }

	
    		
    	}
		if (optionsSpaceMiningSimInstance.getOptionsoftwareTestMode()==true) {
			System.out.println("[TEST MODE] Completed resource gathering simulation:");
		}
    	 System.out.println("times gathered resources for each = "+resouceRandomCalculationTimes);
    	 System.out.println(" ");
    	 
    	 
    	 System.out.println("water ice amount = "+waterIceAmount);
		 System.out.println("copper amount = "+copperAmount);
		 System.out.println("silver amount = "+silverAmount);
		 System.out.println("gold amount = "+goldAmount);
		 System.out.println("platinum amount = "+platinumAmount);
		 
		 
		 
	
		 
    	
    	}
    
    
    
    
    public void resetResources() {
    	this.waterIceAmount = 0;
        this.copperAmount = 0;
        this.silverAmount = 0;
        this.goldAmount = 0;
        this.platinumAmount = 0;
        System.out.println("reset resources to 0");
    }
    
    
    public int incrementProbeQuestProgress() {
    	probeQuestProgress++;
    	return probeQuestProgress;
    }
    
    public int getProbeQuestProgress() {
    	return probeQuestProgress;
    }
    
    public void resetProbeQuestProgress() {
    	probeQuestProgress=0;
    }
    
    
    
    public int getWaterIceAmount() {
        return this.waterIceAmount;
    }
    
    public int getTotalCollectedWaterIceAmount() {
        return this.totalCollectedWaterIceAmount;
    }
    
    public int getTotalCollectedIronIceAmount() {
        return this.totalCollectedIronAmount;
    }
    public int getCopperAmount() {
        return this.copperAmount;
    }
    
    public int getSilverAmount() {
        return silverAmount;
    }
    
    public int getGoldAmount() {
        return goldAmount;
    }
    public int getPlatinumAmount() {
        return platinumAmount;
    }
    
    public int getHaveGoneMiningOuterRing() {
        return haveGoneMiningOuterRing;
    }
    
    public int getHaveGoneMiningMidRing() {
        return haveGoneMiningMidRing;
    }
    
    public boolean getIsMiningOuterRing() {
        return isMiningOuterRing;
    }
    
  
    public boolean getIsMiningMidRing() {
        return isMiningMidRing;
    }
    
    public boolean getIsMiningInnerRing() {
        return isMiningInnerRing;
    }
    
	public void setHaveGoneMiningOuterRing(int newHaveGoneMiningOuterRing)
	{
		this.haveGoneMiningOuterRing= newHaveGoneMiningOuterRing;
	}
    
	public void setHaveGoneMiningMidRing(int newHaveGoneMiningMidRing)
	{
		this.haveGoneMiningMidRing= newHaveGoneMiningMidRing;
	}
	
	public void setQuestManager(QuestManager questManagerInstance) {
	    this.QuestManagerInstance = questManagerInstance;
	}
	
	public void setTotalCollectedWaterIceAmount(int newTotalCollectedWaterIceAmount)
	{
		this.totalCollectedWaterIceAmount= newTotalCollectedWaterIceAmount;
	}
	
	public boolean setIsMiningOuterRing(boolean newIsMiningOuterRing)
	{
		return this.isMiningOuterRing= newIsMiningOuterRing;
	}
	
	public boolean setIsMiningMidRing(boolean newIsMiningMidRing)
	{
		return this.isMiningMidRing= newIsMiningMidRing;
	}
	
	public boolean setIsMiningInnerRing(boolean newIsMiningInnerRing)
	{
		return this.isMiningInnerRing= newIsMiningInnerRing;
	}
	
	public void setAssignedAstrogator(Astronauts assignedAstrogator) {
	    this.AstronautsInstance = assignedAstrogator;
	}

	

    }
