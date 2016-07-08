package damath.interfaces;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Leibniz H. Berihuete
 * This interface is for any class that inherits from the Character class
 * and with the intention of it becoming a player character.
 */
public interface Player {
	public void addBehaviour(Behavior behavior);
	public void setMoveKeyPressed(KeyCode moveKeyPressed);
	public KeyCode getMoveKeyPressed();

}
