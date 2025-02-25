package gameEnv.map;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
//import java.io.IOException;

import gameEnv.ImgHandler;
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
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				map[x][y] = new Tile(x,y,1,imgs.getImg(0));
			}
		}
	}
	
	public void drawBody(Graphics pen) {
		//pen.setColor(Color.red);
		//pen.fillRect(getPosX(), getPosY(), 128 *map.length, 128*map.length);
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
	
	public Tile[][] getSection(int x, int y, int w, int h) {
		Tile[][] mp = new Tile[w][h];
		//System.out.println("W: " + w + "  H: " + h);
		for(int sx = 0; sx < w; sx++) {
			for(int sy = 0; sy < h; sy++) {
				if((sx+x < map.length && sy+y < map.length) && (sy+y > 0 && sx+x > 0)) {
					mp[sx][sy] = map[sx+x][sy+y];
				}
			}
		}
		return mp;
	}
	
}
