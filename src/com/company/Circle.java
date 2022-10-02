package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape{
    int x, y, width, height;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }
@Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 10, 10);

        g2d.setColor(Color.GRAY);
        g2d.fill(circle);
    }


}
