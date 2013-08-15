package game.level;

import game.entities.Tile;
import it.marteEngine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

public class Level {
	private static final int TILE_SIZE = 8;
	private static final int SCALE_FACTOR = 4;

	public int width;
	public int height;

	public String[][] tiles;

	public Level(String[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
	}

	private Entity convert(String tile, int x, int y) {
		if (tile.equalsIgnoreCase("wall")) {
			return new Tile(x * TILE_SIZE * SCALE_FACTOR, y * TILE_SIZE
					* SCALE_FACTOR, tile, true, 0, 2);
		}
		if (tile.equalsIgnoreCase("floor")) {
			return new Tile(x * TILE_SIZE * SCALE_FACTOR, y * TILE_SIZE
					* SCALE_FACTOR, tile, false, 0, 5);
		}

		return null;
	}

	public List<Entity> getEntities() {
		List<Entity> result = new ArrayList<Entity>();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				result.add(convert(tiles[x][y], x, y));
			}
		}
		return result;
	}

	public Vector2f findFreePlace() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y].equalsIgnoreCase(Tile.FLOOR)) {
					return new Vector2f(x, y);
				}
			}
		}
		return new Vector2f();
	}

	public boolean isFree(int x, int y) {
		if (x >= 0 && y >= 0 && x < width && y < height
				&& tiles[x][y].equalsIgnoreCase(Tile.FLOOR)) {
			return true;
		}
		return false;
	}
}
