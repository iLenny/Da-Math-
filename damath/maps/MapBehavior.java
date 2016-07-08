package damath.maps;

import damath.interfaces.Behavior;
import damath.interfaces.Player;
import damath.settings.Controller;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import damath.Game;
import damath.character.Character;

public class MapBehavior implements Behavior {
	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	

	private Player player;
	private ImageView backgroundView;
	private ImageView mapView;
	private Character playerChar;
	private Controller controller;
	
	public MapBehavior(Map map) {
		player = map.getPlayer();
		playerChar = (Character)player;
		backgroundView = map.getBackgroundView();
		mapView = map.getMapView();
		controller = Controller.getInstance();
		
	}
	
	@Override
	public void play() {		
		
		// IF PLAYER IS MOVING RIGHT
		if(player.getMoveKeyPressed() == controller.getMoveRightKey() && playerChar.getAllowToMove()) {
			moveMap(LEFT);
		}
		
		// IF PLAYER IS MOVING LEFT
		else if(player.getMoveKeyPressed() == controller.getMoveLeftKey() && playerChar.getAllowToMove()) {
			moveMap(RIGHT);
		}
	}
	
	private void moveMap(int direction) {
		Bounds playerBounds = playerChar.localToScene(playerChar.getBoundsInLocal());
		Bounds mapBounds = mapView.localToScene(mapView.getBoundsInLocal());
	
		double playerX = playerBounds.getMinX();
		double mapX = mapBounds.getMinX();
		double mapWidth = mapView.getImage().getWidth();
		
		
		switch(direction) {
		case LEFT:
			if(playerX > (Game.WINDOW_WIDTH * 0.70) && mapX >= -mapWidth) {
				playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				mapView.setTranslateX(mapView.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX() - (playerChar.getSpeed()/Game.FPS) * 0.3);
			}
			break;
			
		case RIGHT:
			if(playerX < (Game.WINDOW_WIDTH * 0.30) && mapX <= 0) {
				playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				mapView.setTranslateX(mapView.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX() + (playerChar.getSpeed()/Game.FPS) * 0.3);
			}
			break;
		}
	}
}
