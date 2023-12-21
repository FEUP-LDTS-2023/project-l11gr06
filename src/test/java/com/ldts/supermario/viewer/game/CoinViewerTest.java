package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.Coin;
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