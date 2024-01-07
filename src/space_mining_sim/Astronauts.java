package space_mining_sim;

public class Astronauts {
    private String name;
    private int skillLevel;
    private int salaryRequirement;

    public Astronauts(String name, int skillLevel, int salaryRequirement) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.salaryRequirement = salaryRequirement;
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

    @Override
    public String toString() {
        return "Astronaut{" +
                "name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", salaryRequirement=" + salaryRequirement +
                '}';
    }
}
