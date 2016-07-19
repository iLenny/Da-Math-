package damath.character;

import damath.Game;
import damath.interfaces.Behavior;
import damath.interfaces.Enemy;

public class EnemyBehavior implements Behavior{
	
	private static final int CHANGE_OF_DIRECTION_DELAY = 1000;
	private int delay = CHANGE_OF_DIRECTION_DELAY;
	private int direction = 0;
	private Character enemyChar;
	
	public EnemyBehavior(Enemy enemy) {
		enemyChar = (Character) enemy;
	}
	
	@Override
	public void play() {
		if(delay == 0) {
			direction = new java.util.Random().nextInt(3);
			delay = new java.util.Random().nextInt(3000) + CHANGE_OF_DIRECTION_DELAY;
		}
		delay--;
		goTo(direction);
		
	}
	
	private void goTo(int direction) {
		switch (direction) {
		// RIGHT:
		case 0:
			enemyChar.setTranslateX(enemyChar.getTranslateX()+(enemyChar.getSpeed()/Game.FPS));
			enemyChar.handleSprite();
			enemyChar.setScaleX(enemyChar.getRightScale());
			break;
		
		// LEFT:
		case 1:
			enemyChar.setTranslateX(enemyChar.getTranslateX()-(enemyChar.getSpeed()/Game.FPS));
			enemyChar.handleSprite();
			enemyChar.setScaleX(enemyChar.getLeftScale());
			break;
		
		// STANDING:
		case 2:
			enemyChar.resetPosition();
			
		default:
			break;
		}
	}

}
