package gameEnv.Leader.Builds;

import java.awt.Graphics;

import gameEnv.Leader.Leader;
import renderWindow.RenderItem;

public class Town extends RenderItem{
    private Leader leader;
    public Town(Leader l, String tit, int x, int y) {
        super(tit, x, y);
        leader = l;
    }

    public void draw(Graphics pen,int x, int y) {
        pen.setColor(leader.getColor());
        pen.fillRect(x+14, y+14, 100, 100);
    }
    
}
