package damath.character;

import damath.interfaces.Behavior;
import damath.interfaces.Enemy;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class KingGoblin extends Character implements Enemy{
	private static final Image SPRITE_IMG = 
			new Image(KingGoblin.class.getResourceAsStream("../images/king-goblin.png"));
	
	private static final int WIDTH = 143;
	private static final int HEIGHT = 140;
	private Behavior behavior;
	
	private int frameCount = 0;
	private final int TIME_COUNT = (int)(1000/(getSpeed()*1.2));
	private int time = TIME_COUNT;
	
	private Rectangle2D [] standingSprite = new Rectangle2D[3];
	private Rectangle2D [] walkingSprite = new Rectangle2D[6];
	private Rectangle2D [] attackingSprite;
	private Rectangle2D [] dyingSprite;
	
	
	
	public KingGoblin() {
		rightScale = -1;
		leftScale = 1;
		
		head.setTranslateX(15);
		head.setTranslateY(30);
		body.setTranslateX(20);
		body.setTranslateY(75);
		feet.setTranslateX(15);
		feet.setTranslateY(102);
		
		head.setWidth(WIDTH*0.3);
		body.setWidth(WIDTH*0.7);
		feet.setWidth(WIDTH*0.5);
		
		head.setVisible(false);
		body.setVisible(false);
		feet.setVisible(false);
		
		// Standing sprite:
		standingSprite[0] = new Rectangle2D(0, 40, WIDTH, HEIGHT);
		standingSprite[1] = new Rectangle2D(144, 40, WIDTH, HEIGHT);
		standingSprite[2] = new Rectangle2D(290, 40, WIDTH, HEIGHT);
		/*standingSprite[3] = new Rectangle2D(435, 40, WIDTH, HEIGHT);
		standingSprite[4] = new Rectangle2D(570, 40, WIDTH, HEIGHT);
		standingSprite[5] = new Rectangle2D(710, 40, WIDTH, HEIGHT);*/
		
		// Walking Sprite
		
		walkingSprite[0] = new Rectangle2D(0, 207, WIDTH, HEIGHT);
		walkingSprite[1] = new Rectangle2D(147, 207, WIDTH, HEIGHT);
		walkingSprite[2] = new Rectangle2D(294, 207, WIDTH, HEIGHT);
		walkingSprite[3] = new Rectangle2D(437, 207, WIDTH, HEIGHT);
		walkingSprite[4] = new Rectangle2D(585, 207, WIDTH, HEIGHT);
		walkingSprite[5] = new Rectangle2D(716, 207, WIDTH, HEIGHT);
		
		this.addBehaviour(new EnemyBehavior(this));
		
		setImage(SPRITE_IMG);
		characterView.setViewport(standingSprite[0]);
	}
	
	@Override
	public void update() {
		behavior.play();
	}

	@Override
	public void handleSprite() {
		if(time == 0) {
			// Keep track of the frameCount:
			if(frameCount < walkingSprite.length-1) {
				frameCount++;
			}
			else {
				frameCount = 0;
			}
			
			// ChangeSprite:
			this.characterView.setViewport(walkingSprite[frameCount]);
			time = TIME_COUNT;
		}
		else {
			time--;
		}
		
	}

	@Override
	public void resetPosition() {
		if(time == 0) {
			// Keep track of the frameCount:
			if(frameCount < standingSprite.length-1) {
				frameCount++;
			}
			else {
				frameCount = 0;
			}
			
			// ChangeSprite:
			this.characterView.setViewport(standingSprite[frameCount]);
			time = TIME_COUNT;
		}
		else {
			time--;
		}
		
	}

	@Override
	public void jumpPosition() {
		characterView.setViewport(walkingSprite[2]);
		
	}

	@Override
	public void addBehaviour(Behavior behavior) {
		this.behavior = behavior;
		
	}
	
}
