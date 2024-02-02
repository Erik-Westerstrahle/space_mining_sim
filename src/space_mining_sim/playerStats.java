package space_mining_sim;

public class playerStats {
	
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
	
	public void increaseGeologistExperiencePlayer ()
	{
		
	}
	
	
	
	public int getPlayersReputation()
	{
		return reputationPlayer;
	}

}
