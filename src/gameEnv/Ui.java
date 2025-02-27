package gameEnv;

import java.awt.Color;
import java.awt.Graphics;

import gameEnv.GameEnvironment;

public class Ui extends Environment {
    private GameEnvironment game;
    public Ui(int w, int h, GameEnvironment g) {
        super(w,h);
        game = g;
    }
    public void draw(Graphics pen) {
        drawUnitUi(pen);
    }
    public void drawUnitUi(Graphics pen) {
        if(game.getSelected()!=null) {
            pen.setColor(Color.black);
            pen.fillRect(1100, 600, 500, 200);
        }
    }


    public class UnitUi extends Environment{
    
            public UnitUi(int w, int h) {
                super(w, h);
                
            }

            public void draw(Graphics pen) {
                
            }

    }
}
