package com.ldts.supermario.controller;
import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.AboutState;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.HelpState;
import com.ldts.supermario.viewer.MenuViewer;
import com.ldts.supermario.model.About;
import com.ldts.supermario.model.Help;
import com.ldts.supermario.model.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    private com.ldts.supermario.model.Menu menu;
    private MenuViewer viewer;
    private MenuController controller;
    private Game game;
    private int currentEntry;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new Menu();
        viewer = new MenuViewer(menu);
        controller = new MenuController(menu,viewer);
        game= Mockito.mock(Game.class);
    }

    @Test
    void upMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        Assertions.assertEquals(controller.getModel().getCurrentEntry(),3);
    }
    @Test
    void downMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        Assertions.assertEquals(controller.getModel().getCurrentEntry(),1);
    }
    @Test
    void selectStart() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new GameState(new Map(20,20)));
        controller.step(game, GUI.ACTION.SELECT, 100);
        Assertions.assertEquals(game.getState().getClass(), GameState.class);
    }
    @Test
    void selectHelp() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new HelpState(new Help()));
        controller.step(game, GUI.ACTION.SELECT, 100);
        Assertions.assertEquals(game.getState().getClass(), HelpState.class);
    }
    @Test
    void selectAbout() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new AboutState(new About()));
        controller.step(game, GUI.ACTION.SELECT, 100);
        Assertions.assertEquals(game.getState().getClass(), AboutState.class);
    }
}
