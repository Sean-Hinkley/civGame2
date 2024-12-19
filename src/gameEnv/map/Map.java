package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import renderWindow.RenderItem;

public class Map extends RenderItem{
	
	private Tile[][] map;
	public Map(int size) {
		super("Map",0,0);
		
		map = new Tile[size][size];
		setTiles();
	}
	
	public void setTiles() {
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				map[x][y] = new Tile(x,y,1);
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
	
}
