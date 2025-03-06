package Revamp.renderWindow.renderItem;

import java.awt.Color;
import java.awt.Graphics;

import Revamp.renderWindow.renderItem.Images.Image;

public class RenderObject {
    
    //object x y width height
    private int objX;
    private int objY;
    private int objW;
    private int objH;

    private RenderObjectType type;
    private Image image;
    private RenderObjectModifiers[] modifiers;
    public RenderObject(int x, int y, int w, int h, RenderObjectType type, RenderObjectModifiers[] modifs)  {
        setShape(x, y, w, h);
        this.type = type;
        modifiers = modifs;
    }

    public RenderObject(int x, int y, int w, int h, RenderObjectType type,Image im, RenderObjectModifiers[] modifs)  {
        setShape(x, y, w, h);
        this.type = type;
        image = im;
    }

    public void draw(Graphics pen) {
        if(getType()==RenderObjectType.rect) {
            drawRect(pen);
        }
        if(getType()==RenderObjectType.circle) {
            drawCircle(pen);
        }
        if(getType()==RenderObjectType.image) {
            drawImage(pen);
        }
    }

    public void drawRect(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(getObjX(), getObjY(), getObjW(), getObjH());
    }

    public void drawCircle(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillOval(getObjX(), getObjY(), getObjW(), getObjH());
    }

    public void drawImage(Graphics pen) {
        pen.drawImage(image.getImage(),getObjX(),getObjY(), getObjW(), getObjH(), null);
    }


    //shape of object x y width height
    public void setShape(int x, int y, int w, int h) {
        setObjX(x);
        setObjY(y);
        setObjW(w);
        setObjH(h);
    }
    public void setObjX(int x) {objX = x;}
    public int getObjX() {return objX;}

    public void setObjY(int y) {objY = y;}
    public int getObjY() {return objY;}

    public void setObjW(int w) {objW = w;}
    public int getObjW() {return objW;}

    public void setObjH(int h) {objH = h;}
    public int getObjH() {return objH;}

    //type of object
    public void setType(RenderObjectType o) {type = o;}
    public RenderObjectType getType() {return type;}

    //modifiers of object
    

}
