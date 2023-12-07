package com.aor.supermario.viewer;

import com.aor.supermario.elements.Player;
import com.aor.supermario.gui.GUI;


public class PlayerViewer implements ElementViewer<Player>{
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}

