package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameEnv.Leader.Builds.Town;
import gameEnv.Leader.Units.Unit;
import renderWindow.RenderItem;

public class Tile extends RenderItem{
	private Unit onTile;
	private Town town;
	private BufferedImage image;
	private int size = 128;
	private int scale = 1;
	private TileBiome biome;
	public Tile(int x, int y, int type, BufferedImage im) {
		//x and y are measured in array placement
		super("Tile",x,y);
		town = null;
		remUnit();
		biome = findtype(type);
		this.setObjW(size * scale);
		this.setObjH(size * scale);	
		image = im;
	}

	

	public Tile(int x, int y, TileBiome type, BufferedImage im) {
		//x and y are measured in array placement
		super("Tile",x,y);
		remUnit();
		biome = type;
		this.setObjW(size * scale);
		this.setObjH(size * scale);		
		image = im;	
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town t) {
		town = t;
	}

	public void remTown() {
		town = null;
	}
	public Unit getUnit() {
		//if(this.onTile!=null) System.out.println("X: " + getPosX() + "; Y: " + getPosY() + this.onTile);
		return this.onTile;
	}
	public void addUnit(Unit u) {
		this.onTile = u;
	}

	public void remUnit() {
		this.onTile = null;
		//System.out.println(this.onTile);
	}
	public TileBiome findtype(int t) {
		TileBiome tmp = null;
		switch(t) {
		case 0:
			tmp = TileBiome.plains;
			break;
		case 1:
			tmp = TileBiome.woods;
			break;
		case 2:
			tmp = TileBiome.water;
			break;
		case 3:
			tmp = TileBiome.sand;
			break;
		} 
		return tmp;
	}
	public void drawBody(Graphics pen) {
		drawBody(pen,getPosX(),getPosY());
	}
	public void drawBody(Graphics pen, int x, int y) {
		this.setObjW(size * scale);
		this.setObjH(size * scale);
		drawTile(pen, x, y);
		pen.setColor(Color.black);
		pen.drawRect(x, y, this.getObjW(), this.getObjH());
		if(getUnit() != null) {
			//System.out.println("X: " + getPosX() + "; Y: " + getPosY() + " OnTile: " + getUnit());
			onTile.draw(pen, x, y);
		}

		if(getTown()!=null) {
			town.draw(pen,x,y);
		}
	}
	public void drawTile(Graphics pen, int x, int y) {
		this.setObjW(size * scale);
		this.setObjH(size * scale);
		if(biome == TileBiome.plains) {
			pen.drawImage(image, x, y, null);
		}
		if(biome == TileBiome.woods) {
			pen.setColor(new Color(0,200,0));
			pen.fillRect(x, y, getObjW(), getObjH());
		}
		if(biome == TileBiome.water) {
			pen.setColor(new Color(0,0,200));
			pen.fillRect(x, y, getObjW(), getObjH());
		}
		if(biome == TileBiome.sand) {
			pen.setColor(new Color(200,200,0));
			pen.fillRect(x, y, getObjW(), getObjH());
		}
		
			
	}
	
	public void nextTurn() {
		if(onTile!=null) {
			onTile.nextTurn();
		}
	}
	public String toString() {
		String res = "Unit:  " + getUnit() + ";  X: " + this.getPosX() + ";  Y: " + this.getPosY();
		return res;
	}

}
