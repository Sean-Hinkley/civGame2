package gameEnv.map;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.geom.AffineTransform;
//import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;

import renderWindow.RenderItem;

public class Tile extends RenderItem{
	//private double production;
	//private double food;
	//private double science;
	//private double faith;
	//private double gold;
	//private double culture;
	private BufferedImage image;
	private int size = 128;
	private int scale = 1;
	private TileBiome biome;
	public Tile(int x, int y, int type, BufferedImage im) {
		//x and y are measured in array placement
		super("Tile",x,y);
		biome = findtype(type);
		this.setPosX(getPosX() * size);
		this.setPosY(getPosY() * size);
		this.setObjW(size * scale);
		this.setObjH(size * scale);
		/*try {
			image = ImageIO.read(new File("C:\\Users\\se.g.hinkley\\Downloads\\CivGame\\src\\gameEnv\\map\\Imgs\\Plains-Copy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		image = im;
		
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
		}
		
		return tmp;
	}
	
	public void drawBody(Graphics pen) {
		drawBody(pen,getPosX(),getPosY());
	}
	
	public void drawBody(Graphics pen, int x, int y) {
		this.setObjW(size * scale);
		this.setObjH(size * scale);
		drawTile(pen);
		pen.setColor(Color.black);
		pen.drawRect(this.getObjW() * x, this.getObjH()* y, this.getObjW(), this.getObjH());
	}
	
	public void drawTile(Graphics pen) {
		if(biome == TileBiome.plains) {
			pen.setColor(Color.green);
		}
		if(biome == TileBiome.woods) {
			pen.setColor(new Color(0,200,0));
		}
		if(biome == TileBiome.water) {
			pen.setColor(new Color(0,0,200));
		}
		pen.drawImage(image,this.getPosX(),this.getPosY()-32,null);
		
	}
	

}
