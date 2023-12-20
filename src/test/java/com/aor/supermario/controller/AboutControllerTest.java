package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.states.State;
import com.aor.supermario.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class AboutControllerTest {
    private AboutController aboutController;
    private Game game;
    private GUI gui;
    private About about;
    private Viewer<About> viewer;
    private State state;

    @BeforeEach
    void setUp() {
        about = mock(About.class);
        viewer = mock(Viewer.class);
        aboutController = new AboutController(about, viewer);
        game = mock(Game.class);
        gui = mock(GUI.class);
        state = mock(State.class);
    }

    @Test
    void UpAction() throws IOException {

        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        aboutController.step(game, gui.getNextAction(), 1000);
        verify(gui).getNextAction();
    }

    @Test
    void SelectAction() throws IOException {

        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(about.isSelectedMenu()).thenReturn(true);
        aboutController.step(game, gui.getNextAction(), 1000);
        verify(gui).getNextAction();
        verify(game).setState(any(MenuState.class));

    }

    @Test
    void SelectActionNotSelectedMenu() throws IOException {

        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(about.isSelectedMenu()).thenReturn(false);
        aboutController.step(game, gui.getNextAction(), 1000);
        verify(gui).getNextAction();
    }
}



