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
 
public abstract class Shape extends JPanel{
    Color color;
protected double x, y, width, height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
    }
    

	public abstract void move(Point current, Point prev);
        public abstract boolean contains(float x, float y);
   
    
//   public abstract void draw(Graphics g);
}
