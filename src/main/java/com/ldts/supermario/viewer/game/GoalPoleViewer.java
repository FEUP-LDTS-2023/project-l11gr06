package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.GoalPole;
import com.ldts.supermario.gui.GUI;

public class GoalPoleViewer implements ElementViewer<GoalPole> {
    @Override
    public void draw(GoalPole goalPole, GUI gui) {
        gui.drawGoalPole(goalPole.getPosition());
    }
}