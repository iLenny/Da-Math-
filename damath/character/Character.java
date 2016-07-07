package damath.character;

import damath.interfaces.Updatable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Leibniz H. Berihuete
 * 
 *
 */
public abstract class Character extends Pane implements Updatable {
	protected ImageView characterView;
	protected String name;
	protected double speed;
	protected double attackPower;
	protected double hp;
	protected int level;
	protected boolean allowToMove;
	
	{
		characterView = new ImageView();
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
		
		characterView.setFocusTraversable(true);
		this.getChildren().add(characterView);
		
	}
	
	// Constructor(Image)
	public Character(Image characterImage) {
		setImage(characterImage);
		setName("Unknown");
		setSpeed(5.0);
		setAttackPower(20.0);
		setHP(100.0);
		setLevel(1);
		setAllowToMove(true);
		
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
		
		characterView.setFocusTraversable(true);
		this.getChildren().add(characterView);
	}
	
	
	
	
	/* *****************
	 *    MUTATORS
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
	
	/* ********************
	 *   ABSTRACT METHODS
	 * ********************/
	public abstract void update();
}
