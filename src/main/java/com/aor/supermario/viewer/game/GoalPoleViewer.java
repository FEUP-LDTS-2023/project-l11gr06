package com.aor.supermario.viewer.game;

import com.aor.supermario.model.elements.GoalPole;
import com.aor.supermario.gui.GUI;

public class GoalPoleViewer implements ElementViewer<GoalPole> {
    @Override
    public void draw(GoalPole goalPole, GUI gui) {
        gui.drawGoalPole(goalPole.getPosition());
    }
}