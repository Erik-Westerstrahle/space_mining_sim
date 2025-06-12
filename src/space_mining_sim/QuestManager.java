package space_mining_sim;

import java.util.Random;
import java.util.Scanner;

public class QuestManager {
	
   
	
    private finances_player playerFinances;
    private Shop_space_mining_sim shop_instance;
    private ship_stats shipStats_instance;
    private playerStats playerStatsInstance;
    private timeManager timeManager_instance;
    private storyDescriptionsText storyDescriptionsTextInstance;
    private mining_expedition_simulation miningExpedition;
    private Astronauts Astronauts_instance;
    
   
    private static final int probe_quest_treshold =1;
    
    public QuestManager(finances_player playerFinances, 
    		Shop_space_mining_sim shop_instance, 
    		ship_stats shipStats_instance, 
    		playerStats playerStatsInstance, 
    		timeManager timeManager_instance, 
    		storyDescriptionsText storyDescriptionsTextInstance, 
    		mining_expedition_simulation miningExpedition,
    		Astronauts Astronauts_instance) {
    	
        this.playerFinances = playerFinances;
        this.shop_instance = shop_instance;
        this.shipStats_instance = shipStats_instance;
        this.playerStatsInstance = playerStatsInstance;
        this.timeManager_instance = timeManager_instance;
        this.storyDescriptionsTextInstance = storyDescriptionsTextInstance;
        this.miningExpedition = miningExpedition;
        this.Astronauts_instance = Astronauts_instance;
    }

    
    boolean acceptedminingSurveyQuestEasyDifficulty=false;
    boolean acceptedminingSurveyQuestMediumDifficulty=false;
    boolean acceptedminingSurveyQuestHardDifficulty=false;
    boolean acceptedFindingLostSpaceShipQuest=false;
    
    boolean acceptedCollectIceQuesty=false;
    boolean acceptedProbeQuest=false;
    boolean acceptedProbeInnerRingQuest=false;
    boolean acceptedEldritchHorrorQuest=false;
    boolean encounteredEldritchHorror=false;
    
   

	public void miningSurveyQuestEasyDifficulty(int questMoneyReward, int amountToCompleteQuest) {
		//int questReward = 1000;
		 int timesGoneOnMiningExpeditionOuterRing=0;
	
	//	 System.out.println("DEBUG: Checking quest completion quest 1: haveGoneMiningOuterRing=" + miningExpedition.getHaveGoneMiningOuterRing() + ", amountToCompleteQuest=" + amountToCompleteQuest);
		if(acceptedminingSurveyQuestEasyDifficulty && miningExpedition.getHaveGoneMiningOuterRing()==amountToCompleteQuest) {
			playerFinances.increase_finances(questMoneyReward);
			
			 System.out.println("easy mining survey completed. you gained  = "+questMoneyReward);
		}
	
		// int chance = random.nextInt(100)+1;
		 
		
		 
}
	
	
	public void miningSurveyQuestMediumDifficulty(int questMoney) {
	//    System.out.println("DEBUG: Checking quest completion for medium difficulty: haveGoneMiningMidRing=" + miningExpedition.getHaveGoneMiningMidRing() + ", required=1");

	    if (miningExpedition.getHaveGoneMiningMidRing() >= 1) {
	        playerFinances.increase_finances(questMoney);
	        miningExpedition.setHaveGoneMiningMidRing(0); // Reset the counter after completion
	        setAcceptedMiningSurveyQuestMediumDifficulty(false); // Mark the quest as completed
	        System.out.println("Medium mining survey completed. You gained " + questMoney);
	    } else {
	        //System.out.println("DEBUG: Medium mining survey not yet completed.");
	    }
	}
	
	public void transportProbeQuest(int questMoney) {
	
		
		if(!getAcceptedProbeQuest()) {
			return;
		}
		miningExpedition.incrementProbeQuestProgress();
		
		if(miningExpedition.incrementProbeQuestProgress()>=probe_quest_treshold) {
	        playerFinances.increase_finances(questMoney);
	        miningExpedition.resetProbeQuestProgress();
	        System.out.println("PROBE QUEST completed. Received " + questMoney);			
		}
	}
	
	
	public void transportProbeInnerRingQuest(int questMoney) {
	
		
		if(!getAcceptedProbeInnerRingQuest()) {
			return;
		}
		miningExpedition.incrementProbeQuestProgress();
		
		if(miningExpedition.incrementProbeQuestProgress()>=probe_quest_treshold) {
	        playerFinances.increase_finances(questMoney);
	        miningExpedition.resetProbeQuestProgress();
	        System.out.println("PROBE QUEST INNER Ring completed. Received " + questMoney);			
		}
	}
	


	
	
	public void collectIceQuest(int questMoney) {
		
	
		if(acceptedCollectIceQuesty==true) {
		if(miningExpedition.getTotalCollectedWaterIceAmount()>=1) {
			playerFinances.increase_finances(questMoney);
			
			 System.out.println("ice collect quest completed. you gained  = "+questMoney);
		}
		}
		else
		{
			
		}
		
		// int chance = random.nextInt(100)+1;
		 
		
		 
}
	
	public void findLostSpaceShipQuest(int questMoney) {
		
		if(acceptedFindingLostSpaceShipQuest==true) {
		if(miningExpedition.isMiningMidRing==true) {
			 Random random = new Random();
			 int roll = random.nextInt(100) + 1;
			 
			 if(roll<10)
			 {
				 
					playerFinances.increase_finances(questMoney); 
					//setAcceptedFindingLostSpaceShipQuest(false);
					 System.out.println("found lost space ship. Reward: = "+questMoney);
			 }
			
		}
		else
		{
			
		}
		}
			
		 
}
	
	public void findEldritchHorrorQuest(int questReward) {
		
		if (Astronauts_instance==null) {
			 System.out.println("you have no Astrogator assigned you cannot do the eldritch horror quest");
			 return;
		}
		else {
		 Random random = new Random();
		 int rollEncounterEldritchHorror = random.nextInt(100) + 1;
		 
		 if(acceptedEldritchHorrorQuest==true && Astronauts_instance.getAstrogatorSkill()>=10) {
			 
		 if(rollEncounterEldritchHorror<=1) {
			 //encounteredEldritchHorror = true;
			 playerFinances.increase_finances(questReward); 
			 shipStats_instance.decreaseCrewMorale(10);
			 System.out.println("you found the eldritch horror. You wish you had not. you gained "+questReward);
			 acceptedEldritchHorrorQuest = false;
			 
		 }
		 
		 }
		
		return;
		}
	}
	
	
	public void resetGoneMiningOuterRingCount()
	{
		
		miningExpedition.setHaveGoneMiningOuterRing(0);
	
	}
	

	public void availableQuests()
	{
		if(acceptedminingSurveyQuestEasyDifficulty==false)
		{
			 System.out.println("1 mining survey quest easy difficulty available ");
		}
		
		if(acceptedminingSurveyQuestMediumDifficulty==false)
		{
			 System.out.println("2 mining survey quest medium difficulty available ");
		}
		
		if(acceptedCollectIceQuesty==false)
		{
			 System.out.println("3 collect ice quest available ");
		}
		
		if(acceptedCollectIceQuesty==false)
		{
			 System.out.println("4 find lost spaceship quest");
		}
		if(acceptedProbeQuest==false)
		{
			 System.out.println("5 probe quest");
		}
		if(acceptedEldritchHorrorQuest==false)
		{
			 System.out.println("6 eldritch horror quest");
		}
		
		
	}
	
	public void chooseQuest(Scanner scanner)
	{
		//Scanner scanner = new Scanner(System.in);
		 System.out.println("choose available quest ");
		 String input = scanner.nextLine();
		switch (input) {
	     case "1":
	    	 setAcceptedMiningSurveyQuestEasyDifficulty(true);
	    	 
	    	 miningExpedition.setHaveGoneMiningOuterRing(0); // resets the count so that the count is proper for the quest
	    	 System.out.println("1 Mining survey quest easy difficulty accepted.");

	    break;
	    
	     case "2":
	    	 setAcceptedMiningSurveyQuestMediumDifficulty(true);
	    	 
	    	 miningExpedition.setHaveGoneMiningMidRing(0); // resets the count so that the count is proper for the quest
	    	 System.out.println("2 Mining survey quest medium accepted.");
	    	 System.out.println("acceptedminingSurveyQuestMediumDifficulty = "+ acceptedminingSurveyQuestMediumDifficulty);
	    	 
	    
	    break;
	    
	     case "3":
	    	 setAcceptedCollectIceQuesty(true);
	    	 
	    	 miningExpedition.setTotalCollectedWaterIceAmount(0); // resets the count so that the count is proper for the quest
	    	 System.out.println("3 ice collected quest medium accepted.");
	    
	    break;
	    
	     case "4":
	    	 setAcceptedFindingLostSpaceShipQuest(true);
	    	 
	    	
	    	 System.out.println("accpeted find lost spaceship quest");
	    
	    break;
	    
	     case "5":
	    	 setAcceptedProbeQuest(true);
	    	 
	    	 miningExpedition.resetProbeQuestProgress();
	    	 System.out.println("Probequest bool = "+ acceptedProbeQuest);
	    
	    break;
	    
	     case "6":
	    	 setAcceptedEldritchHorrorQuest(true);
	    	 System.out.println("you accepted the eldritch horror quest");
	    	 
	    break;
	    
	     default:
	            System.out.println("Invalid command.");
		}
		
	}
	
	public boolean getAcceptedMiningSurveyQuestEasyDifficulty()
	{
		return acceptedminingSurveyQuestEasyDifficulty;
	}
	
	public boolean getAcceptedMiningSurveyQuestMediumDifficulty()
	{
		return acceptedminingSurveyQuestMediumDifficulty;
	}
	
	public boolean getAcceptedCollectIceQuesty()
	{
		return acceptedCollectIceQuesty;
	}
	
	public boolean getAcceptedFindingLostSpaceShipQuest()
	{
		return acceptedFindingLostSpaceShipQuest;
	}
	
	public boolean getAcceptedProbeQuest()
	{
		return acceptedProbeQuest;
	}
	
	public boolean getEldritchHorrorQuest()
	{
		return acceptedEldritchHorrorQuest;
	}
	
	
	
	public boolean getAcceptedProbeInnerRingQuest()
	{
		return acceptedProbeInnerRingQuest;
	}	
	
	
	public void setAcceptedMiningSurveyQuestEasyDifficulty(boolean newAcceptedminingSurveyQuestEasyDifficulty)
	{
		this.acceptedminingSurveyQuestEasyDifficulty= newAcceptedminingSurveyQuestEasyDifficulty;
	}
	
	public void setAcceptedMiningSurveyQuestMediumDifficulty(boolean newAcceptedminingSurveyQuestMediumDifficulty)
	{
		this.acceptedminingSurveyQuestMediumDifficulty= newAcceptedminingSurveyQuestMediumDifficulty;
	}
	
	public void setAcceptedCollectIceQuesty(boolean newAcceptedCollectIceQuesty)
	{
		this.acceptedCollectIceQuesty= newAcceptedCollectIceQuesty;
	}
	
	public void setAcceptedFindingLostSpaceShipQuest(boolean newAcceptedFindingLostSpaceShipQuest)
	{
		this.acceptedFindingLostSpaceShipQuest= newAcceptedFindingLostSpaceShipQuest;
	}
	
	public void setAcceptedProbeQuest(boolean newAcceptedProbeQuest)
	{
		this.acceptedProbeQuest= newAcceptedProbeQuest;
	}
	
	public void setAcceptedProbeInnerRingQuest(boolean newAcceptedProbeInnerRingQuest)
	{
		this.acceptedProbeInnerRingQuest= newAcceptedProbeInnerRingQuest;
	}
	
	
	public void setAcceptedEldritchHorrorQuest(boolean newAcceptedEldritchHorrorQuest)
	{
		this.acceptedEldritchHorrorQuest= newAcceptedEldritchHorrorQuest;
	}
}
