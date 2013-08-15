package game.character.ai;

import game.character.Creature;
import it.marteEngine.entity.Entity;

public abstract class CreatureAi {
	
	protected Creature creature;
	
	public CreatureAi(Creature creature){
		this.creature = creature;
		this.creature.setCreatureAi(this);
	}
	
	public void collide(Entity other){
	}

}
