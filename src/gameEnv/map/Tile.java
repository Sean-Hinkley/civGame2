package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;

import renderWindow.RenderItem;

public class Tile extends RenderItem{
	private double production;
	private double food;
	private double science;
	private double faith;
	private double gold;
	private double culture;
	
	private int size = 50;
	private int scale = 1;
	
	public Tile(int x, int y) {
		//x and y are measured in array placement
		super("Tile",x,y);
		this.setPosX(getPosX() * size);
		this.setPosY(getPosY() * size);
		this.setObjW(size * scale);
		this.setObjH(size * scale);
	}
	
	public void drawBody(Graphics pen) {
		
		this.setObjW(size * scale);
		this.setObjH(size * scale);
		pen.setColor(Color.green);
		pen.fillRect(this.getPosX(),this.getPosY() , this.getObjW(), this.getObjH());
		pen.setColor(Color.black);
		pen.drawRect(this.getPosX(),this.getPosY() , this.getObjW(), this.getObjH());
		
	}
	

}
