
public class Boxing extends Fighter {
	
	// Make constructor for initializing basic value
    public Boxing(String name) {
        super(name, 1300, 10, 13, 18, "Boxing");

    }

    // Lines for all situation
    // 0 : basicAttack Success
    // 1 : advancedAttack Success
    // 2 : specialAttack Success
    // else : Attack Fail
    @Override
    public String characterLine(int attackNumber) {

        if (attackNumber == 0) {
            return " : How about a jab like lightning?";
        } else if (attackNumber == 1) {
            return " : Does the hook hurt more than you expected?";
        } else if (attackNumber == 2) {
            return " : Ultimate move combo!";
        } else {
            return " : I'll launch another attack soon!";
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
            return 8;
        } else if (attackNumber == 1) {
            return 7;
        } else if (attackNumber == 2) {
            return 5;
        } else {
            return 0;
        }
    }
}