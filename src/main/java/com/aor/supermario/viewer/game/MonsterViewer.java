package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.model.elements.Turtle;
import com.aor.supermario.model.elements.TurtleShell;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        if (monster instanceof Turtle) gui.drawTurtle(monster.getPosition());
        else if (monster instanceof TurtleShell) gui.drawTurtleShell(monster.getPosition());
        else if (monster instanceof BrownMushroom) gui.drawBrownMushroom(monster.getPosition());
    }
}


