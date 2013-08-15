package game.character;

import game.character.ai.CreatureAi;
import game.character.ai.PlayerAi;
import game.states.GameWorld;
import it.marteEngine.ME;
import it.marteEngine.ResourceManager;
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Hero extends Creature {
	
	public static final String HERO = "hero";
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	
	private static final int tileSize = 8;
	private static final int scaleFactor = 4;
	private static final int step = tileSize * scaleFactor;
	
	public CreatureAi ai;

	public Hero(float x, float y, GameWorld gameWorld) {
		super(x, y);
		
		setGraphic(ResourceManager.getSpriteSheet("char").getSprite(1, 0).getScaledCopy(scaleFactor));
		
		setHitBox(0, 0, tileSize * scaleFactor, tileSize * scaleFactor);
		addType(HERO);
		
		defineControls();
		this.world = gameWorld;
		
		creatureAi = new PlayerAi(this);
	}
	
	public Hero(Vector2f vector, GameWorld gameWorld) {
		this(vector.x + 32, vector.y + 32, gameWorld);
	}

	private void defineControls() {
		
		define(UP, Input.KEY_W, Input.KEY_UP);
		
		define(DOWN, Input.KEY_S, Input.KEY_DOWN);
		
		define(RIGHT, Input.KEY_D, Input.KEY_RIGHT);
		
		define(LEFT, Input.KEY_A, Input.KEY_LEFT);
	}
	
	private void updateMovements() {
		if (pressed(UP) && y-step >= 0) {
			move(0, -1);
			if(collide(SOLID, x, y)!=null)
				move(0, 1);
			return;
		} 
		else if (pressed(DOWN) && y+step < world.height) {
			move(0, 1);
			if(collide(SOLID, x, y)!=null)
				move(0, -1);
			return;
		} 
		else if (pressed(RIGHT) && x+step < world.width) {
			move(1, 0);
			if(collide(SOLID, x, y)!=null)
				move(-1, 0);
			return;
		} 
		else if (pressed(LEFT) && x-step >= 0) {
		    move(-1, 0);
		    if(collide(SOLID, x, y)!=null)
		    	move(1, 0);
		    return;
		 }
		

	}
	
	public void update(GameContainer container, int delta) throws SlickException{
		super.update(container, delta);
		ME.keyToggleDebug = Input.KEY_1;
		updateMovements();	
	}
	

}
