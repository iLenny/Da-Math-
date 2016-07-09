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
		
		addCollisionObject(new CollisionBox(crateImg),100, 500);
		addCollisionObject(new CollisionBox(crateImg),151, 500);
		addCollisionObject(new CollisionBox(crateImg),151, 449);
		addCollisionObject(new CollisionBox(crateImg),202, 500);
		
		CollisionBox box1 = new CollisionBox(crateImg);
		CollisionBox box2 = new CollisionBox(crateImg);
		box1.getUpBar().setPushDirection(CollisionObject.NONE);
		box2.getUpBar().setPushDirection(CollisionObject.NONE);
		
		
		addCollisionObject(new CollisionBox(crateImg),500, 500);
		addCollisionObject(new CollisionBox(crateImg),551, 500);
		addCollisionObject(new CollisionBox(crateImg),551, 449);
		addCollisionObject(new CollisionBox(crateImg),602, 500);
		addCollisionObject(new CollisionBox(crateImg),602, 449);
		addCollisionObject(box1,653, 500);
		addCollisionObject(box2,653, 449);
		addCollisionObject(new CollisionBox(crateImg),653, 398);
		addCollisionObject(new CollisionBox(crateImg),753, 398);
	
		
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
