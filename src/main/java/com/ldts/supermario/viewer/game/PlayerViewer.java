package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.Player;
import com.ldts.supermario.gui.GUI;


public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}

