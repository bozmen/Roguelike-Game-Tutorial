package game.states;

import javax.rmi.CORBA.Tie;

import game.character.Creature;
import game.character.CreatureFactory;
import game.character.Hero;
import game.level.Level;
import game.level.LevelBuilder;
import it.marteEngine.Camera;
import it.marteEngine.ME;
import it.marteEngine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWorld extends World implements GameState {

	private Hero hero;

	private int tileWidth = 40;
	private int tileHeight = 30;

	private static final int TILE_SIZE = 8;
	private static final int SCALE_FACTOR = 4;

	private CreatureFactory cf;
	private Level level;

	public GameWorld(int id, GameContainer container) {
		super(id, container);

		cf = new CreatureFactory(this);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(container, game, g);

		g.drawString("GAME YAYYY!", 5, 5);
		g.drawString("im", hero.x, hero.y);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);

		Input input = container.getInput();

		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			game.enterState(0);
		}

		ME.keyToggleDebug = Input.KEY_1;
	}

	public void enter(GameContainer container, StateBasedGame game) {
		// destroy everything
		clear();
		// add random cave
		level = new LevelBuilder(tileWidth, tileHeight).makeCaves().build();
		addAll(level.getEntities());
		// adding fungus
		for (int i = 0; i < 8; i++) {
			addAtEmptyRandomLocation(cf.newFungus());
		}
		// adding hero
		hero = cf.newHero();
		addAtEmptyLocation(hero);
		// hero = new Hero(level.findFreePlace().scale(SCALE_FACTOR*TILE_SIZE),
		// this);
		// add(hero);
		// setting camera

		this.setCamera(new Camera(this, hero, container.getWidth(), container
				.getHeight(), 1000, 1000, new Vector2f(32, 32)));
		setWidth(tileWidth * TILE_SIZE * SCALE_FACTOR);
		setHeight(tileHeight * TILE_SIZE * SCALE_FACTOR);
	}

	public void addAtEmptyRandomLocation(Creature creature) {
		int x;
		int y;
		do {
			x = (int) (Math.random() * tileWidth);
			y = (int) (Math.random() * tileHeight);
		} while (!level.isFree(x, y));

		creature.x = x * TILE_SIZE * SCALE_FACTOR;
		creature.y = y * TILE_SIZE * SCALE_FACTOR;
		add(creature);
	}

	public void addAtEmptyLocation(Creature creature) {
		Vector2f pos;
		do {
			pos = level.findFreePlace();
		} while (!level.isFree((int) pos.x, (int) pos.y));

		creature.x = pos.x * TILE_SIZE * SCALE_FACTOR;
		creature.y = pos.y * TILE_SIZE * SCALE_FACTOR;
		add(creature);
	}
}
