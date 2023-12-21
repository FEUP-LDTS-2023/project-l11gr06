package com.ldts.supermario.viewer;


import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.About;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class AboutViewerTest {
    private AboutViewer aboutViewer;
    private GUI gui;
    private About about;

    @BeforeEach
    void setUp() {
        about = Mockito.mock(About.class);
        gui = Mockito.mock(GUI.class);
        aboutViewer = new AboutViewer(about);
    }

    @Test
    void drawElements() {
        when(about.getNumberEntries()).thenReturn(3);
        when(about.getEntry(0)).thenReturn("ONE");
        when(about.getEntry(1)).thenReturn("TWO");
        when(about.getEntry(2)).thenReturn("THREE");
        when(about.isSelected(0)).thenReturn(true);
        when(about.isSelected(1)).thenReturn(false);
        when(about.isSelected(2)).thenReturn(false);

        aboutViewer.drawElements(gui);

        verify(gui, times(1)).drawText(eq(new Position(21, 5)), eq("GAME DEVELOPED BY"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(21, 18)), eq("ONE"), eq("#FF0000"));
        verify(gui, times(1)).drawText(eq(new Position(21, 19)), eq("TWO"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(21, 20)), eq("THREE"), eq("#FFFFFF"));
    }
}
