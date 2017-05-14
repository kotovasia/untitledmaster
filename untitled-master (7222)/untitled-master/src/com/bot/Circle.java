package com.bot;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kotovaov.18 on 24.04.2017.
 */
public class Circle extends JPanel {
        private int x;
        private int y;
        private int R;

        Circle(int x,int y,int R){
            this.x=x;
            this.y=y;
            this.R=R;
        }

        public Point getCenter(){
            return new Point(x,y);
        }
        public int myGetX(){
            return x;
        }
        public void mySetX(int x){
            this.x=x;

        }

        public int myGetY() {
            return y;
        }

        public void mySetY(int y) {
            this.y = y;
        }
        public int myGetR(){
            return R;
        }

        public void mySetR(int r) {
            R = r;
        }

        public static boolean intersects(Point pointA,
                                                             Point pointB, Point center, double radius) {
            double baX = pointB.x - pointA.x;
            double baY = pointB.y - pointA.y;
            double caX = center.x - pointA.x;
            double caY = center.y - pointA.y;

            double a = baX * baX + baY * baY;
            double bBy2 = baX * caX + baY * caY;
            double c = caX * caX + caY * caY - radius * radius;

            double pBy2 = bBy2 / a;
            double q = c / a;

            double disc = pBy2 * pBy2 - q;
            if (disc < 0) {
                return false;
            }
            else
                return true;
        }


        public void paintComponent(Graphics g){
            g.setColor(Color.cyan);
            g.drawOval(0,0,2*R,2*R);
        }

}

