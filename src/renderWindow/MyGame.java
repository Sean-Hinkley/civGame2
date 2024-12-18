package renderWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import gameEnv.GameEnvironment;



public class MyGame extends Game  {
    public static final String TITLE = "Platformer";
    public static final int SCREEN_WIDTH = 1700;
    public static final int SCREEN_HEIGHT = 900;
    
    GameEnvironment game;
    public MyGame() {
    	game = new GameEnvironment(this.SCREEN_WIDTH,this.SCREEN_HEIGHT);
    	
    }
    
    public void update() {
    }
    
    public void draw(Graphics pen) {
    	game.draw(pen);
    }
    
    
        
    public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {
    	game.keyPressed(ke);
    }

    public void keyReleased(KeyEvent ke) {}

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
        
    //Launches the Game
    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }

	
    
    
    
    
}
