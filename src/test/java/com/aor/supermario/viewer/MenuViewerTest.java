package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Menu;
import com.aor.supermario.model.Position;
import com.aor.supermario.viewer.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MenuViewerTest {
    private MenuViewer menuViewer;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        gui = Mockito.mock(GUI.class);
        menuViewer = new MenuViewer(menu);
    }

    @Test
    void drawElements() {
        when(menu.getNumberEntries()).thenReturn(3);
        when(menu.getEntry(0)).thenReturn("Option 1");
        when(menu.getEntry(1)).thenReturn("Option 2");
        when(menu.getEntry(2)).thenReturn("Option 3");
        when(menu.isSelected(0)).thenReturn(true);
        when(menu.isSelected(1)).thenReturn(false);
        when(menu.isSelected(2)).thenReturn(false);


        menuViewer.drawElements(gui);

        verify(gui, times(1)).drawText(eq(new Position(24, 5)), eq("SUPER MARIO"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 6)), eq("BROS"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 8)), eq("Option 1"), eq("#FF0000"));
        verify(gui, times(1)).drawText(eq(new Position(24, 9)), eq("Option 2"), eq("#FFFFFF"));
        verify(gui, times(1)).drawText(eq(new Position(24, 10)), eq("Option 3"), eq("#FFFFFF"));

    }
}

