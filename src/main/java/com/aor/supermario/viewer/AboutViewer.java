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
        gui.drawText(new Position(21, 5), "GAME DEVELOPED BY", "#FFFFFF");
        gui.drawText(new Position(21, 8), "DUARTE MARQUES", "#FFFFFF");
        gui.drawText(new Position(21, 10), "MARIA VIEIRA", "#FFFFFF");
        gui.drawText(new Position(21, 12), "MARTA CRUZ", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(21, 18 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}
