package space_mining_sim;

public class playerStats {
	
	  ship_stats shipStats_instance = new ship_stats();
	
	int reputationPlayer = 	100;
	
	int geologistSkillPlayer = 0;
	int astrogatorSkillPlayer = 0;
	int engineeringSkillPlayer = 0;
	
	
	int geologistExperiencePlayer = 0;
	int astrogatorExperiencePlayer = 0;
	int engineeringExperiencePlayer = 0;
	
	public void increasePlayersReputation(int amountIncreasePlayerReputation)
	{
		reputationPlayer+=amountIncreasePlayerReputation;
	}
	
	public void increaseGeologistExperiencePlayer (int amountIncreaseGeologistExperiencePlayer )
	{
		astrogatorExperiencePlayer += amountIncreaseGeologistExperiencePlayer;
		 System.out.println("you gained " + amountIncreaseGeologistExperiencePlayer + " geologist experience");
	}
	
	
	
	public int getPlayersReputation()
	{
		return reputationPlayer;
	}

}
