package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

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
		for(int dx = x; dx < dx + w; dx++) {
			for(int dy = y; dy < y + h; dy++) {
				int ddx = dx-x;
				int ddy = dy-y;
				if(!(ddx > 0 && ddx < map.length) && (ddy > 0 && ddy < map[0].length)) {
					System.out.println(true);
					mp[ddx][ddy] = map[dx][dy];
				}
				
			}
		}
		return mp;
	}
	
}
