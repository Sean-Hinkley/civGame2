package gameEnv;

import java.awt.event.KeyEvent;

public class KeyPressList {
	public Key key;
	private GameEnvironment game;
	public KeyPressList(GameEnvironment g) {
		key = new Key(87, "W");
		game = g;
	}
	
	
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyCode() == 87) {
			key.keyPressed();
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		
	}
	
	public class Key {
		private boolean state;
		private int keyCode;
		private String phrase;
		
		public Key(int code, String phrs) {
			keyCode = code;
			phrase = phrs;
			state = false;
		}
		
		public void keyPressed() {
			System.out.println("Pressed");
		}
		
		public void keyReleased() {
			
		}
		
		
		
		
	}
}
