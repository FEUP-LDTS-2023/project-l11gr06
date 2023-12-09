package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class Player extends Element {
    private int points;

    private int state=0; //small mario

    public Player(int x, int y) {
        super(x, y);
    }
    public Player(Position p) {
        super(p);
    }
    /*
    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position moveRight() {return new Position(getPosition().getX()+1, getPosition().getY());}
    */
    public int getPoints() {
        return points;
    }

}