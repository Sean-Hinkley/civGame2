package gameEnv;

import java.awt.Color;
import java.awt.Graphics;

import gameEnv.GameEnvironment;

public class Ui extends Environment {
    private GameEnvironment game;
    private UnitUi units;
    public Ui(int w, int h, GameEnvironment g) {
        super(w,h);
        game = g;
        units = new UnitUi(500, 200,game);

    }
    public void draw(Graphics pen) {
        drawUnitUi(pen);
    }
    public void drawUnitUi(Graphics pen) { 
        units.draw(pen);
    }


    public class UnitUi extends Environment{
            GameEnvironment game;
            public UnitUi(int w, int h, GameEnvironment g) {
                super(w, h);
                game = g;
                
            }

            public void draw(Graphics pen) {
                if(game.getSelected()!=null) {
                    pen.setColor(Color.black);
                    pen.fillRect(1100, 600, 500, 200);
                }
            }

    }
}
