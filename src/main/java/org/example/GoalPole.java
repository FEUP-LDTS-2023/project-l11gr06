package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GoalPole extends Element{

    public GoalPole(Position p){
        super(p);
    }
    public GoalPole(int x, int y) {
        super(x,y);
    }
    public void draw(TextGraphics graphics) {

        if(getPosition().getY()==Game.height_game-13)
        {
            graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "<");
        }
        else
        {
            graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "|");
        }
    }


}
