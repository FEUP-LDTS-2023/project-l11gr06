package com.ldts.supermario.controller;
import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.GameOverViewer;
import com.ldts.supermario.model.GameOver;
import com.ldts.supermario.model.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameOverControllerTest {
    private GameOver gameover;
    private GameOverViewer viewer;
    private GameOverController controller;
    private Game game;
    private int currentEntry;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        gameover = new GameOver();
        viewer = new GameOverViewer(gameover);
        controller = new GameOverController(gameover,viewer);
        game = mock(Game.class);
    }

    @Test
    void upGameOver() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        Assertions.assertEquals(controller.getModel().getCurrentEntry(),2);
    }
    @Test
    void downGameOver() throws IOException, URISyntaxException, FontFormatException {
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