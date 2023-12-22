
public abstract class Fighter implements AttackInformation {
	
    private String name;
    private int speed;
    private int basicAttack;
    private int advancedAttack;
    private int specialAttack;
    private String fightType;
    
    // Make constructor for initializing basic value
    public Fighter(String name, int speed, int basicAttack, int advancedAttack, int specialAttack, String fightType) {
        this.name = name;
        this.speed = speed;
        this.basicAttack = basicAttack;
        this.advancedAttack = advancedAttack;
        this.specialAttack = specialAttack;
        this.fightType = fightType;
    }
    
    // Abstract method to define the character's response or dialogue based on the given attack number.
    public abstract String characterLine(int attackNumber);
    
    // Abstract method to define the attack probability based on the given attack number.
    public abstract int attackProbability(int attackNumber);
    
    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBasicAttack() {
        return basicAttack;
    }

    public void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }

    public int getAdvancedAttack() {
        return advancedAttack;
    }

    public void setAdvancedAttack(int advancedAttack) {
        this.advancedAttack = advancedAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getFightType() {
        return fightType;
    }

    public void setFightType(String fightType) {
        this.fightType = fightType;
    }
}

