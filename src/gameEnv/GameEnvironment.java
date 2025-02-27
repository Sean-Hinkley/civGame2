package gameEnv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gameEnv.map.Map;
import gameEnv.map.Tile;
import gameEnv.units.Unit;

public class GameEnvironment extends Environment{
	private Unit selectedUnit;
	private int mapSize = 100;
	Camera cam;
	Map map;
	private Ui ui;
	public GameEnvironment(int w, int h) {
		super(w,h);
		ui = new Ui(w, h,this);
		ui.setKeyPressList(keys);
		map = new Map(mapSize);
		cam = new Camera(w,h,128,map);
		selectedUnit = null;
		KeyMap();
	}
	public Map getMap() {
		return map;
	}

	public void setKeyPressList(KeyPressList kpl) {
		super.setKeyPressList(kpl);
		ui.setKeyPressList(kpl);
        
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
		cam.draw(pen);
		ui.draw(pen);
	}
	public void keyTyped(KeyEvent ke) {}
	public void leftClick(MouseEvent ke) {
		int x = ((ke.getX() - 8));
		int y = ((ke.getY() - 32));
		Tile m = cam.getTile(x, y);
		Unit n = null;
		if(m!=null) {
			n = m.getUnit(); 
			chkSelected(n);
		}
	}

	public void chkSelected(Unit m) {
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
	public void rightClick(MouseEvent ke) {
		int x = ((ke.getX() - 8));
		int y = ((ke.getY() - 32));
		if(selectedUnit!= null) {
			int tx = selectedUnit.getTileX();
			int ty = selectedUnit.getTileY();
			moveTiles(x, y, tx, ty);
		}
	}
	public Unit getSelected() {
		return selectedUnit;
	}
	public void moveTiles(int x, int y, int tx, int ty) {
		boolean b = selectedUnit.moved((x+cam.getOffsetX() + 150)/128, (y+cam.getOffsetY() + 75)/128);

		if(b) {
			Tile t1 = cam.getTile(x, y);
			Tile t2 = cam.getTileCoord(tx, ty);
			if(t1!=null && t2!=null) {
				System.out.print("Works");
				t2.addUnit(null);
				t1.addUnit(selectedUnit);
			}
			
		}
	}
	public void mousePressed(MouseEvent ke) {
		//System.out.println("Clicked");
    	if(ke.getButton() == 1) {
			leftClick(ke);
			//System.out.println("Left Clicked");
		}
		if(ke.getButton() == 3) {
			rightClick(ke);
		}
	}
    public void mouseClicked(MouseEvent ke) { 
			
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
