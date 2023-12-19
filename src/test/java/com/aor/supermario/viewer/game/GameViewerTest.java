package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.model.elements.*;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.Mockito.*;

class GameViewerTest {
    private GameViewer gameViewer;
    private GUI gui;
    private Map map;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        map = Mockito.mock(Map.class);
        gameViewer = new GameViewer(map);
    }

    @Test
    void drawElements() {
        // Mock game elements for testing
        Ground ground = new Ground(new Position(1, 1));
        Block block = new Block(new Position(2, 2));
        GoalPole goalPole = new GoalPole(new Position(3, 3));
        // ... (mock other elements as needed)

        // Set up the behavior of the mocked Map
        when(map.getGrounds()).thenReturn(Collections.singletonList(ground));
        when(map.getBlocks()).thenReturn(Collections.singletonList(block));
        when(map.getGoalPole()).thenReturn(Collections.singletonList(goalPole));
        // ... (set up other elements in a similar way)

        // Perform the test
        gameViewer.drawElements(gui);

        // Verify that the expected methods were called on the mock GUI
        verify(gui, times(1)).drawText(eq(new Position(10, 2)), eq("SCORE  " + map.getPlayer().getPoints()), eq("#FFD700"));

        // Verify that the draw methods of various ElementViewers were called with the correct arguments
        //verify(gui, times(1)).drawElement(eq(ground), any());
        //verify(gui, times(1)).drawElement(eq(block), any());
        //verify(gui, times(1)).drawElement(eq(goalPole), any());
        // ... (add more verifications for other elements)

        // Add more verifications as needed
    }
}

