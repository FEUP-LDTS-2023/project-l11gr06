package com.ldts.supermario.viewer;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.GameOver;
import com.ldts.supermario.model.Position;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(24, 5), "GAME OVER", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(24, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}