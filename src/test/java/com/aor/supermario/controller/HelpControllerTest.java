package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Help;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.HelpViewer;
import com.aor.supermario.viewer.HelpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        game=new Game();
    }
    @Test
    void selectMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(),MenuState.class);
    }
}