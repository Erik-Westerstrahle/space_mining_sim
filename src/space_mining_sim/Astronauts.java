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
    private int geologistSkill;
    private int astrogatorSkill;
    private int mechanicSkill;
    private int minerSkill;
	
	

    public Astronauts(String name, int skillLevel, int salaryRequirement, String occupation, String origin, String personalityAstronaut, String astrologySign, String backgroundAstronaut, int geologistSkill, int astrogatorSkill, int mechanicSkill, int minerSkill) {
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
    }
    
    public void bonusesFromAstronautsSkills(int skillLevel)
    {
    	
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
    
    public int getGeologistSkill() {
        return geologistSkill;
    }

    public int getAstrogatorSkill() {
        return astrogatorSkill;
    }

    public int getMechanicSkill() {
        return mechanicSkill;
    }

    public int getMinerSkill() {
        return minerSkill;
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
                ", geologistSkill=" + geologistSkill +
                ", astrogatorSkill=" + astrogatorSkill +
                ", mechanicSkill=" + mechanicSkill +
                ", minerSkill=" + minerSkill +
                '}';
    }
    
}
