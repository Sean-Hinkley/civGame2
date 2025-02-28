package gameEnv.units;

import java.awt.Color;
import java.awt.Graphics;

import renderWindow.RenderItem;

public class Unit extends RenderItem{
    private boolean selected;
    private int x;
    private int y;
    private int moves;
    private int moved;
    String unitName;
    public Unit(String name, int x, int y, int moves) {
        super("Unit", x, y);
        unitName = name;
        moved = 0;
        this.moves = moves;
        selected = false;
    }

    public boolean moved(int x, int y) {
        int tx = Math.abs(getPosX()-x);
        int ty = Math.abs(getPosY()-y);
        int sum = tx+ty;
        if(sum<=moves-moved) {
            moved+=sum;
            move(x,y);
            return true;
        }
        return false;
        
    }

    public void nextTurn() {
        moved = 0;
    }

    public void move(int x, int y) {
        setPosX(x);
        setPosY(y);
    }

    public String getUnitName() {
        return unitName;
    }

    public void setSelect(boolean b) {
        selected = b;
    }
    public int getMoves() {
        return moves;
    }

    public int getMoved() {
        return moved;
    }

    public void draw(Graphics pen, int x, int y) {
        pen.setColor(Color.red);
        pen.fillOval(x, y, 64, 64);
        if(selected) {
            pen.setColor(Color.black);
            pen.drawOval(x, y, 64, 64);
        }
    }
}
