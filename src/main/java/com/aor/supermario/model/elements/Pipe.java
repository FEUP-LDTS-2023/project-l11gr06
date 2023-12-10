package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

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

    public char getCharacter() {return character;}
    public void moveMapLeft() {
        Position p=new Position(getPosition().getX()-1, getPosition().getY());
        setPosition(p);
    }
}
