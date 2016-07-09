package damath.character;

import damath.Game;
import damath.interfaces.Behavior;
import damath.interfaces.Player;
import damath.settings.Controller;
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

/**
 * 
 * @author Leibniz H. Berihuete
 * PlayerBehaviour class handles the movement of the player
 * when a key is pressed.
 */
public class PlayerBehavior implements Behavior {
	private Player player;
	private Controller controller;	
	private boolean jumping = false;
	private int count = 0;
	
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
		KeyCode jumpKey = controller.getJumpKey();
		
		Character playerChar = (Character) player;		
		if(player.getMoveKeyPressed()!= null) {
			
			// IF PLAYER PRESS THE 'MOVE_RIGHT_KEY':
			if(player.getMoveKeyPressed().equals(moveRightKey) && playerChar.getAllowToMove()) {
				playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				if(playerChar.getAllowToJump())
					playerChar.handleSprite();
			}
			
			// ELSE IF PLAYER PRESS THE 'MOVE_LEFT_KEY':
			else if(player.getMoveKeyPressed().equals(moveLeftKey) && playerChar.getAllowToMove()) {
				playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				if(playerChar.getAllowToJump())
					playerChar.handleSprite();
			}			
		}	
		
		if(player.getJumpKeyPressed()!= null) {
			if(player.getJumpKeyPressed().equals(jumpKey) && playerChar.getAllowToJump()) {
				Character.once = true;
				jumping = true;
			}
		}
		
		if(jumping) {
			playerChar.jumpPosition();
			playerChar.isFalling(false);
			jump(playerChar, 250, 10);
		}
	}
	
	public void jump(Character playerChar, double height, double jumpPower) {
		playerChar.setAllowToJump(false);
		playerChar.setTranslateY(playerChar.getTranslateY() - jumpPower/Game.FPS);
		if(count == height) {
			count = 0;
			jumping = false;
			playerChar.isFalling(true);
		}
		else {
			count++;
		}
	}
	

	
}
