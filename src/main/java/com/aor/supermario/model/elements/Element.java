package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;
    public Element(Position position) {this.position = position;
    }
    public Element(int x, int y) {
        this.position = new Position(x,y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position p) {
        this.position = p;
    }
}