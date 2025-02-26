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
		super("Camera",0,0,w+300,h+150);
		ScreenWidth = w;
		ScreenHeight = h;
		tilesize = size;
		Scale = 1;
		map = m;
	}
	
	
	
	public void drawBody(Graphics pen) {
		map.drawColliding(pen, getPosX(), getPosY(), getObjW(),getObjH());
		
		// Tile[][] mp = getView();
		// //System.out.println(mp[0][0]);
		// int tmpscl = Scale * tilesize;
		// for(int x = 0; x < mp.length; x++) {
		// 	for(int y = 0; y < mp[0].length; y++) {
		// 		if(mp[x][y]!=null) {
		// 			int getx = (x * tmpscl) + (this.getPosX()%tmpscl);
		// 			int gety = (y * tmpscl) + (this.getPosY()%tmpscl);
		// 			System.out.println("X: " +getx + "  Y: " + gety);
		// 			mp[x][y].drawBody(pen, getx, gety);
		// 		} else {
		// 			//System.out.println("Didnt Work");
		// 		}
				
		// 	}
		// }
	}
	
	public Tile[][] getView() {
		int tmpscl = Scale * tilesize;
		int tmpW = ScreenWidth/tmpscl +2;
		System.out.println("TMP W: " + tmpW);
		int tmpH = ScreenHeight/tmpscl +2;
		System.out.println("TMP H: " + tmpH);
		Tile[][] mp = new Tile[tmpW][tmpH];
		
		int tmpX = this.getPosX()/tmpscl;
		int tmpY = this.getPosY()/tmpscl;

		map.getSection(tmpX-1, tmpY-1, mp);
		//System.out.println(mp[0][0]);
		return mp;
	}
}
