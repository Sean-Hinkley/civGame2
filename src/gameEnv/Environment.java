package gameEnv;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Environment {
    private int width;
    private int height;
    KeyPressList keys;
	public Environment(int w, int h) {
		width = w;
		height = h;
        keys = new KeyPressList(this);
	}
	
	public void KeyMap() {

	}
	
	public void actions(String phrase) {

	}
	
	
	public void draw(Graphics pen) {

	}
	
	public void update() {
        keys.update(this);
	}

    public int getWidth() {
        return width;
    }
	public int getHeight() {
        return height;
    }
	
	
	
	public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {
        //System.out.println("HeLLo");
    	this.keys.keyPressed(ke);
    }

    public void keyReleased(KeyEvent ke) {
    	this.keys.keyReleased(ke);
    }

    public void setKeyPressList(KeyPressList kpl) {
        keys = kpl;
        KeyMap();
    }
	public void leftClick(MouseEvent ke) {

	}

	public void rightClick(MouseEvent ke) {

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