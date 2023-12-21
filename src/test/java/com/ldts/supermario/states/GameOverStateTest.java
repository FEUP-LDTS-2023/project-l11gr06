package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.GameOverController;
import com.ldts.supermario.model.GameOver;
import com.ldts.supermario.viewer.GameOverViewer;
import com.ldts.supermario.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GameOverStateTest {

    @Test
    void getViewer() {
        GameOver gameOver = new GameOver();
        GameOverState gameOverState = new GameOverState(gameOver);
        Viewer<GameOver> viewer = gameOverState.getViewer();
        assertEquals(GameOverViewer.class, viewer.getClass());
    }

    @Test
    void getController() {
        GameOver gameOver = new GameOver();
        GameOverState gameOverState = new GameOverState(gameOver);
        Viewer<GameOver> mockViewer = mock(GameOverViewer.class);
        Controller<GameOver> controller = gameOverState.getController();
        assertEquals(GameOverController.class, controller.getClass());
    }
}
