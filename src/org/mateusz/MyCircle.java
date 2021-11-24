package org.mateusz;

import java.awt.*;

public class MyCircle {//kółko r reagujacy na klawisz r i przycisk myszy
    private final int r = 30;
    int x, y;

    MyCircle(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void draw(Graphics2D g2d) {
        g2d.fillOval(x, y, r, r);
    }
}
