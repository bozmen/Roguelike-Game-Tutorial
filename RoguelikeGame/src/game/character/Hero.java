package game.character;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Hero extends Entity {
	
	public static final String HERO = "hero";
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	
	private static final int tileSize = 8;
	private static final int scaleFactor = 4;
	private static final int step = tileSize * scaleFactor;

	public Hero(float x, float y) {
		super(x, y);
		
		setGraphic(ResourceManager.getSpriteSheet("char").getSprite(1, 0).getScaledCopy(scaleFactor));
		
		setHitBox(0, 0, tileSize * scaleFactor, tileSize * scaleFactor);
		addType(HERO);
		
		defineControls();
	}

	private void defineControls() {
		
		define(UP, Input.KEY_W, Input.KEY_UP);
		
		define(DOWN, Input.KEY_S, Input.KEY_DOWN);
		
		define(RIGHT, Input.KEY_D, Input.KEY_RIGHT);
		
		define(LEFT, Input.KEY_A, Input.KEY_LEFT);
	}
	
	private void move(int dx, int dy){
		x += dx*step;
		y += dy*step;
	}
	
	private void updateMovements() {
		if (pressed(UP)) {
			move(0, -1);
			if(collide(SOLID, x, y)!=null)
				move(0, 1);
			return;
		} 
		else if (pressed(DOWN)) {
			move(0, 1);
			if(collide(SOLID, x, y)!=null)
				move(0, -1);
			return;
		} 
		else if (pressed(RIGHT)) {
			move(1, 0);
			if(collide(SOLID, x, y)!=null)
				move(-1, 0);
			return;
		} 
		else if (pressed(LEFT)) {
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
