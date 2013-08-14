package game.states;

import game.character.Hero;
import game.entities.Wall;
import it.randomtower.engine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWorld extends World implements GameState {

	public GameWorld(int id, GameContainer container) {
		super(id, container);
		
		init();
	}
	
	public void init(){
		add(new Hero(64, 64));
		add(new Wall(128,128));
		add(new Wall(96,128));
		add(new Wall(64,128));
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		super.render(container, game, g);
		
		g.drawString("GAME YAYYY!", 5, 5);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		super.update(container, game, delta);
		
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			game.enterState(0);
		}
	}

}
