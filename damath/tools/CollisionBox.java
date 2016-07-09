package damath.tools;

import damath.character.Character;
import damath.interfaces.CollisionObject;
import damath.maps.Map;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CollisionBox extends Pane implements CollisionObject {
	
	private static final double LONG_WIDTH = 55;
	private static final double LONG_HEIGHT = 55;
			
	private static final double SHORT_WIDTH = 10;
	private static final double SHORT_HEIGHT = 10;
	
	private CollisionBar leftBar;
	private CollisionBar rightBar;
	private CollisionBar upBar;
	private CollisionBar downBar;
	
	private double gravity = Map.DEFAULT_GRAVITY;
	
	public CollisionBox() {
		leftBar = new CollisionBar(PUSH_LEFT, SHORT_WIDTH, LONG_HEIGHT);
		rightBar = new CollisionBar(PUSH_RIGHT, SHORT_WIDTH, LONG_HEIGHT);
		upBar = new CollisionBar(PUSH_UP, LONG_WIDTH, SHORT_HEIGHT);
		downBar = new CollisionBar(PUSH_DOWN, LONG_WIDTH, SHORT_HEIGHT);
		
		leftBar.setFill(Color.BLUEVIOLET);
		rightBar.setFill(Color.BISQUE);
		upBar.setFill(Color.AQUA);
		downBar.setFill(Color.CRIMSON);
		
		rightBar.setTranslateX(rightBar.getTranslateX() + LONG_WIDTH - SHORT_WIDTH);
		downBar.setTranslateY(rightBar.getTranslateY() + LONG_HEIGHT - SHORT_HEIGHT);
		this.getChildren().addAll(leftBar, rightBar, upBar, downBar);
	}
	
	public CollisionBox(double width, double height) {
		double shortWidth = (width * height)*0.0001 + SHORT_WIDTH;
		double shortHeight = (width * height)*0.0001 + SHORT_HEIGHT;
		
		leftBar = new CollisionBar(PUSH_LEFT, shortWidth, height);
		rightBar = new CollisionBar(PUSH_RIGHT, shortWidth, height);
		upBar = new CollisionBar(PUSH_UP, width, shortHeight);
		downBar = new CollisionBar(PUSH_DOWN, width, shortHeight);
		
		leftBar.setFill(Color.BLUEVIOLET);
		rightBar.setFill(Color.BISQUE);
		upBar.setFill(Color.AQUA);
		downBar.setFill(Color.CRIMSON);
		
		rightBar.setTranslateX(rightBar.getTranslateX() + width - shortWidth);
		downBar.setTranslateY(rightBar.getTranslateY() + height - shortHeight);

		this.getChildren().addAll(leftBar, rightBar, upBar, downBar);
	}
	
	public CollisionBox(Image img) {
		double width = img.getWidth();
		double height = img.getHeight();
		double shortWidth = (width * height)*0.0001 + SHORT_WIDTH;
		double shortHeight = (width * height)*0.0001 + SHORT_HEIGHT;
		
		leftBar = new CollisionBar(PUSH_LEFT, shortWidth, height);
		rightBar = new CollisionBar(PUSH_RIGHT, shortWidth, height);
		upBar = new CollisionBar(PUSH_UP, width, shortHeight);
		downBar = new CollisionBar(PUSH_DOWN, width, shortHeight);
		
		leftBar.setFill(Color.BLUEVIOLET);
		rightBar.setFill(Color.BISQUE);
		upBar.setFill(Color.AQUA);
		downBar.setFill(Color.CRIMSON);
		
		leftBar.setVisible(false);
		rightBar.setVisible(false);
		upBar.setVisible(false);
		downBar.setVisible(false);
		
		rightBar.setTranslateX(rightBar.getTranslateX() + width - shortWidth);
		downBar.setTranslateY(rightBar.getTranslateY() + height - shortHeight);

		this.getChildren().addAll(new ImageView(img),leftBar, rightBar, upBar, downBar);
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public CollisionBar getLeftBar() {
		return leftBar;
	}
	
	public CollisionBar getRightBar() {
		return rightBar;
	}
	
	public CollisionBar getUpBar() {
		return upBar;
	}
	
	public CollisionBar getDownBar() {
		return downBar;
	}
	

	@Override
	public void buildCollisionWith(Character playerChar) {
		Bounds playerBody = playerChar.getBodyBounds();
		Bounds playerHead = playerChar.getHeadBounds();
		Bounds playerFeet = playerChar.getFeetBounds();
		Bounds leftBounds = leftBar.localToScene(leftBar.getBoundsInLocal());
		Bounds rightBounds = rightBar.localToScene(rightBar.getBoundsInLocal());
		Bounds upBounds = upBar.localToScene(upBar.getBoundsInLocal());
		Bounds downBounds = downBar.localToScene(downBar.getBoundsInLocal());
		
		// PLAYER HITS LEFT BAR
		if(playerBody.intersects(leftBounds)) {
			leftBar.buildCollisionWith(playerChar);
		}
		
		// PLAYER HITS RIGHT BAR
		else if(playerBody.intersects(rightBounds)) {
			rightBar.buildCollisionWith(playerChar);
		}
		
		// PLAYER HITS UP BAR
		if(playerFeet.intersects(upBounds) && playerChar.isFalling()) {
			upBar.buildCollisionWith(playerChar);
			playerChar.setAllowToJump(true);
			if(Character.once == true) {
				Character.once = false;
				playerChar.resetPosition();
			}
			
		}
		
		// PLAYER HITS DOWN BAR
		else if(playerHead.intersects(downBounds)){
			downBar.buildCollisionWith(playerChar);
			
		}
	}
}
