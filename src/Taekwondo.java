
public class Taekwondo extends Fighter {

	// Make constructor for initializing basic value
    public Taekwondo(String name) {
        super(name, 1500, 10, 15, 20, "Taekwondo");
    }

    // Lines for all situation
    // 0 : basicAttack Success
    // 1 : advancedAttack Success
    // 2 : specialAttack Success
    // else : Attack Fail
    @Override
    public String characterLine(int attackNumber) {

        if (attackNumber == 0) {
            return " : A taekwon punch success!";
        } else if (attackNumber == 1) {
            return " : My kick is the best, you know!";
        } else if (attackNumber == 2) {
            return " : Whirlwind spinning kick!";
        } else {
            return " : Taekwondo doesn't get tired!";
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
            return 7;
        } else if (attackNumber == 1) {
            return 6;
        } else if (attackNumber == 2) {
            return 4;
        } else {
            return 0;
        }
    }
}
