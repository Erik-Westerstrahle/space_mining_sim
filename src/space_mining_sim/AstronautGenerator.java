// AstronautGenerator.java


package space_mining_sim;

import java.util.Random;


// Here Generates astronauts
public class AstronautGenerator {
	
	// array of firt names used for the astronauts
    private static final String[] names = {
            "Alice", "Bob", "Charlie", "Dana", "Eli", "Fiona",
            "Luna", "Max", "Nova", "Orion", "Kira", "Jasper",
            "Zara", "Phoenix", "Leo", "Stella", "Marcus", "Nina",
            "Quincy", "Rhea", "Soren", "Talia", "Ulysses", "Vera",
            "Winston", "Xena", "Yvonne", "Zane", "Aurora", "Gideon",
            "Helena", "Isaac", "Juno", "Kyra", "Lorenzo", "Mabel",
            "Nolan", "Olivia", "Paxton", "Quinn", "Rosalind", "Silas",
            "Thalia", "Uriel", "Valentina", "Wallace", "Xander", "Yara",
            "Zachary","Lisa"
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
                "Joyful","Wratful","Cautious","Melanchony","Charming","Daydreamer","Resoursful"
            };
        
        private static final String[] homePlace = {
                "Earth","Mars","Luna","Venus","Enceladus station","Mercury","Europa"
            };
        
        private static final String[] starSign = {
                "Aries ","Taurus ","Gemini ","Cancer ","Leo ","Virgo ","Libra ","Scorpio "
            };
        
        private static final String[] backgroundAstronautArray = {
                "Miner ","Navy ","Military ","Trader ","Professor ","Scientist ","Artist ","Criminal ","CENSORED ","Pilot","Warehouse manager","Smuggler","Dockhand"," Teacher","Programmer","Farmer", "Hydroponics worker"
            };
        
        private static int generateJobSkillLevel() {
            return 1 + random.nextInt(10);
        }
    
    
    
    private static final String[] jobsAstronaut = {"Geologist","Astrogator","Mechanic","Miner"};
    private static final Random random = new Random();
 
// here the astronauts are generated when the game is run
    // the randomly generated astronauts are saved to astronauts.txt
    public static Astronauts generateAstronaut() {
    	 String firstName = names[random.nextInt(names.length)]; // randomly assigns a first name to a asteonaut
         String lastName = lastNames[random.nextInt(lastNames.length)];
         String fullName = firstName + " " + lastName;  // Concatenate the first name and last name
        
        String occupation = jobsAstronaut[random.nextInt(jobsAstronaut.length)]; //
        String home = homePlace[random.nextInt(homePlace.length)];
        String personalityAstronaut = personalitiesAstroanuts[random.nextInt(personalitiesAstroanuts.length)];
        String astrologySign = starSign[random.nextInt(starSign.length)];
        String backgroundAstronaut = backgroundAstronautArray[random.nextInt(backgroundAstronautArray.length)];
        int skillLevel = 1 + random.nextInt(10); // Skill level between 1 and 10 // this is a placeholder until more detailed job skill levels can be added
        int salary = 1000 * skillLevel; // Example salary calculation
        
        
        int geologistSkill = generateJobSkillLevel();
        int astrogatorSkill = generateJobSkillLevel();
        int mechanicSkill = generateJobSkillLevel();
        int minerSkill = generateJobSkillLevel();

        
       // return new Astronauts(fullName, skillLevel, salary, occupation, home, personalityAstronaut, home,astrologySign,backgroundAstronaut);
        return new Astronauts(fullName, skillLevel, salary, occupation, home, personalityAstronaut, astrologySign, backgroundAstronaut, geologistSkill, astrogatorSkill, mechanicSkill, minerSkill);

    }
}
