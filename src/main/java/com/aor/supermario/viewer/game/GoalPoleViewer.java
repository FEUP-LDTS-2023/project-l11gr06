package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.GoalPole;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.viewer.game.ElementViewer;

public class GoalPoleViewer implements ElementViewer<GoalPole> {
    @Override
    public void draw(GoalPole goalPole, GUI gui) {
        gui.drawGoalPole(Element.getPosition());
    }
}