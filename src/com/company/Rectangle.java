package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape{

    int x, y, width, height;

    public Rectangle(int x, int y,int width,int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height=height;
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
       Rectangle2D.Double rectangle = new Rectangle2D.Double(x,y,width,height);
        g2d.setColor(Color.RED);
        g2d.fill(rectangle);
    }


}

