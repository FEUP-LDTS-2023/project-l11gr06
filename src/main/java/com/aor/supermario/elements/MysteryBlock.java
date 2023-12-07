package com.aor.supermario.elements;

import com.aor.supermario.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MysteryBlock extends Element {
    private static int MysteryState = 0;

    public MysteryBlock(Position p) {
        super(p);
    }

    public MysteryBlock(int x, int y) {
        super(x, y);
    }

    public static int getMysteryState() {
        return MysteryState;
    }

    public void setMysteryState(int MysteryState) {
        this.MysteryState = MysteryState;

    }
}
