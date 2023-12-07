package com.aor.supermario.viewer;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Position;

public class AboutViewer extends Viewer<About> {
    public AboutViewer(About about) {
        super(about);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "TEXTO", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
