package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nurgalievtr.18 on 10.04.2017.
 */
public class Point extends JPanel {
    public int x;
    public int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,3,3);
        g.setColor(Color.red);
    }

    public boolean equals(Point p2) {
        if(this.x == p2.x && this.y == p2.y) return true;
        else return false;
    }
}
