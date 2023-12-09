package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Position;

public class HelpViewer extends Viewer<Help> {
    public HelpViewer(Help help) {
        super(help);
    }


    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Game Instructions: ", "#FFFFFF");
        gui.drawText(new Position(5, 6), "     ", "#FFFFFF");
        gui.drawText(new Position(5, 7), "Press the right or left arrow to run", "#FFFFFF");
        gui.drawText(new Position(5, 8), "Press the up arrow to jump", "#FFFFFF");
        gui.drawText(new Position(5, 9), "Jump on top of the enemies to kill them", "#FFFFFF");
        gui.drawText(new Position(5, 10), "If you bump into them, you die", "#FFFFFF");
        gui.drawText(new Position(5, 11), "After 3 lives, you lose", "#FFFFFF");
        gui.drawText(new Position(5, 12), "Reach the final flag to win the game", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(5, 14 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}