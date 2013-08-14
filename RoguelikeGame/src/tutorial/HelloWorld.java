package tutorial;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.World;
import it.randomtower.engine.entity.TextEntity;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class HelloWorld extends StateBasedGame {

	private static boolean resourcesInited;

	public HelloWorld(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		initResources();

		World world = new World(0, container);
		world.add(new TextEntity(100, 100, null, "Hello World"));
		this.addState(world);
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
			AppGameContainer container = new AppGameContainer(new HelloWorld("Hello World Marte Engine"));
			container.setDisplayMode(640, 480, false);
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
