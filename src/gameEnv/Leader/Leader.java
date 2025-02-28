package gameEnv.Leader;

import java.awt.Color;
import java.util.ArrayList;

import gameEnv.Leader.Builds.Town;
import gameEnv.Leader.Units.Unit;
import gameEnv.map.Map;

public class Leader {
    String name;
    ArrayList<Unit> units;
    Color leaderColor;
    Map map;
    int researchPerTurn;
    int foodPerTurn;
    int productionPerTurn;
    ArrayList<Town> towns;
    public Leader(String name, Map m) {
        map = m;
        units = new ArrayList<>();
        towns = new ArrayList<>();
        this.name = name;
        leaderColor = Color.red;
        researchPerTurn = 2;
        foodPerTurn = 0;
        productionPerTurn = 0;

    }

    public int getResearchPerTurn() {
        return researchPerTurn;
    }

    public Color getColor() {
        return leaderColor;
    }

    public void addUnit(Unit u, int x, int y) {
        units.add(u);
        map.addUnit(u, x, y);
    }

    public int findUnit(Unit u) {
        for(int x = 0; x < units.size(); x++) {
            if(units.get(x)==u) {
                return x;
            }
        }
        return -1;
    }

    public void addTown(Town u, int x, int y) {
        towns.add(u);
        map.addTown(u, x, y);
    }

    public void remTown(Town u) {
        int x = u.getPosX();
        int y = u.getPosY();
        towns.remove(u);
        map.removeTown(x, y);
    }
    
    public void remUnit(Unit u) {
        int x = u.getPosX();
        int y = u.getPosY();
        units.remove(u);
        map.removeUnit(x, y);
    }
}
