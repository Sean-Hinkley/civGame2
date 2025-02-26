package gameEnv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gameEnv.map.Map;
import gameEnv.units.Unit;

public class GameEnvironment extends Environment{
	private Unit selectedUnit;
	private int mapSize = 100;
	Camera cam;
	Map map;
	public GameEnvironment(int w, int h) {
		super(w,h);
		map = new Map(mapSize);
		cam = new Camera(w,h,128,map);
		selectedUnit = null;
		KeyMap();
	}
	public Map getMap() {
		return map;
	}
	public void KeyMap() {
		keys.addKey(87, "W");
		keys.addKey(65, "A");
		keys.addKey(83, "S");
		keys.addKey(68, "D");
	}
	public void actions(String phrase) {
		if(phrase.equals("W")) {
			System.out.println("W");
			cam.setPosY(cam.getPosY()-5);
		} 
		if(phrase.equals("A")) {
			System.out.println("A");
			cam.setPosX(cam.getPosX()-5);
		}
		if(phrase.equals("S")) {
			System.out.println("S");
			cam.setPosY(cam.getPosY()+5);
		}
		if(phrase.equals("D")) {
			System.out.println("D");
			cam.setPosX(cam.getPosX()+5);
		}
	}
	public void update() {
		keys.update(this);
	}
	public void draw(Graphics pen) {
		pen.setColor(Color.black);
		pen.fillRect(0, 0, getWidth(), getHeight());
		//map.draw(pen);
		cam.draw(pen);
		
	}
	public void keyTyped(KeyEvent ke) {}
	public void leftClick(MouseEvent ke) {
		int x = (ke.getX() - 8)/128;
		int y = (ke.getY() - 32)/128;
		if((x < map.size() && x > 0) && (y < map.size() && y > 0)) {
			Unit m = map.getTile(x, y).getUnit();
			if(m != null) {
				selectedUnit = m;
				m.setSelect(true);
			}
			else {
				if(selectedUnit != null) {
					selectedUnit.setSelect(false);
					selectedUnit = null;
				}
			}
		}
	}
	public void rightClick(MouseEvent ke) {
		int x = (ke.getX() - 8)/128;
		int y = (ke.getY() - 32)/128;
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		if(selectedUnit!= null) {
			int tx = selectedUnit.getTileX();
			int ty = selectedUnit.getTileY();
			System.out.println("TX: " + tx);
			System.out.println("TY: " + ty);
			boolean b = selectedUnit.moved(x, y);
			if(b) {
				map.getTile(tx, ty).addUnit(null);
				map.getTile(x, y).addUnit(selectedUnit);

			}	
		}
	}
    public void mouseClicked(MouseEvent ke) { 
    	if(ke.getButton() == 1) {
			leftClick(ke);
		}
		if(ke.getButton() == 3) {
			rightClick(ke);
		}	
    }
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
