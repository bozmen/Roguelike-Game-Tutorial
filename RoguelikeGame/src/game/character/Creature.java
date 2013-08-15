package game.character;

import game.character.ai.CreatureAi;
import game.entities.Tile;
import it.marteEngine.entity.Entity;

public class Creature extends Entity{
	
	public static final int TILE_SIZE = 8;
	public static final int SCALE = 4;
	public static final int STEP = SCALE * TILE_SIZE;
	
	protected CreatureAi creatureAi;

	public Creature(float x, float y) {
		super(x, y);
	}
	
	public void setCreatureAi(CreatureAi ai){
		this.creatureAi = ai;
	}
	
	public void move(int dx, int dy) {
		float cx = x + dx * STEP;
		float cy = y + dy * STEP;
		if(collide(Tile.WALL, cx, cy) == null){
			x = cx;
			y = cy;
		}
	}
	
	public void collisionResponse(Entity other){
		System.out.println("5");
		System.out.println(creatureAi);
		creatureAi.collide(other);
		System.out.println("6");
	}

}
