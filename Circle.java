/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public abstract class Circle extends Shape extends JPanel {
    boolean filled = false;
    private int x1,x2;
    private int y1,y2;

    public Circle(int x1,int x2, int y1, int y2, Color color ){
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void draw(Graphics g) {
         g.setColor(getColor());
                if (filled == false) {
                    if (getX1() < getX2() && getY1() < getY2()) {
                        g.drawOval(getX1(), getY1(),Math.abs(getX1()-getX2()),Math.abs(getX1()-getX2()));
                    } else if (getX1() > getX2() && getY1() > getY2()) {
                        g.drawOval(getX2(), getY2(),Math.abs(getX1()-getX2()),Math.abs(getX1()-getX2()));
                    } else if (getX1() < getX2() && getY1() > getY2()) {
                        g.drawOval(getX1(), getY2(),Math.abs(getX1()-getX2()),Math.abs(getX1()-getX2()));
                    } else if (getX1() > getX2() && getY1() < getY2()) {
                        g.drawOval(getX2(), getY1(),Math.abs(getX1()-getX2()),Math.abs(getX1()-getX2()));
                    }
                }else {
                    if (getX1() < getX2() && getY1() < getY2()) {
                        g.drawOval(getX1(), getY1(),getX1(),getY1());
                    } else if (getX1() > getX2() && getY1() > getY2()) {
                        g.drawOval(getX1(), getY1(),getX1(),getY1());
                    } else if (getX1() < getX2() && getY1() > getY2()) {
                        g.drawOval(getX1(), getY1(),getX1(),getY1());
                    } else if (getX1() > getX2() && getY1() < getY2()) {
                        g.drawOval(getX1(), getY1(),getX1(),getY1());
                    }
                }
       
    }

    @Override
    public void move(Point current, Point prev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

