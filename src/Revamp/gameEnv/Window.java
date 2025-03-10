package Revamp.gameEnv;

import Revamp.renderWindow.MyGame;
import Revamp.renderWindow.renderItem.RenderObject;
import Revamp.renderWindow.renderItem.RenderObjectType;

public class Window extends MyGame{
    
    public Window() {
        super(new RenderObject(100, 100, 100, 100, RenderObjectType.circle , null));
    }

    public static void main(String[] args) {
        Window w = new Window();
        w.update();
    }
}
