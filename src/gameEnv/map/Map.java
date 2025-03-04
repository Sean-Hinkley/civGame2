package gameEnv.map;
import java.awt.Color;
import java.awt.Graphics;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gameEnv.ImgHandler;
import gameEnv.Leader.Builds.Town;
import gameEnv.Leader.Units.Unit;
import renderWindow.RenderItem;
public class Map extends RenderItem{
	private Tile[][] map;
	private ImgHandler imgs;
	public Map(int size) {
		super("Map",0,0);
		imgs = new ImgHandler();
		
		
		map = new Tile[size][size];
		setTiles();
	}
	public void setTiles() {
		int[] weights = {100,70,20,30};
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				TileBiome randTile = rng(weights);
				map[x][y] = new Tile(x,y,randTile,imgs);
			}
		}
	}
	public TileBiome rng(int[] weights) {
		int sum = 0;
		int[] tmpweights = new int[weights.length]; 
		for(int x = 0; x < weights.length; x++) {
			sum+=weights[x]; 
			tmpweights[x] = weights[x];
		}
		TileBiome[] tiles = new TileBiome[sum];
		int ind = 0;
		for(int x = 0; x < weights[0]; x++) {
			tiles[x] = TileBiome.plains;
			ind++;
		}
		for(int x = 0; x < weights[1]; x++) {
			tiles[ind] = TileBiome.woods;
			ind++;
		}
		for(int x = 0; x < weights[2]; x++) {
			tiles[ind] = TileBiome.water;
			ind++;
		}
		for(int x = 0; x < weights[3]; x++) {
			tiles[ind] = TileBiome.sand;
			ind++;
		}
		int rand = (int)(Math.random()*sum);
		return tiles[rand];
	}
	public void drawBody(Graphics pen) {
		pen.setColor(Color.red);
		pen.fillRect(getPosX(), getPosY(), 128 *map.length, 128*map[0].length);
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				map[x][y].draw(pen);
			}
		}
	}
	public void shiftTiles(int xDif, int yDif) {
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				map[x][y].setPosX(map[x][y].getPosX()+xDif);
				map[x][y].setPosY(map[x][y].getPosY()+yDif);
			}
		}
	}
	public void getSection(int x, int y, Tile[][] tiles) {
		for(int f = 0; f < tiles.length; f++) {
			for(int s = 0; s < tiles[0].length; s++) {
				if((f+x<0 || s+y<0)  || (f+x > map.length || s+y > map[0].length)) {
					tiles[f][s] = null;
				} else {
					tiles[f][s] = map[f+x][s+y];
				}
				
			}

		}
	}
	public int size() {
		return map.length;
	}
	public int size(int ind) {
		return map[ind].length;
	}
	public Tile getTile(int x, int y) {
		if((x < map.length && x > 0) && (y < map[0].length && y > 0)) {
			return map[x][y];
		}
		return null;
	}
	public void drawColliding(Graphics pen, int x, int y, int w, int h) {
		int leftoverx = (x%128)+150;
		int leftovery = (y%128)+125;
		int tmpx = x/128;
		int tmpy = y/128;
		Tile[][] tmplist = new Tile[w/128][h/128];
		getSection(tmpx, tmpy, tmplist);
		for(int dx = 0; dx < tmplist.length; dx++) {
			for(int dy = 0; dy < tmplist[0].length; dy++) {
				if(tmplist[dx][dy]!=null) {
					tmplist[dx][dy].drawBody(pen, (dx*128)-leftoverx, (dy*128)-leftovery);
				}
				
			}
		}
	}

	public void nextTurn() {
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[0].length; y++) {
				map[x][y].nextTurn();
			}
		}
	}
	public void addUnit(Unit u, int x, int y) {
		if((x < map.length && x > 0) && (y < map[0].length && y > 0)) {
			Tile t = getTile(x, y);
			if(t.getUnit()==null)t.addUnit(u);
		}
	}

	public void removeUnit(int x, int y) {
		Tile t = getTile(x, y);
		if(t.getUnit()!=null) t.remUnit();
	}

	public void addTown(Town t,int x, int y) {
		Tile f = getTile(x, y);
		f.setTown(t);
	}

	public void removeTown(int x, int y) {
		Tile t = getTile(x, y);
		if(t.getTown()!=null) t.remTown();
	}
}
