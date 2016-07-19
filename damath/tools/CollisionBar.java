package damath.tools;

import damath.interfaces.CollisionObject;
import damath.interfaces.Enemy;
import damath.maps.Map;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import damath.Game;
import damath.character.Character;

/**
 * 
 * @author Leibniz H. Berihuete
 * The CollisionBar is a rectangle, that can push the player to any direction
 */
public final class CollisionBar extends Rectangle implements CollisionObject {
	private int pushDirection;
	private double gravity = Map.DEFAULT_GRAVITY;
	
	/* *****************
	 *   CONSTRUCTOR
	 * *****************/
	public CollisionBar(int pushDirection, double width, double height) {
		super(width, height);
		setPushDirection(pushDirection);		
	}
	
	
	public void setPushDirection(int pushDirection) {
		this.pushDirection = pushDirection;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public int getPushDirection() {
		return pushDirection;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	
	
	
	@Override
	public void buildCollisionWith(Character playerChar) {
		switch(pushDirection) {
		case PUSH_RIGHT:
			playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
			break;
			
		case PUSH_LEFT:
			playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
			break;
			
		case PUSH_UP:
			playerChar.setTranslateY(playerChar.getTranslateY() - gravity/Game.FPS);
			break;
			
		case PUSH_DOWN:
			playerChar.setTranslateY(playerChar.getTranslateY() + playerChar.getJumpPower()/Game.FPS);
			break;
		}
		
	}


	@Override
	public void buildEnemyCollision(ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		
	}



}
