package com.aor.supermario.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Pipe extends Element {
    private char character;
    public Pipe(Position p, char c) {
        super(p);
        character = c;
    }

    public Pipe(int x, int y, char c) {
        super(x, y);
        character = c;
    }
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}
