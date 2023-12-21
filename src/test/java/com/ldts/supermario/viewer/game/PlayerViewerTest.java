package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class PlayerViewerTest {
    @Test
    void drawPlayer() {
        GUI gui = Mockito.mock(GUI.class);
        Player player = new Player(new Position(5, 10));
        PlayerViewer playerViewer = new PlayerViewer();
        playerViewer.draw(player, gui);

        verify(gui).drawPlayer(new Position(5, 10));
    }
}
