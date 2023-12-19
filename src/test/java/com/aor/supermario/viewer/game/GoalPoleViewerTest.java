package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.GoalPole;
import com.aor.supermario.viewer.game.GoalPoleViewer;
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