package damath.character;

import damath.interfaces.Behavior;
import damath.interfaces.Player;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Bob extends Character implements Player{
	private static final Image IMG = new Image(Bob.class.getResourceAsStream("../target.png"));
	private Behavior behavior;
	private KeyCode moveKeyPressed;
	
	public Bob() {
		this.setImage(IMG);
		PlayerBehavior pb = new PlayerBehavior(this);
		this.addBehaviour(pb);
		
	}
	
	@Override
	public void update() {
		behavior.play();
	}

	@Override
	public void addBehaviour(Behavior behavior) {
		this.behavior = behavior;
	}

	@Override
	public void handleSprite() {
		
	}

	@Override
	public void setMoveKeyPressed(KeyCode moveKeyPressed) {
		this.moveKeyPressed = moveKeyPressed;
	}

	@Override
	public KeyCode getMoveKeyPressed() {
		return moveKeyPressed;
	}
}
