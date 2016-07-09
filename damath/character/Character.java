package damath.character;

import damath.interfaces.Updatable;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author Leibniz H. Berihuete
 * The Character abstract class will be used as a way to create characters such
 * as Enemies, or Players. The subclass must specify whether it is an enemy or a player
 * by implementing that correspond to either Enemy interface or Player interface
 *
 */
public abstract class Character extends Pane implements Updatable {
	public static boolean once = true;
	protected ImageView characterView;
	protected String name;
	protected double speed;
	protected double attackPower;
	protected double jumpPower;
	protected double hp;
	protected int level;
	protected boolean allowToMove;
	protected boolean allowToJump;
	protected double leftScale = -1;
	protected double rightScale = 1;
	protected boolean falling = true;
	
	protected Rectangle head;
	protected Rectangle body;
	protected Rectangle feet;
	
	
	{
		characterView = new ImageView();
		head = new Rectangle(20,20);
		head.setFill(Color.BEIGE);
		
		body = new Rectangle(20, 20);
		body.setFill(Color.BURLYWOOD);
		
		feet = new Rectangle(20, 10);
		feet.setFill(Color.CORNFLOWERBLUE);
	}
	
	/* *****************
	 *    CONSTRUCTORS
	 * *****************/
	
	// Default constructor:
	public Character () {
		setImage(null);
		setName("Unknown");
		setSpeed(5.0);
		setAttackPower(20.0);
		setHP(100.0);
		setLevel(1);
		setAllowToMove(true);
		setAllowToJump(false);
		setJumpPower(10);
		
		characterView.setFocusTraversable(true);
		this.getChildren().addAll(characterView, head, body, feet);
		
	}
	
	// Constructor(Image)
	public Character(Image characterImage) {
		setImage(characterImage);
		setName("Unknown");
		setSpeed(5.0);
		setAttackPower(20.0);
		setJumpPower(10);
		setHP(100.0);
		setLevel(1);
		setAllowToMove(true);
		setAllowToJump(false);
		setJumpPower(10);
		
		characterView.setFocusTraversable(true);
		this.getChildren().add(characterView);
	}
	
	// Constructor(String)
	public Character(String name) {
		setImage(null);
		setName(name);
		setSpeed(5.0);
		setAttackPower(20.0);
		setHP(100.0);
		setLevel(1);
		setAllowToMove(true);
		setAllowToJump(false);
		setJumpPower(10);
		
		characterView.setFocusTraversable(true);
		this.getChildren().add(characterView);
	}
	
	// Constructor(String, Image)
	public Character(String name, Image characterImage) {
		setImage(characterImage);
		setName(name);
		setSpeed(5.0);
		setAttackPower(20.0);
		setHP(100.0);
		setLevel(1);
		setAllowToMove(true);
		setAllowToJump(false);
		setJumpPower(10);
		
		characterView.setFocusTraversable(true);
		this.getChildren().add(characterView);
	}
	
	
	
	
	/* *****************
	 *     MUTATORS
	 * *****************/
	public void setImage(Image characterImage) {
		characterView.setImage(characterImage);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setAttackPower(double attackPower) {
		this.attackPower = attackPower;
	}
	
	public void setHP(double hp) {
		this.hp = hp;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setAllowToMove(boolean allowToMove) {
		this.allowToMove = allowToMove;
	}
	
	public void setAllowToJump(boolean allowToJump) {
		this.allowToJump = allowToJump;
	}
	
	public void setRightScale(double rightScale) {
		this.rightScale = rightScale;
	}
	
	public void setLeftScale(double leftScale) {
		this.leftScale = leftScale;
	}
	
	public void isFalling(boolean falling) {
		this.falling = falling;
	}
	
	public void setJumpPower(double jumpPower) {
		this.jumpPower = jumpPower;
	}
	
	
	
	/* ******************
	 *     ACCESSORS
	 * ******************/
	public String getName() {
		return name;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getAttackPower() {
		return attackPower;
	}
	
	public double getHP() {
		return hp;
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean getAllowToMove() {
		return allowToMove;
	}
	
	public boolean getAllowToJump() {
		return allowToJump;
	}
	
	public double getRightScale() {
		return rightScale;
	}
	
	public double getLeftScale() {
		return leftScale;
	}
	
	
	public Bounds getHeadBounds() {
		return (head.localToScene(head.getBoundsInLocal()));
	}
	
	public Bounds getBodyBounds() {
		return (body.localToScene(body.getBoundsInLocal()));
	}
	
	public Bounds getFeetBounds() {
		return (feet.localToScene(feet.getBoundsInLocal()));
	}
	
	public boolean isFalling() {
		return falling;
	}
	
	public double getJumpPower() {
		return jumpPower;
	}
	

	
	
	/* ********************
	 *   ABSTRACT METHODS
	 * ********************/
	public abstract void update();
	public abstract void handleSprite();
	public abstract void resetPosition();
	public abstract void jumpPosition();
}
