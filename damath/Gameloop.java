package damath;

import damath.interfaces.Updatable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public abstract class Gameloop implements Updatable {
	private Timeline timeline;
		
	public void run() {
		timeline = new Timeline(new KeyFrame(Duration.millis(1), e->{
			update();		
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
}
