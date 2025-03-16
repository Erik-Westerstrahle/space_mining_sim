package space_mining_sim;

import java.util.Scanner;


public class optionsSpaceMiningSim {
	
	boolean soundBoolean = false;
	 boolean startupLoadingBarIsActive = true;
		boolean optionStockMarket =true;
	
	
	public void userInputOptions(String input)
	{
		// System.out.print("input your options");
	 switch (input) {
	 case "1":
		 setSoundBoolean(true);
		 System.out.print("audio enabled");
		  break;
	 case "0":
		 // audio is by default off
		 setSoundBoolean(false);
		 System.out.print("audio disabled");
		  break;
	 case "2":
		 setStartupLoadingBarIsActive(true);
		 System.out.print("start loading bar enabled");
		  break;
		  
	 case "3":
		 // audio is by default off
		 setStartupLoadingBarIsActive(false);
		 System.out.print("start loading bar  disabled");
		  break;
		  
	 case "4":
		 
		 setOptionStockMarket(true);
		 System.out.print("Enabled stock market");
		  break;	  
	 case "5":
		 
		 setOptionStockMarket(false);
		 System.out.print("Disabled stock market");
		  break;
     default:
         System.out.println("Invalid option.");
         break;
	 }
	}
	
	
	
	public void printOptions()
	{
		 System.out.println(soundBoolean);
		 System.out.println("input 1 to turn on audio");
		 System.out.println("input 0 to turn off audio");
		 System.out.println("input 2 to turn on start loading bar");
		 System.out.println("input 3 to turn off start loading bar");
		 System.out.println("input 4 to turn on stock market (random selling prices on resources");
		 System.out.println("input 5 to turn off stock market (random selling prices on resources");
		 System.out.println("Current audio status: " + soundBoolean);
		 System.out.println("Current start loading bar status: " + startupLoadingBarIsActive);
	}
	
	
	
	public boolean getSoundBoolean()
	{
		return soundBoolean;
	}
	
    public  boolean getStartupLoadingBarIsActive()
    {
    	return startupLoadingBarIsActive;
    }
    
	public boolean getOptionStockMarket()
	{
		return optionStockMarket;
	}
	
    public void setSoundBoolean(boolean newSoundBoolean) {
    	// TODO Auto-generated method stub
    	this.soundBoolean = newSoundBoolean;
    }
    
    public void setStartupLoadingBarIsActive(boolean newStartupLoadingBarIsActive) {
    
    	this.startupLoadingBarIsActive = newStartupLoadingBarIsActive;
    }
    
    public void setOptionStockMarket(boolean newOptionStockMarket) {
    	// TODO Auto-generated method stub
    	this.optionStockMarket = newOptionStockMarket;
    }
    


}
