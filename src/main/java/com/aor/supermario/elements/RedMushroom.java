package com.aor.supermario.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class RedMushroom extends Element {

    public RedMushroom(Position p) {
        super(p);
    }

    public RedMushroom(int x, int y) {
        super(x, y);
    }
}