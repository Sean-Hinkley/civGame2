package gameEnv.Leader.Units;

import java.awt.Color;
import java.awt.Graphics;

import gameEnv.Leader.Leader;
import gameEnv.Leader.Builds.Town;
import renderWindow.RenderItem;

public class Unit extends RenderItem{
    private boolean selected;
    private Leader myLeader;
    private int x;
    private int y;
    private int moves;
    private int moved;
    private Ability[] abilities;
    String unitName;
    public Unit(String name, Leader l, int x, int y, int moves) {
        super("Unit", x, y);
        abilities = new Ability[4];
        setAbility();
        //System.out.println("\n\n"+abilities[0]);
        unitName = name;
        myLeader = l;
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

    public void setAbility() {
        abilities[0] = new Ability(this,"name") {
            
            public void actions() {
                System.out.println("Clicked");
                myLeader.addTown(new Town(myLeader, title, x, y), getPosX(), getPosY());
                myLeader.remUnit(unit);
            }

        };
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

    public Ability getAbility(int ind) {
        System.out.println("HEllo");
        if(ind >= 0 && ind < abilities.length) {
            System.out.println(abilities[ind]);
            return abilities[ind];
        }

        return null;
    }

    public void draw(Graphics pen, int x, int y) {
        pen.setColor(Color.red);
        pen.fillOval(x, y, 64, 64);
        if(selected) {
            pen.setColor(Color.black);
            pen.drawOval(x, y, 64, 64);
        }
    }


    public class Ability {
        String title;
        Unit unit;
        public Ability(String title) {
            this.title = title;
            unit = null;
        }

        public Ability(Unit u, String title) {
            this.title = title;
            unit = u;
        }

        public Ability() {
            
        }

        public void setUnit(Unit u) {
            unit = u;
        }

        public Unit getUnit() {
            return unit;
        }

        public void actions() {

        }

        public void pressed() {

        }

        public void drawButton(Graphics pen, int x, int y) {
            //System.out.println("Runnnn");
            pen.setColor(Color.pink);
            pen.fillOval(x, y, 25, 25);
        }
    }
}