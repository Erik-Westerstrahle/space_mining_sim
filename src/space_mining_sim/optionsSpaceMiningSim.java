package space_mining_sim;

import java.util.Scanner;


public class optionsSpaceMiningSim {
	
	boolean soundBoolean = false;
	
	
	public void userInputOptions(String input)
	{
		// System.out.print("input your options");
	 switch (input) {
	 case "1":
		 setSoundBoolean(true);
		 System.out.print("audio enabled");
		  break;
	 case "0":
		 setSoundBoolean(false);
		 System.out.print("audio disabled");
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
		 System.out.println("Current audio status: " + soundBoolean);
	}
	
	
	
	public boolean getSoundBoolean()
	{
		return soundBoolean;
	}
	
    public void setSoundBoolean(boolean newSoundBoolean) {
    	// TODO Auto-generated method stub
    	this.soundBoolean = newSoundBoolean;
    }

}
