package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.GameOverViewer;
import com.aor.supermario.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MapControllerTest {
    private GameOver gameover;
    private GameOverViewer viewer;
    private GameOverController controller;
    private Game game;
    private int currentEntry;
    private MapController mapController;
    private Map mapMock;
    private Viewer viewerMock;
    private PlayerController playerControllerMock;
    private MonsterController monsterControllerMock;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        gameover = new GameOver();
        viewer = new GameOverViewer(gameover);
        controller = new GameOverController(gameover, viewer);
        game = new Game();
        mapMock = mock(Map.class);
        viewerMock = mock(Viewer.class);
        playerControllerMock = mock(PlayerController.class);
        monsterControllerMock = mock(MonsterController.class);
        mapController = new MapController(mapMock, viewerMock);
    }

    @Test
    void quit() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(game.getState().getClass(), MenuState.class);
    }

}
