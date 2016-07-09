package damath.interfaces;
import damath.character.Character;

public interface CollisionObject {
	public static final int NONE = -1;
	public static final int PUSH_LEFT = 0;
	public static final int PUSH_RIGHT = 1;
	public static final int PUSH_UP = 2;
	public static final int PUSH_DOWN = 3;
	public void buildCollisionWith(Character player);
}
