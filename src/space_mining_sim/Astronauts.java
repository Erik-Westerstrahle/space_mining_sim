// Astronauts.java

package space_mining_sim;

public class Astronauts {
    private String name;
    private int skillLevel;
    private int salaryRequirement;
	private String occupation;
	private String origin;
	private String personalityAstronaut;
	private String home;
	private String astrologySign;
	private String backgroundAstronaut;
	
	//Astronaut selectedAstronaut = availableAstronauts[choice - 1];

    public Astronauts(String name, int skillLevel, int salaryRequirement, String occupation, String origin, String personalityAstronaut, String astrologySign, String backgroundAstronaut) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.salaryRequirement = salaryRequirement;
        this.occupation = occupation;
        this.origin = origin;
        this.personalityAstronaut = personalityAstronaut;
        this.astrologySign = astrologySign;
        this.backgroundAstronaut = backgroundAstronaut;
    }


    // Getters and Setters
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
    @Override
    public String toString() {
        return "Astronaut{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", personality='" + personalityAstronaut + '\'' +
                ", skillLevel=" + skillLevel +
                ", occupation='" + occupation + '\'' +
                ", salaryRequirement=" + salaryRequirement +
                ", astrologySign='" + astrologySign + '\'' +
                ", background='" + backgroundAstronaut + '\'' +
                '}';
    }
}
