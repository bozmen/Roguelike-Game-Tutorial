package game.character.ai;

import game.character.Creature;
import game.character.Hero;
import it.marteEngine.entity.Entity;

public class FungusAi extends CreatureAi {

	public FungusAi(Creature creature) {
		super(creature);
	}
	
	public void collide(Entity other){
		if(other instanceof Hero){
			creature.world.remove(creature);
		}
	}

}
