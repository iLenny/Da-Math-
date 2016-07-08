package damath.maps;

import java.util.ArrayList;

import damath.character.Character;
import damath.interfaces.Behavior;
import damath.interfaces.CollisionObject;
import damath.interfaces.Player;
import damath.interfaces.Updatable;
import damath.tools.CollisionBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Map extends Pane implements Updatable{
	public static final double DEFAULT_GRAVITY = 9.8;
	
	private ImageView backgroundView;
	private ImageView mapView;
	private Player player;
	private Behavior behavior;
	private double gravity;
	private ArrayList<CollisionBox> collisionBoxList;
	
	/* ******************
	 *   CONSTRUCTORS
	 * ******************/
	public Map(Player player) {
		setPlayer(player);
		setGravity(9.8);
		backgroundView = new ImageView();
		mapView = new ImageView();
		collisionBoxList = new ArrayList<>();
		
		this.getChildren().addAll(backgroundView, mapView, (Character)player);
	}
	
	/* ******************
	 * 	  MUTATORS 
	 * ******************/
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setBackgroundView(Image backgroundImage) {
		backgroundView.setImage(backgroundImage);;
	}
	
	public void setMapView(Image mapImage) {
		mapView.setImage(mapImage);
	}
	
	public void addBehavior(Behavior behavior) {
		this.behavior = behavior;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	/* ******************
	 *     ACCESSORS
	 * ******************/
	public Player getPlayer() {
		return player;
	}
	
	public ImageView getBackgroundView() {
		return backgroundView;
	}
	
	public ImageView getMapView() {
		return mapView;
	}
	
	public Behavior getBehavior() {
		return behavior;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public ArrayList<CollisionBox> getCollisionBoxList() {
		return collisionBoxList;
	}
	
	
	/* ********************
	 * 	 OTHER METHODS
	 * ********************/
	public void addCollisionObject(CollisionBox obj, double x, double y) {
		obj.relocate(x, y);
		collisionBoxList.add(obj);
		this.getChildren().add(2,obj);
	}
}
