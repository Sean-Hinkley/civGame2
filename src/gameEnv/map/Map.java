package gameEnv.map;
import java.awt.Color;
import java.awt.Graphics;

import gameEnv.ImgHandler;
import gameEnv.Leader.Builds.Town;
import gameEnv.Leader.Units.Unit;
import renderWindow.RenderItem;
public class Map extends RenderItem{
	double scale = 1.0;
	private Tile[][] map;
	private ImgHandler imgs;
	private int tilesize = 128;
	public Map(int size) {
		super("Map",0,0);
		imgs = new ImgHandler();
		
		
		map = new Tile[25][25];
		fillTiles();
	}
	public void fillTiles() {
		
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				map[x][y] = new Tile(x,y,TileBiome.water,imgs);
			}
		}

		setTiles();
	}

	public void setTiles() {
		int startx = (int)(map.length/2);
		int starty = (int)(map[0].length/2);
		int[] weights = {100,100,50,100};
		setTile(startx, starty,startx,starty,weights);
	}	

	public void setTile(int x, int y, int startx, int starty, int[] weights) {
		TileBiome randTile = rng(weights);
		int sum = (Math.abs(startx-x))+(Math.abs(starty-y));
		System.out.println(sum);
		weights[2] = sum*15;

		if(x > 0 && x < map.length && y > 0 && y < map[0].length) {
			if(map[x][y].getSet() == false) {
				map[x][y].setSet(true);
				map[x][y].setBiome(randTile);
				setTile(x+1, y, startx,starty, weights);
				setTile(x-1, y, startx,starty, weights);
				setTile(x, y+1, startx,starty, weights);
				setTile(x, y-1, startx,starty, weights);
			}
		}
		
	}

	public void setScale(double s) {
		scale = s;
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[0].length; y++) {
				if(map[x][y]!=null) map[x][y].setScale(s);
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
	public int getsizeScale() {
		return (int)(tilesize*scale);
	}
	public void drawBody(Graphics pen) {
		pen.setColor(Color.red);
		pen.fillRect(getPosX(), getPosY(),  getsizeScale()*map.length, getsizeScale()*map[0].length);
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
				if((f+x>0 && s+y>0)  && (f+x < map.length && s+y < map[0].length)) {
					tiles[f][s] = map[f+x][s+y];
					
				} else {
					tiles[f][s] = null;
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
		int leftoverx = (x%getsizeScale())+150;
		int leftovery = (y%getsizeScale())+125;
		int tmpx = x/getsizeScale();
		int tmpy = y/getsizeScale();
		Tile[][] tmplist = new Tile[(int)(w/getsizeScale())][(int)(h/getsizeScale())];
		getSection(tmpx, tmpy, tmplist);
		for(int dx = 0; dx < tmplist.length; dx++) {
			for(int dy = 0; dy < tmplist[0].length; dy++) {
				if(tmplist[dx][dy]!=null) {
					tmplist[dx][dy].drawBody(pen, (dx*getsizeScale())-leftoverx, (dy*getsizeScale())-leftovery);
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
