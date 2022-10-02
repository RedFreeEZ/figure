package com.company;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main {
    public static class main extends JPanel {

        private List shapes = new ArrayList<>();
        private Random random = new Random();

        public main(int i, String shape) {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(400, 400));

            switch (shape) {
                case "Circles":
                    for (int j = 0; j < i; j++) {
                        addCircle(390, 390);
                    }
                    break;
                case "Rectangle":
                    for (int j = 0; j < i; j++) {
                        addRectangle(380, 380);
                    }
                    break;
                case "Both":
                    int mid = i / 2;
                    for (int j = 0; j < mid; j++) {
                        addCircle(390, 390);
                    }
                    for (int j = mid; j < i; j++) {
                        addRectangle(380, 380);//380,380
                    }
                    break;
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Object s : shapes) {
                if (s instanceof Circle) {
                    ((Circle) s).draw(g);
                } else if (s instanceof Rectangle) {
                    ((Rectangle) s).draw(g);
                }
            }
        }

        public void addCircle(int maxX, int maxY) {
            shapes.add(new Circle(random.nextInt(maxX), random.nextInt(maxY)));
            repaint();
        }

        public void addRectangle(int maxX, int maxY) {//,int maxW,int maxH
            shapes.add(new Rectangle(random.nextInt(maxX), random.nextInt(maxY)));//,random.nextInt(maxW),random.nextInt(maxH)
            repaint();
        }

        public static void main(String[] args) {

            String shapeAmount = JOptionPane.showInputDialog(null,
                    "How many shapes?", "Random Shapes...", JOptionPane.PLAIN_MESSAGE);
            int amount = Integer.parseInt(shapeAmount);

            String shapes[] = {"Rectangle", "Circles", "Both"};
            String shape = (String) JOptionPane.showInputDialog(null,
                    "Pick the shape you want", "Random Shapes...",
                    JOptionPane.PLAIN_MESSAGE, null, shapes, shapes[0]);

            JFrame frame = new JFrame();
            frame.add(new main(amount, shape));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }}}
