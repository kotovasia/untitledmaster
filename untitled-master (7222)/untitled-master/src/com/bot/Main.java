package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Point answerPoint1 = null;
    private static Point answerPoint2 = null;
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Circle> circles = new ArrayList<Circle>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
        addPointwithCoords.setBounds(2,2,300,25);
        butPanel.add(addPointwithCoords);
        JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
        addRandomPoints.setBounds(2,50,300,25);
	    butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2,70,30,25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);

        JLabel X1 = new JLabel("X1:");
        X1.setBounds(2,250,25,25);
        butPanel.add(X1);
        JLabel Y1 = new JLabel("Y1:");
        Y1.setBounds(70,250,25,25);
        butPanel.add(Y1);


        JLabel addRandomCircles = new JLabel("Добавить рандомное кол-во окружностей:");
        addRandomCircles.setBounds(2,400,300,25);
        butPanel.add(addRandomCircles);

        JLabel C = new JLabel("NUM:");
        C.setBounds(2,440,30,25);
        butPanel.add(C);

        final JTextField c = new JTextField();
        c.setBounds(35,440, 25,25);
        butPanel.add(c);

        JLabel addPointwithCoords1 = new JLabel("Добавить точки по координатам,радиус:");
        addPointwithCoords1.setBounds(2,200,300,40);
        butPanel.add(addPointwithCoords1);



        final JTextField y1 = new JTextField();
        y1.setBounds(90,250, 25,25);
        butPanel.add(y1);



        final JTextField x1 = new JTextField();
        x1.setBounds(25,250, 25,25);
        butPanel.add(x1);

        JLabel R = new JLabel("R:");
        R.setBounds(140,250,30,25);
        butPanel.add(R);

        final JTextField r = new JTextField();
        r.setBounds(155,250, 25,25);
        butPanel.add(r);

        JButton button3 = new JButton("Добавить окружность" );
        button3.setBounds(2,300,200,40);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Добавлена окружность");
                int x = (!x1.getText().equals("")?Integer.parseInt(x1.getText()):0);
                int y= (!y1.getText().equals("")?Integer.parseInt(y1.getText()):0);
                int R = (!r.getText().equals("")?Integer.parseInt(r.getText()):0);
                System.out.println(x+" "+y+" "+R);
                Circle c = new Circle(x,y,R);
                c.setBounds(c.myGetX()-c.myGetR(),c.myGetY()-c.myGetR(),2*c.myGetR(),2* c.myGetR());
                circles.add(c);
                pointpane.add(c);
                pointpane.repaint();

            }
        });
        butPanel.add(button3);


        JButton readFileBut = new JButton("Читать из файла" );
        readFileBut.setBounds(2,350,200,40);
        butPanel.add(readFileBut);
        readFileBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(Scanner in = new Scanner(new File("input.txt"))){
                   int numOfPoints = in.nextInt();
                   for(int i = 0; i < numOfPoints ; i++){
                       Point p = new Point(in.nextInt(),in.nextInt());
                       p.setBounds(p.x,p.y,p.x+3,p.y+3);
                       points.add(p);
                       pointpane.add(p);
                   }
                   int numOfCircles = in.nextInt();
                    for(int i = 0 ;i < numOfCircles ; i++){
                        Circle c = new Circle(in.nextInt(),in.nextInt(),in.nextInt());
                        c.setBounds(c.myGetX()-c.myGetR(),c.myGetY()-c.myGetR(),2*c.myGetR(),2* c.myGetR());
                        circles.add(c);
                        pointpane.add(c);
                    }
                    pointpane.repaint();
                    pointpane.revalidate();


                }catch(Exception e1){
                    System.out.print("IOError");
                }
            }
        });

        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if ((X>0)&&(Y>0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x,b.y,b.x+3,b.y+3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x,b.y,b.x+3,b.y+3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }


            }
        });




        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(points.size() > 0) {
                    int index = points.size() - 1;
                    Point point = points.remove(index);
                    pointpane.remove(point);
                    pointpane.repaint();
                    pointpane.revalidate();
                }
                while(circles.size() > 0){
                    Circle circle = circles.remove(circles.size() -1);
                    pointpane.remove(circle);
                    pointpane.repaint();
                    pointpane.revalidate();
                }
            }
        });
        button2.setBounds(2,150,160,40);
        butPanel.add(button2);

        JButton solutionButton = new JButton("Решить" );
        solutionButton.setBounds(2,480,200,40);
        solutionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                answerPoint1 = null;
                answerPoint2 = null;
                int max = -1;
                for(Point p1 : points) {
                    for(Point p2 : points) {
                        if(!p1.equals(p2)) {
                            int curr = 0;
                            for(Circle c : circles) {
                                if(Circle.intersects(p1,p2,c.getCenter(),c.myGetR())) curr++;
                            }
                            if(curr > max){
                                max = curr;
                                answerPoint1 = p1;
                                answerPoint2 = p2;
                            }
                        }
                    }
                }
                System.out.println(answerPoint1.x + " " + answerPoint1.y);
                System.out.println(answerPoint2.x + " " + answerPoint2.y);
            }
        });
        butPanel.add(solutionButton);

        JButton writeFileBut = new JButton("Записать в файл");
        writeFileBut.setBounds(2,525,200,40);
        butPanel.add(writeFileBut);
        writeFileBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(PrintWriter out = new PrintWriter(new File("output.txt"))){
                    out.println("(" + answerPoint1.x + " ; " + answerPoint1.y + ")");
                    out.println("(" + answerPoint2.x + " ; " + answerPoint2.y + ")");
                }catch(Exception e1){
                    System.out.print("Error");
                }
            }
        });


        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
