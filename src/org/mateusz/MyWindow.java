package org.mateusz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame{

    MyWindow(){

        setTitle("Lab4"); //nazwa okna
        setSize(new Dimension(640, 480)); //ustawienie wymiarów
        setResizable(false); //uniemozliwienie zmiany wymiarow
        setLocationRelativeTo(null); //wycentrowanie otwieranego okna
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//zakończenie działania programu po naciśnięciu X

        MyPanel panel = new MyPanel(); //wyjściowa kanwa
        add(panel);//dodanie panelu do JFrame

        JButton buttonr = new JButton("Run"); //tworzenie przycisku uciekającego
        buttonr.setBounds(200, 230, 100, 30);
        buttonr.setFocusable(false);
        buttonr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(e.getX()!=0)     //warunek sprawiajacy ze przycisk nie ucieka jak myszka wejdzie od lewej strony
                    buttonr.setLocation((int)(Math.random()*(500-0)),(int)(Math.random()*(400-0))); //losowa lokalizacja uciekajacego przycisku
            }
        });
        panel.add(buttonr);

        JButton buttonb = new JButton("Reset"); //tworzenie przycisku, który resetuje polozenie przycisku Run
        buttonb.setBounds(320, 230, 100, 30);
        buttonb.setFocusable(false);
        buttonb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //reset
                buttonr.setLocation(200, 230);
                panel.circ=null;
                panel.rec=null;
                repaint();
            }
        });
        panel.add(buttonb);
    }
}
