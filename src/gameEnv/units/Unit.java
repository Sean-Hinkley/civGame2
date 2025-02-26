package gameEnv.units;

import java.awt.Color;
import java.awt.Graphics;

import renderWindow.RenderItem;

public class Unit extends RenderItem{
    private boolean selected;
    private int x;
    private int y;
    public Unit(int x, int y) {
        super("Unit", x*128, y*128);
        this.x = x;
        this.y = y;
        selected = false;
    }

    public void moved(int x, int y) {
        setPosX(x*128);
        setPosY(y*128);
        this.x = x;
        this.y = y;
    }
    public int getTileX() {
        return x;
    }
    public int getTileY() {
        return y;
    }

    public void setSelect(boolean b) {
        selected = b;
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
