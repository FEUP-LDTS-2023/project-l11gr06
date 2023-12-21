package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.Coin;
import com.ldts.supermario.gui.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}