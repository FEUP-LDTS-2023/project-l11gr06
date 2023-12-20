package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Coin;
import com.aor.supermario.viewer.game.CoinViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class CoinViewerTest {

    @Test
    void drawBlock() {
        GUI gui = Mockito.mock(GUI.class);
        Coin coin = new Coin(new Position(5, 10));
        CoinViewer coinViewer = new CoinViewer();
        coinViewer.draw(coin, gui);

        verify(gui).drawCoin(new Position(5, 10));
    }
}