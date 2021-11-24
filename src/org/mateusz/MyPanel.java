package org.mateusz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener, KeyListener {

    MyCircle circ=null; //rysowane kółko
    MyRectangle rec=null; //rysowany prostokąt
    boolean r=false; //zmienna boolowska zapamietujaca informacje czy wcisnieto przycisk r
    boolean c=false; //analogicznie do r, przycisk c

    MyPanel(){
        setBackground(Color.GRAY);
        setLayout(null);
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(c) {
            circ= new MyCircle(e.getX(),e.getY()); //ustawianie lokalizacji kółka
            repaint(); //przerysowanie kanwy
        }
        if(r){
            rec=new MyRectangle(e.getX(),e.getY());//ustawianie lokalizacji kwadratu
            repaint();//przerysowanie kanwy
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            if(circ != null) {
            g2d.setColor(Color.BLUE);
            circ.draw(g2d);} //rysowanie kółka
            if(rec != null) {
            g2d.setColor(Color.RED);
            rec.draw(g2d);}//rysowanie kwadratu
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_C) c=true;
        if(e.getKeyCode()==KeyEvent.VK_R) r=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        r=false;
        c=false;
    }
}
