package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class HelpViewerTest {
    private HelpViewer helpViewer;
    private GUI gui;
    private Help help;

    @BeforeEach
    void setUp() {
        help = Mockito.mock(Help.class);
        gui = Mockito.mock(GUI.class);
        helpViewer = new HelpViewer(help);
    }

    @Test
    void drawElements() {
        when(help.getNumberEntries()).thenReturn(3);
        when(help.getEntry(0)).thenReturn("I 1");
        when(help.getEntry(1)).thenReturn("I 2");
        when(help.getEntry(2)).thenReturn("I 3");
        when(help.isSelected(0)).thenReturn(true);
        when(help.isSelected(1)).thenReturn(false);
        when(help.isSelected(2)).thenReturn(false);

        helpViewer.drawElements(gui);

        verify(gui, times(1)).drawText(eq(new Position(20, 2)), eq("GAME INSTRUCTIONS "), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 5)), eq("PRESS THE RIGHT OR LEFT ARRO@ TO RUN AND UP ARRO@ TO JUMP"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 7)), eq("PRESS X TO DO A FRONT JUMP AND Z TO DO A BACK JUMP"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 9)), eq("JUMP ON TOP OF THE ENEMIES TO KILL THEM"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 11)), eq("IF YOU BUMP INTO ONE OF THE MONSTERS YOU DIE"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 13)), eq("IF YOU ARE DONE PLAYING PRESS Q TO RETURN TO MENU"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(2, 15)), eq("REACH THE FINAL FLAG TO @IN THE GAME"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(21, 18)), eq("I 1"), eq("#FF0000"));
        verify(gui, times(1)).drawText(eq(new Position(21, 19)), eq("I 2"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(21, 20)), eq("I 3"), eq("#FFFFFF"));

    }
}
