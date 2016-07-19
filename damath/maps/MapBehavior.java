package damath.maps;

import damath.interfaces.Behavior;
import damath.interfaces.CollisionObject;
import damath.interfaces.Enemy;
import damath.interfaces.Player;
import damath.settings.Controller;
import damath.tools.CollisionBox;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import damath.Game;
import damath.character.Character;

public class MapBehavior implements Behavior {
	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	

	private Player player;
	private ImageView backgroundView;
	private ImageView mapView;
	private Character playerChar;
	private Character enemyChar;
	private Controller controller;
	private ArrayList<CollisionBox> collisionBoxList;
	private ArrayList<Enemy> enemies;
	
	
	private double gravity;
	
	public MapBehavior(Map map) {
		player = map.getPlayer();
		playerChar = (Character)player;
		backgroundView = map.getBackgroundView();
		mapView = map.getMapView();
		gravity = map.getGravity();
		collisionBoxList = map.getCollisionBoxList();
		controller = Controller.getInstance();
		enemies = map.getEnemies();
		
	}
	
	@Override
	public void play() {
		// GRAVITY:
		if(playerChar.isFalling()) {
			playerChar.setTranslateY(playerChar.getTranslateY() + gravity/Game.FPS);
		}
		
		if(enemies != null) {
			for(int i = 0; i <  enemies.size(); i++) {
				enemyChar = (Character) enemies.get(i);
				if(enemyChar.isFalling()) {
					enemyChar.setTranslateY(enemyChar.getTranslateY() + gravity/Game.FPS);
				}
			}
		}
		
		
		
		
		
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
			if(playerX > (Game.WINDOW_WIDTH * 0.70) && mapX >= -1*(mapWidth - Game.WINDOW_WIDTH*0.9)) {
				playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				mapView.setTranslateX(mapView.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX() - (playerChar.getSpeed()/Game.FPS) * 0.2);
				
				for(int i = 0; i < collisionBoxList.size(); i++) {
					CollisionBox box = collisionBoxList.get(i);
					box.setTranslateX(box.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				}
				
				for(int i = 0; i < enemies.size(); i++) {
					enemyChar = (Character)enemies.get(i);
					enemyChar.setTranslateX(enemyChar.getTranslateX() - playerChar.getSpeed()/Game.FPS);
				}
			}
			break;
			
		case RIGHT:
			if(playerX < (Game.WINDOW_WIDTH * 0.30) && mapX <= 0) {
				playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				mapView.setTranslateX(mapView.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX() + (playerChar.getSpeed()/Game.FPS) * 0.2);
				
				for(int i = 0; i < collisionBoxList.size(); i++) {
					CollisionBox box = collisionBoxList.get(i);
					box.setTranslateX(box.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				}
				
				for(int i = 0; i < enemies.size(); i++) {
					enemyChar = (Character)enemies.get(i);
					enemyChar.setTranslateX(enemyChar.getTranslateX() + playerChar.getSpeed()/Game.FPS);
				}
			}
			break;
		}
	}
}
