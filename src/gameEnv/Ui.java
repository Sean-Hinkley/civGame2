package gameEnv;

import java.awt.Color;
import java.awt.Font;
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
            int x,y;
            public UnitUi(int w, int h, GameEnvironment g) {
                super(w, h);
                game = g;
                x = 1100;
                y = 600;
            }

            public void draw(Graphics pen) {
                if(game.getSelected()!=null) {

                    pen.setColor(new Color(0,70,120));
                    pen.fillRect(x, y, 500, 200);
                    drawMoves(pen);
                }
            }

            public void drawMoves(Graphics pen) {
                pen.setColor(Color.white);
                int moves = game.getSelected().getMoves();
                String put = "Moves:  " + moves;
                String name = game.getSelected().getUnitName();
                pen.setFont(new Font("Ariel", Font.BOLD, 20));
                pen.drawString(name, x+50, y+50);
                pen.drawString(put, x+50, y+100);
            }

    }
}
