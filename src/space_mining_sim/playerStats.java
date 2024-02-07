package space_mining_sim;

public class playerStats {
	
	  ship_stats shipStats_instance = new ship_stats();
	
	int reputationPlayer = 	100;
	
	int levelGeologistSkillPlayer = 0;
	int levelAstrogatorSkillPlayer = 0;
	int levelEngineeringSkillPlayer = 0;
	
	
	int geologistExperiencePlayer = 0;
	int astrogatorExperiencePlayer = 0;
	int engineeringExperiencePlayer = 0;
	
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
