package com.ldts.supermario.controller;
import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.VictoryViewer;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.Victory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VictoryControllerTest {
    private Victory victory;
    private VictoryViewer viewer;
    private VictoryController controller;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        victory = new Victory();
        controller = new VictoryController(victory,viewer);
        game= Mockito.mock(Game.class);
        viewer = Mockito.mock(VictoryViewer.class);


    }

    @Test
    void upVictory() throws IOException, URISyntaxException, FontFormatException {

        controller.step(game, GUI.ACTION.UP, 100);
        Assertions.assertEquals(controller.getModel().getCurrentEntry(),2);
    }
    @Test
    void downVictory() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        Assertions.assertEquals(controller.getModel().getCurrentEntry(),1);
    }

    @Test
    void selectRestart() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new GameState(new Map(20,20)));
        controller.step(game, GUI.ACTION.SELECT, 100);
        Assertions.assertEquals(game.getState().getClass(), GameState.class);
    }
    @Test
    void selectMenu() throws IOException, URISyntaxException, FontFormatException {
        when(game.getState()).thenReturn(new MenuState(new Menu()));
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.SELECT, 100);
        Assertions.assertEquals(game.getState().getClass(), MenuState.class);
    }

}