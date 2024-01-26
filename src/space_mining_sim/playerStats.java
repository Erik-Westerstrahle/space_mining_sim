package space_mining_sim;

public class playerStats {
	
	int reputationPlayer = 	100;
	
	
	public void increasePlayersReputation(int amountIncreasePlayerReputation)
	{
		reputationPlayer+=amountIncreasePlayerReputation;
	}
	
	
	
	
	public int getPlayersReputation()
	{
		return reputationPlayer;
	}

}
