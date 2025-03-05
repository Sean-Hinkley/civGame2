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

    public void draw(Graphics pen,int x, int y, int sizescale) {
        pen.setColor(leader.getColor());
        pen.fillRect(x+sizescale/4, y+sizescale/4, sizescale/2, sizescale/2);
    }
    
}
