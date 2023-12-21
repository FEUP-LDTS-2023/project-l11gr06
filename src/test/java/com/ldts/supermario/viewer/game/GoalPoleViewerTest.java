package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.GoalPole;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class GoalPoleViewerTest {

    @Test
    void drawGoalPole() {
        GUI gui = Mockito.mock(GUI.class);
        GoalPole goalPole = new GoalPole(new Position(5, 10));
        GoalPoleViewer goalPoleViewer = new GoalPoleViewer();
        goalPoleViewer.draw(goalPole, gui);

        verify(gui).drawGoalPole(new Position(5, 10));
    }
}