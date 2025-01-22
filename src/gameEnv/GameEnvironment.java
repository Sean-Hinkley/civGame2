package gameEnv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gameEnv.map.Map;
//import gameEnv.map.Tile;

public class GameEnvironment {
	//private double gold;
	//private double science;
	//private double culture;
	//private double faith;
	
	private int width;
	private int height;
	
	private int mapSize = 25;
	
	private KeyPressList keys;
	Camera cam;
	Map map;
	public GameEnvironment(int w, int h) {
		width = w;
		height = h;
		map = new Map(mapSize);
		cam = new Camera(w,h,12,map);
		keys = new KeyPressList(this);
		KeyMap();
	}
	
	public void KeyMap() {
		keys.addKey(87, "W");
		keys.addKey(65, "A");
		keys.addKey(83, "S");
		keys.addKey(68, "D");
	}
	
	public void actions(String phrase) {
		if(phrase.equals("W")) {
			cam.setPosY(cam.getPosY()-15);
		} 
		if(phrase.equals("A")) {
			cam.setPosX(cam.getPosX()-15);
		}
		if(phrase.equals("S")) {
			cam.setPosY(cam.getPosY()+15);
		}
		if(phrase.equals("D")) {
			cam.setPosX(cam.getPosX()+15);
		}
	}
	
	
	public void draw(Graphics pen) {
		pen.setColor(Color.black);
		pen.fillRect(0, 0, width, height);
		//map.draw(pen);
		cam.draw(pen);
		
	}
	
	public void update() {
		keys.update();
	}
	
	
	
	
	public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {
    	this.keys.keyPressed(ke);
    }

    public void keyReleased(KeyEvent ke) {
    	this.keys.keyReleased(ke);
    }

    public void mouseClicked(MouseEvent ke) { 
    	
    	
    }

    public void mousePressed(MouseEvent me) {
    	
    	
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
