package damath.settings;

import damath.character.Character;
import damath.interfaces.Player;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Leibniz H. Berihuete
 * Controller class.
 * This class is a singleton;
 * The purpose of this class is to have access to keyboard controls and 
 * to be able to change controls at any time in case the user wishes to change key preference.
 * One must call the linkControlsWith() method and pass a Player argument in order to link the 
 * controls with the player. 
 */
public final class Controller {
	// Default Keys:
	public static final KeyCode MOVE_RIGHT_KEY = KeyCode.RIGHT;
	public static final KeyCode MOVE_LEFT_KEY = KeyCode.LEFT;
	public static final KeyCode JUMP_KEY = KeyCode.UP;
	public static final KeyCode ATTACK_KEY = KeyCode.SPACE;
	
	private static Controller controller;
	
	private KeyCode moveRightKey;
	private KeyCode moveLeftKey;
	private KeyCode jumpKey;
	private KeyCode attackKey;
	
	/* **********************
	 *   Private Constructor
	 * **********************/
	private Controller() {
		// Initialize Control keys:
		setMoveRightKey(MOVE_RIGHT_KEY);
		setMoveLeftKey(MOVE_LEFT_KEY);
		setJumpKey(JUMP_KEY);
		setAttackKey(ATTACK_KEY);		
	}
	
	
	/* *****************
	 *     MUTATORS
	 * *****************/	
	public void setMoveRightKey(KeyCode moveRightKey) {
		this.moveRightKey = moveRightKey; 
	}
	
	public void setMoveLeftKey(KeyCode moveLeftKey) {
		this.moveLeftKey = moveLeftKey;
	}
	
	public void setJumpKey(KeyCode jumpKey) {
		this.jumpKey = jumpKey;
	}
	
	public void setAttackKey(KeyCode attackKey) {
		this.attackKey = attackKey;
	}
	
	/* *******************
	 *     ACCESSORS
	 * *******************/
	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public KeyCode getMoveRightKey() {
		return moveRightKey;
	}
	
	public KeyCode getMoveLeftKey() {
		return moveLeftKey;
	}
	
	public KeyCode getJumpKey() {
		return jumpKey;
	}
	
	public KeyCode getAttackKey() {
		return attackKey;
	}
	
	
	
	/* ************************ 
	       LINK CONTROLS
	 * ************************/
	public void linkControlsWith(Player player) {
		final Character playerChar = (Character) player;
		final Controller controller = Controller.getInstance();
		
		// GET Current Controls:
		final KeyCode MOVE_RIGHT = controller.getMoveRightKey();
		final KeyCode MOVE_LEFT = controller.getMoveLeftKey();
		final KeyCode JUMP = controller.getJumpKey();
		//final KeyCode ATTACK = controller.getAttackKey();
		
		playerChar.setOnKeyPressed(e->{
			// MOVE_RIGHT_KEY
			if(e.getCode().equals(MOVE_RIGHT)) {
				player.setMoveKeyPressed(MOVE_RIGHT);
				playerChar.setScaleX(playerChar.getRightScale());
			}
			
			// MOVE_LEFT_KEY
			else if(e.getCode().equals(MOVE_LEFT)) {
				player.setMoveKeyPressed(MOVE_LEFT);
				playerChar.setScaleX(playerChar.getLeftScale());
			}
			
			if(e.getCode().equals(JUMP) && playerChar.getAllowToJump()) {
				player.setJumpKeyPressed(JUMP);
			}
		});
		
		playerChar.setOnKeyReleased(e->{
			// MOVE_RIGHT_KEY
			if(e.getCode().equals(MOVE_RIGHT)) {
				player.setMoveKeyPressed(null);
				playerChar.resetPosition();
			}
			
			// MOVE_LEFT_KEY
			else if(e.getCode().equals(MOVE_LEFT)) {
				player.setMoveKeyPressed(null);
				playerChar.resetPosition();
			}
			
			if(e.getCode().equals(JUMP)) {
				player.setJumpKeyPressed(null);
			}
		});
	}
}
