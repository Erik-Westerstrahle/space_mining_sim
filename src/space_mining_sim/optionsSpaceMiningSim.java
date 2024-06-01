package space_mining_sim;

import java.util.Scanner;


public class optionsSpaceMiningSim {
	
	boolean soundBoolean = true;
	
	
	public void userInput(String input)
	{
	 switch (input) {
	 case "1":
		 setSoundBoolean(false);
		  break;
	 }
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
