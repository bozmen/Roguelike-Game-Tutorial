package game.character;

import it.marteEngine.ResourceManager;

public class Fungus extends Creature {

	public Fungus(float x, float y) {
		super(x*TILE_SIZE*SCALE, y*TILE_SIZE);	
		
		setGraphic(ResourceManager.getSpriteSheet("env").getSubImage(12, 6).getScaledCopy(SCALE));
		
		addType(FUNGUS);
		setHitBox(0, 0, TILE_SIZE*SCALE, SCALE*TILE_SIZE);
	}
}
