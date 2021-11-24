package org.mateusz;

import java.awt.*;

public class MyRectangle { //prostokat r reagujacy na klawisz r i przycisk myszy
    private final int a = 20;
    int x, y;

    MyRectangle(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x,y,a,a);
    }
}
