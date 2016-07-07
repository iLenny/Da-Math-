package damath;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 
 * @author Leibniz H. Berihuete
 *  This class will act as the gameloop for the game.
 *  It is abstract class because it is necessary in order to
 *  override the update method.
 */
public abstract class Gameloop extends Application {
	private Timeline timeline;
	
	/* ***************
	 *   CONSTRUCTOR
	 * ***************/
	protected Gameloop() {
		timeline = new Timeline(new KeyFrame(Duration.millis(1), e->{
			update();		
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
	}
	
		
	// PLAY:
	public void play() {
		timeline.play();
	}
	
	// PAUSE:
	public void pause() {
		timeline.pause();
	}
	
	// STOP:
	public void stop() {
		timeline.stop();
	}
	
	// Abstract Methods:
	public abstract void update();
	public abstract void start(Stage primaryStage);
	
	
}
