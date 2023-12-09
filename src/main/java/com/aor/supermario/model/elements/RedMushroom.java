package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class RedMushroom extends Element {

    public RedMushroom(Position p) {
        super(p);
    }

    public RedMushroom(int x, int y) {
        super(x, y);
    }
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}