package space_mining_sim;

public class Astronauts {
    private String name;
    private int skillLevel;
    private int salaryRequirement;
	private String occupation;

    public Astronauts(String name, int skillLevel, int salaryRequirement, String occupation) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.salaryRequirement = salaryRequirement;
        this.occupation = occupation;
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
                ", skillLevel=" + skillLevel +
                ", occupation=" + occupation +	
                ", salaryRequirement=" + salaryRequirement +
                '}';
    }
}
