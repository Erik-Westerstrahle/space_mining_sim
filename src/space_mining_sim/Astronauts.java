// Astronauts.java

package space_mining_sim;

import java.io.BufferedWriter;
import java.io.IOException;

public class Astronauts {
	  private int id;
    private String name;
    private int skillLevel;
    private int salaryRequirement;
	private String occupation;
	private String origin;
	private String personalityAstronaut;
	private String home;
	private String astrologySign;
	private String backgroundAstronaut;
    private int geologistSkill;
    private int astrogatorSkill;
    private int mechanicSkill;
    private int minerSkill;
	private timeManager timeManager;
	private int astrogatorExperienceAstronaut; 
	private int geologistExperienceAstronaut; 
	private int mechanistExperienceAstronaut; 
	private int minerExperienceAstronaut;
	private assignAstronauts assignAstronauts; 
	
	

  // constructor used to initializes the Astronauts object
    public Astronauts(int id, String name, int skillLevel, int salaryRequirement, String occupation, String origin, 
            String personalityAstronaut, String astrologySign, String backgroundAstronaut, 
            int geologistSkill, int astrogatorSkill, int mechanicSkill, int minerSkill,timeManager timeManagerInstanceAstonauts,assignAstronauts assignAstronautsInstance) {
this.id = id;
this.name = name;
this.skillLevel = skillLevel;
this.salaryRequirement = salaryRequirement;
this.occupation = occupation;
this.origin = origin;
this.personalityAstronaut = personalityAstronaut;
this.astrologySign = astrologySign;
this.backgroundAstronaut = backgroundAstronaut;
this.geologistSkill = geologistSkill;
this.astrogatorSkill = astrogatorSkill;
this.mechanicSkill = mechanicSkill;
this.minerSkill = minerSkill;
this.timeManager = timeManagerInstanceAstonauts;
this.astrogatorExperienceAstronaut = 0;
this.geologistExperienceAstronaut = 0;
this.mechanistExperienceAstronaut = 0;
this.minerExperienceAstronaut = 0;
this.assignAstronauts=assignAstronautsInstance;
}

    
    public void addAstrogatorExperience (int experience) {
    	this.astrogatorExperienceAstronaut += experience;
//    	if (this.astrogatorExperienceAstronaut >=15) {
//    		this.astrogatorSkill +=1;
//    		this.astrogatorExperienceAstronaut=0; //reset experience
//    	    System.out.println(this.name + " has leveled up their Astrogator Skill! New level: " + this.astrogatorSkill);
//    	}
    	
    	
		if(astrogatorExperienceAstronaut >= 5)
		{
			astrogatorSkill +=1;
			 System.out.println(this.name + " has leveled up their Astrogator Skill! New level: " + this.astrogatorSkill);
	
		}
		if(astrogatorExperienceAstronaut>=10 )
		{
			astrogatorSkill +=1;
			 System.out.println(this.name + " has leveled up their Astrogator Skill! New level: " + this.astrogatorSkill);
		
		}
		if(astrogatorExperienceAstronaut>=15 )
		{
			astrogatorSkill +=1;
			 System.out.println(this.name + " has leveled up their Astrogator Skill! New level: " + this.astrogatorSkill);
		
		}
    }
    
    public void addGeologistExperienceAstronaut (int experience) {
    	this.geologistExperienceAstronaut += experience;
    	 System.out.println("assigned astrogator gained "+experience+" experience");
    	if (this.geologistExperienceAstronaut >=15) {
    		this.geologistSkill +=1;
    		this.geologistExperienceAstronaut=0; //reset experience
    	    System.out.println(this.name + " has leveled up their Astrogator Skill! New level: " + this.geologistSkill);
    	}
    }
    
    public void addMechanistExperience(int experience) {
        this.mechanistExperienceAstronaut += experience;
        if (this.mechanistExperienceAstronaut >= 15) {
            this.mechanicSkill += 1;
            this.mechanistExperienceAstronaut = 0; // Reset experience
            System.out.println(this.name + " has leveled up their Mechanic Skill! New level: " + this.mechanicSkill);
        }
    }

    public void addMinerExperience(int experience) {
        this.minerExperienceAstronaut += experience;
        if (this.minerExperienceAstronaut >= 15) {
            this.minerSkill += 1;
            this.minerExperienceAstronaut = 0; // Reset experience
            System.out.println(this.name + " has leveled up their Miner Skill! New level: " + this.minerSkill);
        }
    }

//	public void levelUpAstrogatorAstronaut () {
//	
//		if(astrogatorExperienceAstronaut>=5 &&astrogatorExperienceAstronaut==0)
//		{
//			astrogatorSkill +=1;
//	
//		}
//		if(astrogatorExperienceAstronaut>=10 &&astrogatorExperienceAstronaut==1)
//		{
//			astrogatorSkill +=1;
//		
//		}
//		if(astrogatorExperienceAstronaut>=15 &&astrogatorExperienceAstronaut==2)
//		{
//			astrogatorSkill +=1;
//		
//		}
//		
//		}
    
    
    public void bonusesFromAstronautsSkills(int skillLevel)
    {
    	
    }
    
    public void salaryAstronauts()
    {
    	if(timeManager.getTimeToPayAstronauts()<=0)
    	{
    		 System.out.println("It's time to pay the astronauts.");
    	}
    	else
    	{
    		 System.out.println("time until astronauts salary needs to be paid is "+timeManager.getTimeToPayAstronauts() );
    	} 
    }
    
    // saves the experience for the astrogator skill in the game save file
    public void saveAstronautAstrogatorExperience(BufferedWriter writer) throws IOException {
    	writer.write(this.id + ","+ this.astrogatorExperienceAstronaut + "\n");
    	 System.out.println(this.id + ","+ this.astrogatorExperienceAstronaut + "saved astrogator ID and experience");
    }

    //loads the astogator
    public void loadAstronautAstrogatorExperience(int astrogatorExperience) {
    	this.astrogatorExperienceAstronaut = astrogatorExperience;
    }

    // Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public int getSalaryRequirement() {
        return salaryRequirement;
    }
    
    public String getOccupation() {
        return occupation;
    }

    public String getPersonalityAstronaut() {
        return personalityAstronaut;
    }
    
    public String getHomePlace() {
        return home;
    } 
    
    public String getastrologySign() {
        return astrologySign;
    } 
    public String backgroundAstronaut() {
        return backgroundAstronaut;
    } 
    
    public int getGeologistSkill() {
        return geologistSkill;
    }

    public int getAstrogatorSkill() {
        return astrogatorSkill;
    }

    public int getMechanicSkill() {
        return mechanicSkill;
    }

    public int getMinerSkillAstronautsClass() {
        return minerSkill;
    }
    
    public int getAstrogatorExperienceAstronaut() {
        return astrogatorExperienceAstronaut;
    }
    
    public int setAstrogatorSkill() {
        return astrogatorSkill;
    }
    
    public void setAstrogatorExperienceAstronaut(int astrogatorExperienceAstronaut) {
        this.astrogatorExperienceAstronaut = astrogatorExperienceAstronaut;
    }
    @Override
    public String toString() {
        return "Astronaut{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", origin='" + origin + '\'' +
               ", personality='" + personalityAstronaut + '\'' +
               ", skillLevel=" + skillLevel +
               ", occupation='" + occupation + '\'' +
               ", salaryRequirement=" + salaryRequirement +
               ", astrologySign='" + astrologySign + '\'' +
               ", background='" + backgroundAstronaut + '\'' +
               ", geologistSkill=" + geologistSkill +
               ", astrogatorSkill=" + astrogatorSkill +
               ", mechanicSkill=" + mechanicSkill +
               ", minerSkill=" + minerSkill +
               '}';
    }




    
}
