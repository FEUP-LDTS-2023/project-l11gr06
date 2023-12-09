package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class Ground extends Element {

    public Ground(Position p){
        super(p);
    }
    public Ground(int x, int y) {
        super(x,y);
    }
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}