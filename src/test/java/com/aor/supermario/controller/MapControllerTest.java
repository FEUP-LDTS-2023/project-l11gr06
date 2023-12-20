package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.GameOverViewer;
import com.aor.supermario.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MapControllerTest {

    private MapController mapController;
    private Game game;
    private GUI gui;
    private Map map;
    private Viewer<Map> viewer;

    @BeforeEach
    void setUp() {
        map = mock(Map.class);
        viewer = mock(Viewer.class);
        mapController = new MapController(map, viewer);
        game = mock(Game.class);
        gui = mock(GUI.class);
    }

    @Test
    void quit() throws IOException, URISyntaxException, FontFormatException {

        when(gui.getNextAction()).thenReturn(GUI.ACTION.QUIT);
        mapController.step(game, gui.getNextAction(), 1000);
        verify(game).setState(any(MenuState.class));
        verify(game, never()).getState();
        verify(gui).getNextAction();
    }
}
