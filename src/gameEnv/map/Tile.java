package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameEnv.ImgHandler;
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
	private ImgHandler imagehandler;
	public Tile(int x, int y, int type, ImgHandler imgh) {
		//x and y are measured in array placement
		super("Tile",x,y);
		town = null;
		remUnit();
		biome = findtype(type);
		this.setObjW(size * scale);
		this.setObjH(size * scale);	
		imagehandler = imgh;
	}

	

	public Tile(int x, int y, TileBiome type, ImgHandler imgh) {
		//x and y are measured in array placement
		super("Tile",x,y);
		remUnit();
		biome = type;
		this.setObjW(size * scale);
		this.setObjH(size * scale);		
		imagehandler = imgh;
		image = setImg(type);
	}

	public Town getTown() {
		return town;
	}

	public BufferedImage setImg(TileBiome tb) {
		BufferedImage ret = null;
		if(tb == TileBiome.plains) {
			ret = imagehandler.getImg(imagehandler.chkImg(title, "C:\\Users\\seang\\Desktop\\civGame2\\src\\gameEnv\\map\\Imgs\\Grass.png"));
		}
		if(tb == TileBiome.woods) {
			ret = imagehandler.getImg(imagehandler.chkImg(title, "C:\\Users\\seang\\Desktop\\civGame2\\src\\gameEnv\\map\\Imgs\\Woods.png"));
		}

		if(tb == TileBiome.sand) {
			ret = imagehandler.getImg(imagehandler.chkImg(title, "C:\\Users\\seang\\Desktop\\civGame2\\src\\gameEnv\\map\\Imgs\\Sand.png"));
		}
		if(tb == TileBiome.water) {
			ret = imagehandler.getImg(imagehandler.chkImg(title, "C:\\Users\\seang\\Desktop\\civGame2\\src\\gameEnv\\map\\Imgs\\Water.png"));
		}


		return ret;
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
		pen.drawImage(image, x, y, null);
		
			
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
