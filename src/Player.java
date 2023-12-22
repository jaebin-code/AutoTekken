
// The Player class represents a player in the game, holding a character of type T that extends Fighter.
public class Player<T extends Fighter> {
    private T playerCharacter;

    // Constructs a Player with the specified character.
    public Player(T playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    // Getter and Setter 
    public T getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(T playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}