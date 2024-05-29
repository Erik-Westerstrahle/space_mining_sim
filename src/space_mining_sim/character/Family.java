package space_mining_sim.character;

public class Family {
    int[][] relation;
    public Family() {
        characters Partner=new characters("Edvina", "Smith");
        characters child1=new characters("Ed", "Smith");
        characters child2=new characters("Eddy", "Smith");
        int numberOfFamilyMembersIncludingMain=4;
        relation= new int[numberOfFamilyMembersIncludingMain][numberOfFamilyMembersIncludingMain];
        for (int i = 0; i < relation.length; i++){         // iterates each character
            for (int j = 0; j < relation[i].length; j++){  // iterates each character_relation
                if (i!=j) {
                    relation[i][j]=10000;
                }
                else{
                    relation[i][j]=-10000;
                }
            }
        }
      }
}
