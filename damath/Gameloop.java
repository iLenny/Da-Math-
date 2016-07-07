package damath;

import damath.interfaces.Updatable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
/**
 * 
 * @author Leibniz H. Berihuete
 *  This class will act as the gameloop for the game.
 *  It is abstract class because it is necessary in order to
 *  override the update method.
 */
public abstract class Gameloop implements Updatable {
	private Timeline timeline;
	
	
	/* ***************
	 *   CONSTRUCTOR
	 * ***************/
	public Gameloop() {
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
	
	// Abstract Method:
	public abstract void update();
	
	
}
