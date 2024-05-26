package space_mining_sim.character;

public class characters {
    //0 to 10000 range to represent 0.00-100.00 without needing to use floats
    private int hunger0_to_10000;
    private int home;
    private int health0_to_10000;
    private String name;
    private String firstname;
    private String lastname;

    public characters(String character_first_name, String character_second_name) {
        hunger0_to_10000 = 10000;  // Set the initial value for the class attribute x
        health0_to_10000 = 10000;  
        hunger0_to_10000 = 10000;  
        firstname=character_first_name;
        lastname=character_second_name;
        name=character_first_name+character_second_name;
        home=0;
      }

    public String getname(){
        return name;
    }
    public String getfirstname(){
        return firstname;
    }
    public String getlastname(){
        return lastname;
    }
    public int gethungerlevel(){
        return hunger0_to_10000;
    }
    public int gethealthlevel(){
        return health0_to_10000;
    }
}
