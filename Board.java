/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphical;

import Shapes.Circle;
import Shapes.Line;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener {

    Color currentColor = Color.BLACK;
    int mode = 0;//0 for line 1 for rect
    boolean filled = false;//if the value of filled is even so it is not filled
    int x1, y1;
    boolean first = false;
    int x2, y2;

    ArrayList<Shape> x = new ArrayList<Shape>();

    public Board() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) instanceof Line) {
                Line l = (Line) x.get(i);
                g.setColor(l.getColor());
                g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
            } else if (x.get(i) instanceof Rectangle) {
                Rectangle l = (Rectangle) x.get(i);
                g.setColor(l.getColor());
                if (filled == false) {
                    if (l.getX1() < l.getX2() && l.getY1() < l.getY2()) {
                        g.drawRect(l.getX1(), l.getY1(), l.getX2() - l.getX1(), l.getY2() - l.getY1());
                    } else if (l.getX1() > l.getX2() && l.getY1() > l.getY2()) {
                        g.drawRect(l.getX2(), l.getY2(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    } else if (l.getX1() < l.getX2() && l.getY1() > l.getY2()) {
                        g.drawRect(l.getX1(), l.getY2(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    } else if (l.getX1() > l.getX2() && l.getY1() < l.getY2()) {
                        g.drawRect(l.getX2(), l.getY1(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    }
                }else {
                    if (l.getX1() < l.getX2() && l.getY1() < l.getY2()) {
                        g.fillRect(l.getX1(), l.getY1(), l.getX2() - l.getX1(), l.getY2() - l.getY1());
                    } else if (l.getX1() > l.getX2() && l.getY1() > l.getY2()) {
                        g.fillRect(l.getX2(), l.getY2(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    } else if (l.getX1() < l.getX2() && l.getY1() > l.getY2()) {
                        g.fillRect(l.getX1(), l.getY2(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    } else if (l.getX1() > l.getX2() && l.getY1() < l.getY2()) {
                        g.fillRect(l.getX2(), l.getY1(), Math.abs(l.getX2() - l.getX1()), Math.abs(l.getY2() - l.getY1()));
                    }
                }
            } else if (x.get(i) instanceof Circle) {
                Circle l = (Circle) x.get(i);
                g.setColor(l.getColor());
                if (filled == false) {
                    if (l.getX1() < l.getX2() && l.getY1() < l.getY2()) {
                        g.drawOval(l.getX1(), l.getY1(),Math.abs(l.getX1()-l.getX2()),Math.abs(l.getX1()-l.getX2()));
                    } else if (l.getX1() > l.getX2() && l.getY1() > l.getY2()) {
                        g.drawOval(l.getX2(), l.getY2(),Math.abs(l.getX1()-l.getX2()),Math.abs(l.getX1()-l.getX2()));
                    } else if (l.getX1() < l.getX2() && l.getY1() > l.getY2()) {
                        g.drawOval(l.getX1(), l.getY2(),Math.abs(l.getX1()-l.getX2()),Math.abs(l.getX1()-l.getX2()));
                    } else if (l.getX1() > l.getX2() && l.getY1() < l.getY2()) {
                        g.drawOval(l.getX2(), l.getY1(),Math.abs(l.getX1()-l.getX2()),Math.abs(l.getX1()-l.getX2()));
                    }
                }else {
                    if (l.getX1() < l.getX2() && l.getY1() < l.getY2()) {
                        g.drawOval(l.getX1(), l.getY1(),l.getX1(),l.getY1());
                    } else if (l.getX1() > l.getX2() && l.getY1() > l.getY2()) {
                        g.drawOval(l.getX1(), l.getY1(),l.getX1(),l.getY1());
                    } else if (l.getX1() < l.getX2() && l.getY1() > l.getY2()) {
                        g.drawOval(l.getX1(), l.getY1(),l.getX1(),l.getY1());
                    } else if (l.getX1() > l.getX2() && l.getY1() < l.getY2()) {
                        g.drawOval(l.getX1(), l.getY1(),l.getX1(),l.getY1());
                    }
                }
            }else if (x.get(i) instanceof Triangle){
                Triangle l = (Triangle) x.get(i);
                g.setColor(l.getColor());
                if (filled == false) {
                   g.drawPolygon(new int [] {l.getX1(),l.getX2(),-2*l.getX1()+l.getX2()},new int []{l.getY1(),l.getY2(),l.getY2()}, 3);
                }else { 
                    g.fillPolygon(new int [] {l.getX1(),l.getX2(),-2*l.getX1()+l.getX2()},new int []{l.getY1(),l.getY2(),l.getY2()}, 3);
                }
            }
        }
    }

  
    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        if (mode == 0) {
            Line l = new Line(x1, y1, x1, y1, currentColor);
            x.add(l);
            repaint();
        } else if (mode == 1) {
            Rectangle r = new Rectangle(x1, y1, x1, y1, currentColor) {

                        public void move(Point current, Point prev) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                        
                        public boolean contains(float x, float y) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
            };
            x.add(r);
            repaint();
        } else if (mode == 2) {
            Circle c = new Circle(x1, y1, x1, y1, currentColor) {};
            x.add(c);
            repaint();
        }else if (mode == 3){
            Triangle t = new Triangle(x1, y1, x1, y1, currentColor) {
               
                public void move(Point current, Point prev) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                public boolean contains(float x, float y) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            x.add(t);
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }

            repaint();
            first = false;
        } else if (mode == 1) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
            first = false;
        } else if (mode == 2) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Circle) {
                Circle r = (Circle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
            first = false;
        }else if (mode == 3) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Triangle) {
                Triangle r = (Triangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
            first = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
