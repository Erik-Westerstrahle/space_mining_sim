package space_mining_sim;

import java.util.Random;

public class AstronautGenerator {
	
    private static final String[] names = {
            "Alice", "Bob", "Charlie", "Dana", "Eli", "Fiona",
            "Luna", "Max", "Nova", "Orion", "Kira", "Jasper",
            "Zara", "Phoenix", "Leo", "Stella", "Marcus", "Nina",
            "Quincy", "Rhea", "Soren", "Talia", "Ulysses", "Vera",
            "Winston", "Xena", "Yvonne", "Zane", "Aurora", "Gideon",
            "Helena", "Isaac", "Juno", "Kyra", "Lorenzo", "Mabel",
            "Nolan", "Olivia", "Paxton", "Quinn", "Rosalind", "Silas",
            "Thalia", "Uriel", "Valentina", "Wallace", "Xander", "Yara",
            "Zachary"
        };
        
        private static final String[] lastNames = {
            "Smith", "Piper", "Andersson", "Saari", "Fisher", "Castle",
            "Blackwood", "Sterling", "Vega", "Storm", "Ryder", "Morrow",
            "Blaze", "Winter", "Ray", "Hawke", "Knight", "Ford",
            "Jennings", "Bates", "Cross", "Dixon", "Easton", "Farrow",
            "Graves", "Harper", "Ivory", "Jett", "Knox", "Lawson",
            "Mars", "Noble", "Oakley", "Parrish", "Quill", "Reed",
            "Sage", "Thorne", "Underwood", "Vale", "Wilde", "Xenon",
            "York", "Zephyr"
        };
        
        private static final String[] personalitiesAstroanuts = {
                "Joyful","Wraful","Cautious","Melanchony","Charming","Daydreamer","Resoursful"
            };
        
        private static final String[] homePlace = {
                "Earth","Mars","Luna","Venus","Enceladus station","Mercury","Europa"
            };
        
        private static final String[] starSign = {
                "Aries ","Taurus ","Gemini ","Cancer ","Leo ","Virgo ","Libra ","Scorpio "
            };
    
    
    
    private static final String[] jobsAstronaut = {"Geologist","Astrogator","Mechanic","Miner"};
    private static final Random random = new Random();
 

    public static Astronauts generateAstronaut() {
    	 String firstName = names[random.nextInt(names.length)];
         String lastName = lastNames[random.nextInt(lastNames.length)];
         String fullName = firstName + " " + lastName;  // Concatenate the first name and last name
        
        String occupation = jobsAstronaut[random.nextInt(jobsAstronaut.length)];
        String home = homePlace[random.nextInt(homePlace.length)];
        String personalityAstronaut = personalitiesAstroanuts[random.nextInt(personalitiesAstroanuts.length)];
        String astrologySign = starSign[random.nextInt(starSign.length)];
        int skillLevel = 1 + random.nextInt(10); // Skill level between 1 and 10
        int salary = 1000 * skillLevel; // Example salary calculation
        return new Astronauts(fullName, skillLevel, salary, occupation, home, personalityAstronaut, home,astrologySign);
    }
}
