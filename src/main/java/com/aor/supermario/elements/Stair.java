package com.aor.supermario.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Stair extends Element {

    public Stair(Position p){
        super(p);
    }
    public Stair(int x, int y) {
        super(x,y);
    }
}