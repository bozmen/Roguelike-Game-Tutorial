package game.character;

import game.character.ai.FungusAi;
import game.character.ai.PlayerAi;
import game.states.GameWorld;

public class CreatureFactory {
	
	private GameWorld world;

	public CreatureFactory(GameWorld world) {
		// TODO Auto-generated constructor stub
		this.world = world;
	}
	
	public Hero newHero(){
		Hero hero = new Hero(0, 0, world);
		hero.setCreatureAi(new PlayerAi(hero));
		return hero;
	}
	
	public Fungus newFungus(){
		Fungus fungus = new Fungus(0, 0);
		fungus.setCreatureAi(new FungusAi(fungus));
		return fungus;
	}

}
