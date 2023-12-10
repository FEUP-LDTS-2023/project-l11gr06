package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class MysteryBlock extends Element {
    private int MysteryState = 0;

    public MysteryBlock(Position p) {
        super(p);
    }

    public MysteryBlock(int x, int y) {
        super(x, y);
    }

    public int getMysteryState() {
        return MysteryState;
    }

    public void setMysteryState(int MysteryState) {
        this.MysteryState = MysteryState;

    }
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}
