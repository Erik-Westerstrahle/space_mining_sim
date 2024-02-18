package space_mining_sim;

public class playerStats {
	
	  ship_stats shipStats_instance = new ship_stats();
	
	int reputationPlayer = 	100;
	
	int levelGeologistSkillPlayer = 0;
	int levelAstrogatorSkillPlayer = 0;
	int levelEngineeringSkillPlayer = 0;
	int levelDiplomacySkillPlayer = 0;
	
	
	int geologistExperiencePlayer = 0;
	int astrogatorExperiencePlayer = 0;
	int engineeringExperiencePlayer = 0;
	int diplomacyExperiencePlayer = 0;
	

	
	
	public void increasePlayersReputation(int amountIncreasePlayerReputation)
	{
		reputationPlayer+=amountIncreasePlayerReputation;
	}
	
	public void increaseGeologistExperiencePlayer (int amountIncreaseGeologistExperiencePlayer )
	{
		geologistExperiencePlayer += amountIncreaseGeologistExperiencePlayer;
		 System.out.println("you gained " + amountIncreaseGeologistExperiencePlayer + " geologist experience");
		 System.out.println("you have " + geologistExperiencePlayer + " geologist experience");
	}
	
	public void increaseEngineeringExperiencePlayer (int amountIncreaseEngineeringExperiencePlayer )
	{
		engineeringExperiencePlayer += amountIncreaseEngineeringExperiencePlayer;
		 System.out.println("you gained " + amountIncreaseEngineeringExperiencePlayer + " Engineering experience");
		 System.out.println("you have " + engineeringExperiencePlayer + " engineering experience");
	}
	
	
	public void increaseAstrogatorExperiencePlayer (int amountIncreaseAstrogatorExperiencePlayer )
	{
		engineeringExperiencePlayer += amountIncreaseAstrogatorExperiencePlayer;
		 System.out.println("you gained " + amountIncreaseAstrogatorExperiencePlayer + " Astrogator experience");
		 System.out.println("you have " + engineeringExperiencePlayer + " Astrogator experience");
	}
	
	

	
	
	public void levelUpGeologistPlayer () {
		 // Check if the player's geologist experience is sufficient for the next level
	    // and if the geologist skill level is still at 0 (not yet leveled up to 1)
		if(geologistExperiencePlayer>=5 &&levelGeologistSkillPlayer==0)
		{
			levelGeologistSkillPlayer +=1;
			 System.out.println("you reached level 1 geologist");
		}
		if(geologistExperiencePlayer>=10 &&levelGeologistSkillPlayer==1)
		{
			levelGeologistSkillPlayer +=1;
			 System.out.println("you reached level 2 geologist");
		}
		if(geologistExperiencePlayer>=15 &&levelGeologistSkillPlayer==2)
		{
			levelGeologistSkillPlayer +=1;
			 System.out.println("you reached level 3 geologist");
		}
		
		
	}
	
	public void levelUpEngineeringPlayer () {
		 // Check if the player's Engineering experience is sufficient for the next level
	    // and if the Engineering skill level is still at 0 (not yet leveled up to 1)
		if(engineeringExperiencePlayer>=5 &&levelEngineeringSkillPlayer==0)
		{
			levelEngineeringSkillPlayer +=1;
			 System.out.println("you reached level 1 Engineering");
		}
		if(geologistExperiencePlayer>=10 &&levelEngineeringSkillPlayer==1)
		{
			levelEngineeringSkillPlayer +=1;
			 System.out.println("you reached level 2 Engineering");
		}
		if(geologistExperiencePlayer>=15 &&levelEngineeringSkillPlayer==2)
		{
			levelEngineeringSkillPlayer +=1;
			 System.out.println("you reached level 3 Engineering");
		}
		
		
	}
	
	public void levelUpAstrogatorPlayer () {
		 // Check if the player's Astrogator experience is sufficient for the next level
	    // and if the Engineering skill level is still at 0 (not yet leveled up to 1)
		if(astrogatorExperiencePlayer>=5 &&levelAstrogatorSkillPlayer==0)
		{
			levelAstrogatorSkillPlayer +=1;
			 System.out.println("you reached level 1 Engineering");
		}
		if(astrogatorExperiencePlayer>=10 &&levelAstrogatorSkillPlayer==1)
		{
			levelAstrogatorSkillPlayer +=1;
			 System.out.println("you reached level 2 Engineering");
		}
		if(astrogatorExperiencePlayer>=15 &&levelAstrogatorSkillPlayer==2)
		{
			levelAstrogatorSkillPlayer +=1;
			 System.out.println("you reached level 3 Engineering");
		}
		
		}
	
//	public void levelUpAstrogatorPlayer () {
//		int[] experienceTresholds = {5,10,15};
//		
//		boolean hasLeveledUp = false;
//		for(int i =0; i<experienceTresholds.length; i++)
//		{
//			if(astrogatorExperiencePlayer >= experienceTresholds[i] && levelAstrogatorSkillPlayer == i)
//			{
//				 levelAstrogatorSkillPlayer += 1; // Increment the player's level
//			}
//			 System.out.println("You reached level " + levelAstrogatorSkillPlayer + " Engineering");
//			 hasLeveledUp = true;
//		}
//	    if (!hasLeveledUp) {
//	      //  System.out.println("Not enough experience to level up or already at max level.");
//	    }
//		
//	}
//	
	

	public double bonusesFromAstrogatorPlayerSkill () {
		double astrogatorBonusFromPlayer = 1.0;
		double[] levelBonuses = {0.0, 0.1, 0.3, 0.6}; // Index 0 is unused, levels start from 1
		
		   int level = getLevelAstrogatorSkillPlayer();
		    if (level > 0 && level < levelBonuses.length) {
		    	astrogatorBonusFromPlayer += levelBonuses[level];
		        System.out.println("bonus from astrogator level ") ;
		    }
		    
		    
		    return (double) astrogatorBonusFromPlayer; 
		
	}
	
	public int getPlayersReputation()
	{
		return reputationPlayer;
	}
	
	
	public int getLevelGeologistSkillPlayer()
	{
		return levelGeologistSkillPlayer;
	}
	
	public int getLevelAstrogatorSkillPlayer()
	{
		return levelAstrogatorSkillPlayer;
	}
	
	public int getLevelEngineeringSkillPlayer()
	{
		return levelEngineeringSkillPlayer;
	}
	
	public int getGeologistExperiencePlayer()
	{
		return geologistExperiencePlayer;
	}
	
	public int getAstrogatorExperiencePlayer()
	{
		return astrogatorExperiencePlayer;
	}
	
	public int getEngineeringExperiencePlayer()
	{
		return engineeringExperiencePlayer;
	}
	
	
    public void setGeologistExperiencePlayer(int newSetGeologistExperiencePlayer) {
    	// TODO Auto-generated method stub
    	this.geologistExperiencePlayer = newSetGeologistExperiencePlayer;
    }
	
	
    public void setLevelAstrogatorSkillPlayer(int newLevelAstrogatorSkillPlayer) {
    	// TODO Auto-generated method stub
    	this.levelAstrogatorSkillPlayer = newLevelAstrogatorSkillPlayer;
    }
    
    public void setLevelGeologistSkillPlayer(int newLevelGeologistSkillPlayer) {
    	// TODO Auto-generated method stub
    	this.levelGeologistSkillPlayer = newLevelGeologistSkillPlayer;
    }
    
    public void setLevelEngineeringSkillPlayer(int newLevelEngineeringSkillPlayer) {
    	// TODO Auto-generated method stub
    	this.levelEngineeringSkillPlayer = newLevelEngineeringSkillPlayer;
    }


}
