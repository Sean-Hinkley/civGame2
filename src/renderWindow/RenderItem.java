package renderWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
public class RenderItem {
	private int PosX;
	private int PosY;
	private int ObjW;
	private int ObjH;
	public String title;
	public RenderItem(String tit, int x, int y, int w, int h) {
		setupObject(tit,x,y,w,h);
	}
	public RenderItem(String tit, int x, int y) {
		setupObject(tit,x,y);
	}
	public RenderItem(String tit, int x, int y, int s) {
		setupObject(tit,x,y,s);
	}
	public void setupObject(String tit, int x, int y, int w, int h) {
		title = tit;
		PosX = x;
		PosY = y;
		ObjW = w;
		ObjH = h;
	}
	public void setupObject(String tit, int x, int y, int s) {
		setupObject(tit,x,y,s,s);
	}
	public void setupObject(String tit, int x, int y) {
		setupObject(tit,x,y,0);
	}
	public void update() {}
	public void draw(Graphics pen) {
		drawBody(pen);
	}
	public void drawBody(Graphics pen, int x, int y) {
		pen.setColor(Color.white);
		pen.fillRect(x, y, ObjW, ObjH);
	}
	public void drawBody(Graphics pen) {
		drawBody(pen,PosX,PosY);
	}
	public int getPosX() {
		return PosX;
	}
	public void setPosX(int x) {
		PosX = x;
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int y) {
		PosY = y;
	}
	public int getObjW() {
		return ObjW;
	}
	public void setObjW(int w) {
		ObjW = w;
	}
	public int getObjH() {
		return ObjH;
	}
	public void setObjH(int h) {
		ObjH = h;
	}
	public void keyTyped(KeyEvent ke) {}
    public void keyPressed(KeyEvent ke) {
    	
    }
    public void keyReleased(KeyEvent ke) {}
    public void mouseClicked(MouseEvent ke) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}    
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
