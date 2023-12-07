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
        gui.drawText(new Position(5, 5), "Game Instructions:", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}