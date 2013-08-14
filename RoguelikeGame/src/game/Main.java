package game;

import game.states.GameWorld;
import game.states.MenuWorld;
import it.marteEngine.ME;
import it.marteEngine.ResourceManager;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Main extends StateBasedGame{
	
	private static boolean resourcesInited;

	public Main(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		initResources();
		
		addState(new MenuWorld(0, container));
		addState(new GameWorld(1, container));
	}

	public void initResources() {
		if (resourcesInited)
			return;
		try {
			ResourceManager.loadResources("data/resource.xml");
		} catch (IOException e) {
			Log.error("failed to load resource file 'data/resource.xml': "
					+ e.getMessage());
		}
		
		resourcesInited = true;
	}

	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Main("Hello World Marte Engine"));
			container.setDisplayMode(640, 480, false);
			container.setTargetFrameRate(60);
			container.start();
			ME.keyToggleDebug = Input.KEY_1;
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
