package com.aor.supermario.controller;
import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MapControllerTest {
    private Map map;
    private GameViewer viewer;
    private MapController controller;
    private Game game;

    private Map mapMock;
    private Viewer viewerMock;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        map = new Map(20,20);
        viewer = new GameViewer(map) ;
        controller = new MapController(map, viewer);
        game = new Game();
        mapMock = mock(Map.class);
        viewerMock = mock(Viewer.class);
    }
    /*@Test
    void testConstructor() {

        MapController mapController = new MapController(mapMock, viewerMock);
        assertEquals(mapMock, mapController.getModel());
        assertEquals(viewerMock, mapController.getViewer());
    }
     */
    @Test
    void selectQuit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.QUIT, 100);
        assertEquals(game.getState().getClass(),MenuState.class);
    }


}
