package game.entities;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

public class Wall extends Entity {
	
	private final int TILE_SIZE = 8;
	private final int SCALE_FACTOR = 4;

	public Wall(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		setGraphic(ResourceManager.getSpriteSheet("env").getSprite(0, 2).getScaledCopy(SCALE_FACTOR));
		
		setHitBox(0, 0, TILE_SIZE*SCALE_FACTOR, TILE_SIZE*SCALE_FACTOR);
		addType(SOLID);
	}

}
