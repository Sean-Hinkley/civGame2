package renderWindow;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
//import java.io.IOException;
//import java.util.ArrayList;
import java.awt.event.MouseWheelEvent;

import gameEnv.Client;



public class MyGame extends Game  {
    public static final String TITLE = "Platformer";
    public static final int SCREEN_WIDTH = 1700;
    public static final int SCREEN_HEIGHT = 900;
    
    Client game;
    public MyGame() {
    	game = new Client(SCREEN_WIDTH,SCREEN_HEIGHT);
    	
    }
    public void update() {
        
    	game.update();
    }
    public void draw(Graphics pen) {
    	game.draw(pen);
    }
    public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {
    	game.keyPressed(ke);
    }

    public void keyReleased(KeyEvent ke) {
    	game.keyReleased(ke);
    }
    public void mouseClicked(MouseEvent ke) { 
    	game.mouseClicked(ke);
    	
    }
    public void mousePressed(MouseEvent me) {game.mousePressed(me);}
    
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
    }
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

   public void MouseWheelListener(MouseWheelEvent me) {
    
   }
    //Launches the Game
    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        this.game.mouseWheelMoved(e);
    }    
}
