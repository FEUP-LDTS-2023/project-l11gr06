package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PiranhaPlant extends Monster{
    public PiranhaPlant(Position p){
        super(p);
    }
    public PiranhaPlant(int x, int y) {
        super(x,y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "P");
    }
    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
}