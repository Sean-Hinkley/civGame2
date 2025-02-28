package gameEnv;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.MouseEvent;

import gameEnv.GameEnvironment;
import gameEnv.units.Unit;

public class Ui extends Environment {
    private GameEnvironment game;
    private UnitUi units;
    private TurnButton tb;
    private Resources res;
    public Ui(int w, int h, GameEnvironment g) {
        super(w,h);
        game = g;
        res = new Resources();
        units = new UnitUi(500, 200,game);
        tb = new TurnButton(200, 200,game);
    }
    public void draw(Graphics pen) {
        drawUnitUi(pen);
        tb.draw(pen);
        res.draw(pen);
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
                    drawTitle(pen);
                }
            }
            public void drawMoves(Graphics pen) {
                pen.setColor(Color.white);
                Unit move = game.getSelected();
                int moves = move.getMoves();
                int moved = move.getMoved();
                String put = "Moves:  " + (moves-moved) + "/" + moves;
                pen.setFont(new Font("Ariel", Font.BOLD, 20));
                pen.drawString(put, x+50, y+100);
            }

            public void drawTitle(Graphics pen) {
                String name = game.getSelected().getUnitName();
                pen.drawString(name, x+50, y+50);
            }
    }

    public class TurnButton extends Environment {
            int x;
            int y;
            GameEnvironment game;
            public TurnButton(int w, int h, GameEnvironment g) {
                super(w, h);
                this.x = 1500;
                this.y = 600;
                game = g;
            }

            public void draw(Graphics pen) {
                pen.setColor(new Color(0,70,150));
                pen.fillOval(x, y, getWidth(), getHeight());

                pen.setColor(Color.BLACK);
                pen.drawOval(x, y, getWidth(), getHeight());
            }

            public void collision(int x, int y) {
                if(x > this.x && x < this.x+getWidth() && y > this.y && y < this.y+getHeight()) {
                    System.out.println("Clicked");
                    game.nextTurn();
                }
            }
        
    }

    public class Resources extends Environment {
            int x;
            int y;
            public Resources() {
                super(1600, 25);
                x = 0;
                y = 0;
            }

            public void draw(Graphics pen) {
                pen.setColor(new Color(0,70,120));
                pen.fillRect(x, y, getWidth(), getHeight());
                pen.setColor(Color.BLACK);
                pen.fillRoundRect(x+100, y, 50, 25, 20, 25);
                pen.setColor(new Color(0,70,255));
                pen.fillOval(x+100, y, 25, 25);
                String put = "+" ;
                pen.setColor(Color.white);
                pen.setFont(new Font("Ariel", Font.BOLD, 20));
                pen.drawString(put, x+125, y+20);

            }
        
    }

    public void mousePressed(MouseEvent ke) {
		
    	if(ke.getButton()==1) {
            tb.collision(ke.getX(), ke.getY());
        }
	}
}
