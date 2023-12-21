package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class Player extends Element {
    private int points;

    //private int state=0; //small mario
    public Player(int x, int y) {
        super(x, y);
    }

    public Player(Position p) {
        super(p);
    }

    public int getPoints() {
        return points;
    }

    public void addPoint(int number) {
        this.points+=number;
    }

}