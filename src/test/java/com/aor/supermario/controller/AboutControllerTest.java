package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.About;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.AboutViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutControllerTest {
    private About about;
    private AboutViewer viewer;
    private AboutController controller;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        about = new About();
        viewer = new AboutViewer(about);
        controller = new AboutController(about,viewer);
        game=new Game();
    }
    @Test
    void selectMenu() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT, 100);
        assertEquals(game.getState().getClass(),MenuState.class);
    }
}