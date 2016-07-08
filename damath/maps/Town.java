package damath.maps;

import damath.character.Character;
import damath.interfaces.Player;
import javafx.scene.image.Image;

public class Town extends Map {
	private static final Image BG_IMG = 
			new Image(Town.class.getResourceAsStream("../images/background.gif"));
	private static final Image MAP_IMG = 
			new Image(Town.class.getResourceAsStream("../images/mapSample.png"));
	
	
	public Town(Player player) {
		super(player);
		setBackgroundView(BG_IMG);
		setMapView(MAP_IMG);
		MapBehavior mb = new MapBehavior(this);
		addBehavior(mb);
	}

	@Override
	public void update() {
		getBehavior().play();
		((Character)getPlayer()).update();
	}

}
