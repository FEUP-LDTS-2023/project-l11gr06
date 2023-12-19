package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.GameOver;
import com.aor.supermario.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class GameOverViewerTest {
    private GameOverViewer gameOverViewer;
    private GUI gui;
    private GameOver gameOver;

    @BeforeEach
    void setUp() {
        gameOver = Mockito.mock(GameOver.class);
        gui = Mockito.mock(GUI.class);
        gameOverViewer = new GameOverViewer(gameOver);
    }

    @Test
    void drawElements() {

        when(gameOver.getNumberEntries()).thenReturn(3);
        when(gameOver.getEntry(0)).thenReturn("Option 1");
        when(gameOver.getEntry(1)).thenReturn("Option 2");
        when(gameOver.getEntry(2)).thenReturn("Option 3");
        when(gameOver.isSelected(0)).thenReturn(true);
        when(gameOver.isSelected(1)).thenReturn(false);
        when(gameOver.isSelected(2)).thenReturn(false);

        gameOverViewer.drawElements(gui);

        verify(gui, times(1)).drawText(eq(new Position(24, 5)), eq("GAME OVER"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 7)), eq("Option 1"), eq("#FF0000"));
        verify(gui, times(1)).drawText(eq(new Position(24, 8)), eq("Option 2"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 9)), eq("Option 3"), eq("#FFFFFF"));

    }
}
