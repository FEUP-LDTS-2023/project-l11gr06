package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Victory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class VictoryViewerTest {
    private VictoryViewer victoryViewer;
    private GUI gui;
    private Victory victory;

    @BeforeEach
    void setUp() {
        victory = Mockito.mock(Victory.class);
        gui = Mockito.mock(GUI.class);
        victoryViewer = new VictoryViewer(victory);
    }

    @Test
    void drawElements() {
        when(victory.getNumberEntries()).thenReturn(2);
        when(victory.getEntry(0)).thenReturn("entry 1");
        when(victory.getEntry(1)).thenReturn("entry 2");
        when(victory.isSelected(0)).thenReturn(true);
        when(victory.isSelected(1)).thenReturn(false);
        when(victory.isSelected(2)).thenReturn(false);

        victoryViewer.drawElements(gui);

        verify(gui, times(1)).drawText(eq(new Position(24, 5)), eq("YOU @ON"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 7)), eq("entry 1"), eq("#FF0000"));
        verify(gui, times(1)).drawText(eq(new Position(24, 8)), eq("entry 2"), eq("#FFFFFF"));
    }
}
