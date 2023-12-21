package com.ldts.supermario.controller;
import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.Map;
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
