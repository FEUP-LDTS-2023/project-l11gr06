package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.AboutState;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.HelpState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {
    private Menu menu;
    private MenuViewer viewer;
    private MenuController controller;
    private Game game;
    private int currentEntry;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new Menu();
        viewer = new MenuViewer(menu);
        controller = new MenuController(menu,viewer);
        game=new Game();
    }

    @Test
    void upMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(controller.getModel().getCurrentEntry(),3);
    }
    @Test
    void downMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        assertEquals(controller.getModel().getCurrentEntry(),1);
    }
    @Test
    void selectStart() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), GameState.class);
    }
    @Test
    void selectHelp() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), HelpState.class);
    }
    @Test
    void selectAbout() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.DOWN, 100);
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(), AboutState.class);
    }

}
