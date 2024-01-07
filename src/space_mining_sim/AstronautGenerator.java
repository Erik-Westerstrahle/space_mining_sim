package space_mining_sim;

import java.util.Random;

public class AstronautGenerator {
    private static final String[] names = {"Alice", "Bob", "Charlie", "Dana", "Eli", "Fiona"};
    private static final Random random = new Random();

    public static Astronauts generateAstronaut() {
        String name = names[random.nextInt(names.length)];
        int skillLevel = 1 + random.nextInt(10); // Skill level between 1 and 10
        int salary = 1000 * skillLevel; // Example salary calculation
        return new Astronauts(name, skillLevel, salary);
    }
}
