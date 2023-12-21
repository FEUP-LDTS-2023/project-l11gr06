package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.elements.BrownMushroom;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.model.elements.Turtle;
import com.ldts.supermario.model.elements.TurtleShell;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        if (monster instanceof Turtle) gui.drawTurtle(monster.getPosition());
        else if (monster instanceof TurtleShell) gui.drawTurtleShell(monster.getPosition());
        else if (monster instanceof BrownMushroom) gui.drawBrownMushroom(monster.getPosition());
    }
}


