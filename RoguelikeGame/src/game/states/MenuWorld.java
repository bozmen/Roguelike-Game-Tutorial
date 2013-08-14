package game.states;

import it.randomtower.engine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuWorld extends World {

	public MenuWorld(int id, GameContainer container) {
		super(id, container);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		super.render(container, game, g);
		
		g.drawString("Press space to play.", 5, 5);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		super.update(container, game, delta);
		
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_SPACE)){
			game.enterState(1);
		}
	}

}
