package com.aor.supermario.viewer;


import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.model.elements.Ground;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(map);
        map.setGrounds(Arrays.asList(new Ground(2, 18), new Ground(2, 17)));
        map.setMonsters(Arrays.asList(new BrownMushroom(4, 16), new BrownMushroom(5, 16)));
        map.setPlayer(new Player(2, 16));
    }


    @Test
    void drawGrounds() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawGround(new Position(2, 18));
        Mockito.verify(gui, Mockito.times(1)).drawGround(new Position(2, 17));
        Mockito.verify(gui, Mockito.times(3)).drawGround(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawMonster(Mockito.any(Position.class));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}