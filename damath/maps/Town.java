package damath.maps;

import java.util.ArrayList;

import damath.Game;
import damath.character.Character;
import damath.interfaces.CollisionObject;
import damath.interfaces.Player;
import damath.tools.CollisionBar;
import damath.tools.CollisionBox;
import javafx.scene.image.Image;

/**
 * 
 * @author Leibniz H. Berihuete
 * This class was created to test the Map class
 */
public class Town extends Map {
	private Image bgImg;
	private Image mapImg;
	private Image crateImg;
	private CollisionBox floor;
	
	public Town(Player player) {
		super(player);
		bgImg = new Image(Town.class.getResourceAsStream("../images/background.gif"));
		mapImg = new Image(Town.class.getResourceAsStream("../images/mapSample.png"));
		crateImg = new Image(Town.class.getResourceAsStream("../images/cratebox.png"));
		
		setBackgroundView(bgImg);
		setMapView(mapImg);
		MapBehavior mb = new MapBehavior(this);
		addBehavior(mb);		
		floor = new CollisionBox(mapImg.getWidth(), 30);
		floor.setVisible(false);
		
		
		addCollisionObject(floor, 0, 545);
		
		addCollisionObject(new CollisionBox(crateImg), 0, 500);
	}

	@Override
	public void update() {
		getBehavior().play();
		((Character)getPlayer()).update();
		for(int i = 0; i < this.getCollisionBoxList().size(); i++) {
			CollisionBox box = this.getCollisionBoxList().get(i);
			box.buildCollisionWith((Character)getPlayer());
		}
	}

}
