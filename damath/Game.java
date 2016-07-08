package damath;

import damath.players.Zipangu;
import damath.settings.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Leibniz H. Berihuete
 * This is the main class.
 * This class will connect all the game scenes
 * 
 */
public class Game extends Gameloop {
	// Default Values:
	public static final int  WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final double FPS = 1000/30;
	
	private Zipangu zipangu;

	// START
	@Override public void start(Stage primaryStage) {
		
		// Player:
		zipangu = new Zipangu();
		zipangu.relocate(0, 400);
		
		// Give the player controls:
		Controller.getInstance().linkControlsWith(zipangu);
		
		// Add player to the root layout:
		Pane root = new Pane(zipangu);
		
		// Play gameloop
		play();
		
		primaryStage.setTitle("Da Math!");
		primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
		primaryStage.show();
		
	}
	
	// UPDATE
	@Override public void update() {
		zipangu.update();
	}
	
	
	// MAIN
	public static void main(String [] args) {
		launch(args);
	}
	
	
	
}
