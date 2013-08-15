package game.character.ai;

import game.character.Creature;
import game.entities.Tile;
import it.marteEngine.entity.Entity;

public class PlayerAi extends CreatureAi {

	public PlayerAi(Creature creature) {
		super(creature);
	}
	
	public void collide(Entity other) { 
		System.out.println("0");
		if (other instanceof Tile){
			System.out.println("1");
			Tile tile = (Tile) other;
			if(tile.isDiggable()){
				System.out.println("2");
				tile.changeType(Tile.FLOOR);
				System.out.println("4");
			}
		}
	}

}
