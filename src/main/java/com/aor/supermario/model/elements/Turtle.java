package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Turtle extends Monster{
    public Turtle(int x, int y) {
        super(x,y);
    }

    public Turtle(Position p){
        super(p);
    }

}