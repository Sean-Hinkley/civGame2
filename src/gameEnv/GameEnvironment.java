package gameEnv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gameEnv.Leader.Leader;
import gameEnv.Leader.Units.Unit;
import gameEnv.map.Map;
import gameEnv.map.Tile;

public class GameEnvironment extends Environment{
	private Unit selectedUnit;
	private int mapSize = 100;
	Camera cam;
	Map map;
	private Ui ui;
	Leader leader;
	ImgHandler img;
	public GameEnvironment(int w, int h) {
		super(w,h);
		img = new ImgHandler();
		leader = new Leader("Base",map);
		ui = new Ui(w, h,this);
		ui.setKeyPressList(keys);
		map = new Map(mapSize);
		leader = new Leader("Base",map);
		cam = new Camera(w,h,128,map);
		selectedUnit = null;
		//leader.addUnit(new Unit("Settler", leader, 2, 2, 4), 2,2);
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
			cam.setPosY(cam.getPosY()-5);
		} 
		if(phrase.equals("A")) {
			cam.setPosX(cam.getPosX()-5);
		}
		if(phrase.equals("S")) {
			cam.setPosY(cam.getPosY()+5);
		}
		if(phrase.equals("D")) {
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
		if(m!=null) {
			chkSelected(m);
		}
	}

	public Camera getCamera() {
		return cam;
	}

	public void chkSelected(Tile m) {
		if(m != null && m.getUnit()!=null) {
			if(selectedUnit!=null) {
				selectedUnit.setSelect(false);
				selectedUnit = null;
			}
			
			selectedUnit = m.getUnit();
			selectedUnit.setSelect(true);
			
		} else if (m!=null && selectedUnit!=null) {
			selectedUnit.setSelect(false);
			selectedUnit = null;
		}
	}
	public void rightClick(MouseEvent ke) {
		int x = ke.getX()-8;
		int y = ke.getY()-32;
		if(selectedUnit!= null) {
			int tx= selectedUnit.getPosX();
			int ty = selectedUnit.getPosY();
			Tile f = cam.getActualTile(x,y);
			if(f!=null) moveTiles(f.getPosX(),f.getPosY() , tx, ty );
			
		}
	}
	public Unit getSelected() {
		return selectedUnit;
	}
	public void moveTiles(int x, int y, int tx, int ty) {
		boolean b = selectedUnit.moved(x, y);
		if(b) {
			//selectedUnit.move(x, y);
			map.removeUnit(tx, ty);
			map.addUnit(selectedUnit, x, y);
		}
	}
	public void mousePressed(MouseEvent ke) {
		ui.mousePressed(ke);
    	if(ke.getButton() == 1) {
			leftClick(ke);
		}
		if(ke.getButton() == 3) {
			rightClick(ke);
		}
	}
    public void mouseClicked(MouseEvent ke) {}
	public void nextTurn() {
		map.nextTurn();
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

	public Leader getLeader() {
		return leader;
	}
}
