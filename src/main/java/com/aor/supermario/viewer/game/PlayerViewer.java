package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Player;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.viewer.game.ElementViewer;


public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}

