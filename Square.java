/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import static com.sun.javafx.geom.Curve.prev;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author NEXT STORE
 */
public abstract class Square extends  Shape{
    public  boolean filled = false; 
     private int x1, y1;
     private int x2, y2;

    public Square(int x1, int y1, int x2, int y2, Color color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getY2() {
        return y2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    public void draw(Graphics g){
        g.setColor(getColor());
                if (filled  == false ) {
                    if (getX1() < getX2() && getY1() < getY2()) {
                        g.drawRect(getX1(), getY1(), Math.abs(getX2() - getX1()), Math.abs(getX1() - getX2()));
                    } else if (getX1() > getX2() && getY1() > getY2()) {
                        g.drawRect(getX2(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getX1() - getX2()));
                    } else if (getX1() < getX2() && getY1() > getY2()) {
                        g.drawRect(getX1(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getX1() - getX2()));
                    } else if (getX1() > getX2() && getY1() < getY2()) {
                        g.drawRect(getX2(), getY1(), Math.abs(getX2() - getX1()), Math.abs(getX1() - getX2()));
                    }
                }else {
                    if (getX1() < getX2() && getY1() < getY2()) {
                        g.fillRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY1());
                    } else if (getX1() > getX2() && getY1() > getY2()) {
                        g.fillRect(getX2(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                    } else if (getX1() < getX2() && getY1() > getY2()) {
                        g.fillRect(getX1(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                    } else if (getX1() > getX2() && getY1() < getY2()) {
                        g.fillRect(getX2(), getY1(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                    }
    }

}
}
