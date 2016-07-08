package damath.maps;

import damath.character.Character;
import damath.interfaces.Behavior;
import damath.interfaces.Player;
import damath.interfaces.Updatable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Map extends Pane implements Updatable{

	private ImageView backgroundView;
	private ImageView mapView;
	private Player player;
	private Behavior behavior;
	
	/* ******************
	 *   CONSTRUCTORS
	 * ******************/
	public Map(Player player) {
		setPlayer(player);
		backgroundView = new ImageView();
		mapView = new ImageView();
		
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
	
	/* ********************
	 * 	 ABSTRACT METHODS
	 * ********************/
}
