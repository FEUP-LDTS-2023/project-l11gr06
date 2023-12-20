package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.HelpViewer;
import com.aor.supermario.viewer.HelpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HelpControllerTest {
    private Help help;
    private HelpViewer viewer;
    private HelpController controller;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        help = new Help();
        viewer = new HelpViewer(help);
        controller = new HelpController(help,viewer);
        game= Mockito.mock(Game.class);
    }

    @Test
    void selectMenu() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new MenuState(new Menu()));
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), MenuState.class);
    }

}