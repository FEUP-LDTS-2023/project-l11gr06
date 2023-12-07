package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Coin;
import com.aor.supermario.elements.Element;
import com.aor.supermario.gui.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(Element.getPosition());
    }
}