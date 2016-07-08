package damath.character;

import damath.Game;
import damath.interfaces.Behavior;
import damath.interfaces.Player;
import damath.settings.Controller;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Leibniz H. Berihuete
 * PlayerBehaviour class handles the movement of the player
 * when a key is pressed.
 */
public class PlayerBehavior implements Behavior {
	private Player player;
	private Controller controller;	
	
	/* ******************
	 *    CONSTRUCTOR
	 * ******************/
	public PlayerBehavior(Player player) {
		this.player = player;
		controller = Controller.getInstance();
	}	
	
	
	@Override
	public void play() {
		KeyCode moveRightKey = controller.getMoveRightKey();
		KeyCode moveLeftKey = controller.getMoveLeftKey();
		
		Character playerChar = (Character) player;		
		if(player.getMoveKeyPressed()!= null) {
			
			// IF PLAYER PRESS THE 'MOVE_RIGHT_KEY':
			if(player.getMoveKeyPressed().equals(moveRightKey) && playerChar.getAllowToMove()) {
				playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				playerChar.handleSprite();
			}
			
			// ELSE IF PLAYER PRESS THE 'MOVE_LEFT_KEY':
			else if(player.getMoveKeyPressed().equals(moveLeftKey) && playerChar.getAllowToMove()) {
				playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				playerChar.handleSprite();
			}
		}			
	}
	
}
