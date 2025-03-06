package gameEnv;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyPressList {
	public ArrayList<Key> keys;
	private Environment game;
	public KeyPressList(Environment g) {
		keys = new ArrayList<Key>();
		game = g;
	}
	
	public void addKey(int code, String phrs) {
		
		keys.add(new Key(code,phrs));
	}
	
	
	public void keyPressed(KeyEvent ke) {
		for(int k = 0; k < keys.size(); k++) {
			keys.get(k).keyPressed(ke.getKeyCode());
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		for(int k = 0; k < keys.size(); k++) {
			keys.get(k).keyReleased(ke.getKeyCode());
			
		}
	}
	
	public void update(Environment env) {
		for(int k = 0; k < keys.size(); k++) {
			String n = keys.get(k).getAccess();
			if(n != null) {
			 env.actions(n);
			}
		}
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
		
		public void keyPressed(int code) {
			if(code == keyCode) {
				state = true;
			}
			
		}
		
		public void keyReleased(int code) {
			if(code == keyCode) {
				
				state = false;
			}
		}
		
		public String getAccess() {
			if(state) {
				return phrase;
			}
			else {
				return null;
			}
		}
		
		
		
		
	}
}
