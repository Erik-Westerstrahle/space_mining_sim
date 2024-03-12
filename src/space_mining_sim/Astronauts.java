package space_mining_sim;

public class Astronauts {
    private String name;
    private int skillLevel;
    private int salaryRequirement;
	private String occupation;
	private String origin;
	private String personalityAstronaut;

    public Astronauts(String name, int skillLevel, int salaryRequirement, String occupation, String origin, String personalityAstronaut) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.salaryRequirement = salaryRequirement;
        this.occupation = occupation;
        this.origin = origin;
        this.personalityAstronaut = personalityAstronaut;
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

    @Override
    public String toString() {
        return "Astronaut{" +
                "name='" + name + '\'' +
                "origin= " + origin +
                "Personality= "+
                ", skillLevel=" + skillLevel +
                ", occupation=" + occupation +	
                ", salaryRequirement=" + salaryRequirement +
                '}';
    }
}
