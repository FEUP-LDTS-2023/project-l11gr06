package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class GoalPole extends Element {

    public GoalPole(Position p){
        super(p);
    }
    public GoalPole(int x, int y) {
        super(x,y);
    }
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}
