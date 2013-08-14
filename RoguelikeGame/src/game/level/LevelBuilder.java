package game.level;

import game.entities.Tile;

public class LevelBuilder {
	
	public int width;
	public int height;
	
	public String[][] tiles;
	
	public LevelBuilder(int width, int height){
		this.width = width;
		this.height = height;
		this.tiles = new String[width][height];
	}
	
	public Level build(){
		return new Level(tiles);
	}
	
	private LevelBuilder randomizeTiles(){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
			}
		}
		return this;
	}
	
	private LevelBuilder smooth(int times){
		String tiles2[][] = new String[width][height];
		
		for(int time = 0; time < times; time++){
			
			for(int x = 0; x < width; x++){
				
				for(int y = 0; y < height; y++){
					int floors = 0;
					int rocks = 0;
					
					for(int ox = -1; ox < 2; ox++){
						
						for(int oy = -1; oy < 2; oy++){
							
							if(x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height)
								continue;
							
							if(tiles[x + ox][y + oy] == Tile.FLOOR)
								floors ++;
							else
								rocks++;
						}
					}
					tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
				}
			}
			
			tiles = tiles2;
		}
		
		return this;
	}
	
	public LevelBuilder	makeCaves(){
		return randomizeTiles().smooth(2);
	}
}
