package game.entities;

import it.marteEngine.ResourceManager;
import it.marteEngine.entity.Entity;

public class Tile extends Entity {
	
	private static final int TILE_SIZE = 8;
	private static final int SCALE_FACTOR = 4;
	
	public static final String WALL = "wall";
	public static final String FLOOR = "floor";
	public static final String BOUNDS = "bounds";


	public Tile(float x, float y, String type, boolean collidable, int sheetx, int sheety) {
		super(x, y);
		
		setGraphic(ResourceManager.getSpriteSheet("env").getSubImage(sheetx, sheety).getScaledCopy(SCALE_FACTOR));
		
		if(collidable){
			collidable = true;
			setHitBox(0, 0, TILE_SIZE*SCALE_FACTOR, TILE_SIZE*SCALE_FACTOR);
			addType(SOLID);
		} else {
			collidable = false; 
			addType(type);
		}
	}

}
