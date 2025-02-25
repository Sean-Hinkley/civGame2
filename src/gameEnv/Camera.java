package gameEnv;

import java.awt.Graphics;

import gameEnv.map.Map;
import gameEnv.map.Tile;
import renderWindow.RenderItem;

public class Camera extends RenderItem {
	private int ScreenWidth;
	private int ScreenHeight;
	private int tilesize;
	private int Scale;
	private Map map;
	
	public Camera(int w, int h, int size, Map m) {
		super("Camera",350,250);
		ScreenWidth = w + 100;
		ScreenHeight = h + 100;
		tilesize = size;
		Scale = 1;
		map = m;
	}
	
	
	
	public void drawBody(Graphics pen) {
		Tile[][] mp = getView();
		int tmpscl = Scale * tilesize;
		for(int x = 0; x < mp.length; x++) {
			for(int y = 0; y < mp[0].length; y++) {
				if(mp[x][y]!=null) {
					mp[x][y].drawBody(pen, x * tmpscl, y * tmpscl);
				}
				
			}
		}
	}
	
	public Tile[][] getView() {
		int tmpW = (int) (ScreenWidth / (tilesize * Scale));
		int tmpH = (int) (ScreenHeight / (tilesize * Scale));

		int tmpX = (int) (getPosX() / (tilesize * Scale));
		int tmpY = (int) (getPosY() / (tilesize * Scale));
		System.out.println("X: " + tmpX + "  Y: " + tmpY);
		int strtX = (int) (tmpX - (tmpW / 2));
		int strtY = (int) (tmpY - (tmpH / 2));

		Tile mp[][] = new Tile[tmpW][tmpH];
		
		mp = map.getSection(strtX, strtY, tmpW, tmpH);
		
		return mp;
	}
}
