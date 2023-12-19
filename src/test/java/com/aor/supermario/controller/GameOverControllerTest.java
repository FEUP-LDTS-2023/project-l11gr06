package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        game=new Game();
    }

    @Test
    void upGameOver() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(controller.getModel().getCurrentEntry(),2);
    }
    @Test
    void downGameOver() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        assertEquals(controller.getModel().getCurrentEntry(),1);
    }
    @Test
    void selectRestart() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), GameState.class);
    }
    @Test
    void selectMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), MenuState.class);
    }

}