package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.VictoryViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VictoryControllerTest {
    private Victory victory;
    private VictoryViewer viewer;
    private VictoryController controller;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        victory = new Victory();
        viewer = new VictoryViewer(victory);
        controller = new VictoryController(victory,viewer);
        game=new Game();
    }
    @Test
    void upVictory() throws IOException, URISyntaxException, FontFormatException {

        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(controller.getModel().getCurrentEntry(),2);
    }
    @Test
    void downVictory() throws IOException, URISyntaxException, FontFormatException {
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