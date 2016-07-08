package damath.character;

import damath.interfaces.Behavior;
import damath.interfaces.Player;
import damath.settings.Controller;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import damath.Game;
import damath.character.Character;
import damath.character.PlayerBehavior;

/**
 * 
 * @author Leibniz H. Berihuete
 * This class was created to test the Character class
 */
public class Zipangu extends Character implements Player{
	private static final Image zipanguImg = 
			new Image(Zipangu.class.getResourceAsStream("../images/zipangu.png"));
	private static final double SPRITE_WIDTH = 49;
	private static final double SPRITE_HEIGHT = 73;
	
	
	private final Rectangle2D [] frames = {
			new Rectangle2D(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
			new Rectangle2D(74, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
			new Rectangle2D(145, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
			new Rectangle2D(203, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
			new Rectangle2D(265, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
	};
	
	private int frameCount = 0;
	private final int TIME_COUNT = (int)(1000/(getSpeed()*1.2));
	private int time = TIME_COUNT;
	
	private KeyCode moveKeyPressed;
	private Behavior behavior;
	/* *****************
	 *    CONSTRUCTOR
	 * *****************/
	public Zipangu () {
		rightScale = -1;
		leftScale = 1;
		setImage(zipanguImg);
		characterView.setViewport(frames[0]);
		PlayerBehavior pb = new PlayerBehavior(this);
		addBehaviour(pb);
	}
	
	
	@Override
	public void addBehaviour(Behavior behavior) {
		this.behavior = behavior;
	}

	@Override
	public void handleSprite() {
		if(time == 0) {
			// Keep track of the frameCount:
			if(frameCount < frames.length-1) {
				frameCount++;
			}
			else {
				frameCount = 0;
			}
			
			// ChangeSprite:
			this.characterView.setViewport(frames[frameCount]);
			time = TIME_COUNT;
		}
		else {
			time--;
		}		
	}
	
	@Override
	public void resetPosition() {
		this.characterView.setViewport(frames[0]);		
	}

	@Override
	public void setMoveKeyPressed(KeyCode moveKeyPressed) {
		this.moveKeyPressed = moveKeyPressed;
		
	}

	@Override
	public KeyCode getMoveKeyPressed() {
		return moveKeyPressed;
	}

	@Override
	public void update() {
		behavior.play();		
	}




}
