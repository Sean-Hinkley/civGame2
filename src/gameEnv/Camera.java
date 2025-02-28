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
	}	
	public Tile[][] getView() {
		int tmpscl = Scale * tilesize;
		int tmpW = ScreenWidth/tmpscl +2;
		//System.out.println("TMP W: " + tmpW);
		int tmpH = ScreenHeight/tmpscl +2;
		//System.out.println("TMP H: " + tmpH);
		Tile[][] mp = new Tile[tmpW][tmpH];
		int tmpX = this.getPosX()/tmpscl;
		int tmpY = this.getPosY()/tmpscl;
		map.getSection(tmpX-1, tmpY-1, mp);
		//System.out.println(mp[0][0]);
		return mp;
	}
	public Tile getTile(int x, int y) {
		int ttx = ((x)+getOffsetX()+150);
		int tty = ((y)+getOffsetY()+125);
		int tx = (ttx/128);
		int ty = (tty/128);
		return getTileCoord(tx, ty);
	}
	public Tile getTileCoord(int x, int y) {
		Tile[][] tiles = getView();
		if((x+1 < tiles.length && x+1 > 0) && (y+1 < tiles[0].length && y+1 > 0)) {
			//System.out.println("Tile: " + tiles[x+1][y+1]);
			if(tiles[x+1][y+1]!=null)
			{
				//System.out.println("TileSelected\n\n");
				//System.out.println(tiles[x][y]);
				return tiles[x+1][y+1];
			}
		}
		return null;
	}
	public int getOffsetX() {
		int leftoverx = getPosX()%128;
		return leftoverx;
	}
	public int getOffsetY() {
		int leftovery = getPosY()%128;
		return leftovery;
	}
	public Tile getActualTile(int x, int y) {
		int tx = (x+getOffsetX()+150)/128;
		int ty = (y+getOffsetY()+125)/128;
		Tile[][] view = getView();
		if(tx>0 && tx<view.length && ty>0 && ty<view[0].length && view[tx][ty]!=null) {
			return getTileCoord(tx, ty);
		}
		return null;
	}
}
