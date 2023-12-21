package com.ldts.supermario.viewer;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.Victory;

public class VictoryViewer extends Viewer<Victory> {
    public VictoryViewer(Victory victory) {
        super(victory);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(24, 5), "YOU @ON", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(24, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}