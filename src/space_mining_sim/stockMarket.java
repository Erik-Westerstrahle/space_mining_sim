package space_mining_sim;

import java.util.Random;

public class stockMarket {
	private QuestManager QuestManagerInstance;
	private mining_expedition_simulation mining_expedition_simulation_instance;
	private optionsSpaceMiningSim optionsSpaceMiningSimInstance = new optionsSpaceMiningSim();

	
	

	
	
	Random rand = new Random();

	float waterPriceRandom = (1+rand.nextInt(10)/100.0f);
	float copperPriceRandom = (1+rand.nextInt(10)/100.0f);
	float silverPriceRandom = (1+rand.nextInt(10)/100.0f);
	float goldPriceRandom = (1+rand.nextInt(10)/100.0f);
	float platinumPriceRandom = (1+rand.nextInt(10)/100.0f);
	
	
	public float getWaterPriceRandom()
	{
		if (optionsSpaceMiningSimInstance.getOptionStockMarket()) {
			//System.out.println("Debug water stock market");
			return waterPriceRandom;	
			
		}
		else {
		return 1;
		}
	}
	
	
	public float getCopperPriceRandom()
	{
		if (optionsSpaceMiningSimInstance.getOptionStockMarket()) {
			//System.out.println("Debug water stock market");
			return copperPriceRandom;	
			
		}
		else {
		return 1;
		}
	}
	
	public float getSilverPriceRandom()
	{
		if (optionsSpaceMiningSimInstance.getOptionStockMarket()) {
			//System.out.println("Debug water stock market");
			return silverPriceRandom;	
			
		}
		else {
		return 1;
		}
	}
	
	public float getGoldPriceRandom()
	{
		if (optionsSpaceMiningSimInstance.getOptionStockMarket()) {
			//System.out.println("Debug water stock market");
			return goldPriceRandom;	
			
		}
		else {
		return 1;
		}
	}
	public float getPlatinumPriceRandom()
	{
		if (optionsSpaceMiningSimInstance.getOptionStockMarket()) {
			//System.out.println("Debug water stock market");
			return platinumPriceRandom;	
			
		}
		else {
		return 1;
		}
	}
	
	
	public void setWaterPriceRandom(float newWaterPriceRandom)
	{
		this.waterPriceRandom= newWaterPriceRandom;
	}
	
	public void setCopperPriceRandom(float newCopperPriceRandom)
	{
		this.copperPriceRandom= newCopperPriceRandom;
	}
	
	public void setGoldPriceRandom(float newGoldPriceRandom)
	{
		this.platinumPriceRandom= newGoldPriceRandom;
	}
	
	public void setPlatinumPriceRandom(float newPlatinumPriceRandom)
	{
		this.platinumPriceRandom= newPlatinumPriceRandom;
	}
	
	
	
	
}
