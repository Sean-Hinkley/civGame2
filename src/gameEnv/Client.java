package gameEnv;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gameEnv.Leader.Leader;
import renderWindow.Game;

public class Client extends Environment{
    Environment[] allEnvironments;
    Environment loading;
    Camera cam;
    
    public Client(int w, int h) {
        super(w,h);
        allEnvironments = new Environment[3];
        allEnvironments[0] = new GameEnvironment(w, h);
        GameEnvironment g = ((GameEnvironment)allEnvironments[0]);
        cam = g.getCamera();
        loading = allEnvironments[0];
        loading.setKeyPressList(keys);
        
    }
	public void draw(Graphics pen) {
        if(loading!=null) loading.draw(pen);	
	}
	public void update() {
        keys.update(this);   
        if(loading!=null) loading.update();
	}
	public void keyTyped(KeyEvent ke) {}
	public void leftClick(MouseEvent ke) {}
	public void rightClick(MouseEvent ke) {}
    public void mouseClicked(MouseEvent ke) { 
        
    }
    public void mousePressed(MouseEvent me) {
        loading.mousePressed(me);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        cam.mouseWheelMoved(e);
    } 

}
