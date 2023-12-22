
public class Sumo extends Fighter {
	
	// Make constructor for initializing basic value
    public Sumo(String name) {
        super(name, 2000, 18, 23, 34, "Sumo");
    }

    // Lines for all situation
    // 0 : basicAttack Success
    // 1 : advancedAttack Success
    // 2 : specialAttack Success
    // else : Attack Fail
    @Override
    public String characterLine(int attackNumber) {

        if (attackNumber == 0) {
            return " : What a slap!";
        } else if (attackNumber == 1) {
            return " : Belly attack incoming!";
        } else if (attackNumber == 2) {
            return " : Ground-pound attack!";
        } else {
            return " : Oops... Be careful next time!!";
        }
    }
    
    // probabilities for all situation
    // 0 : basicAttack
    // 1 : advancedAttack
    // 2 : specialAttack
    // else : Attack Fail
    @Override
    public int attackProbability(int attackNumber) {
        if (attackNumber == 0) {
            return 6;
        } else if (attackNumber == 1) {
            return 4;
        } else if (attackNumber == 2) {
            return 3;
        } else {
            return 0;
        }
    }
}

