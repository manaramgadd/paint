/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author kerog
 */
public abstract class Triangle extends Shape {
    public boolean filled = false ;
     private int x1, y1;
    private int x2, y2;

    public Triangle(int x1, int y1, int x2, int y2, Color color) {
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
                if (filled == false) {
                   g.drawPolygon(new int [] {getX1(),getX2(),(-2*getX1())+getX2()},new int []{getY1(),getY2(),getY2()}, 3);
                }else { 
                    g.fillPolygon(new int [] {getX1(),getX2(),-2*getX1()+getX2()},new int []{getY1(),getY2(),getY2()}, 3);
                }
   }
}
