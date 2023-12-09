package com.aor.supermario.viewer;


import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Menu;
import com.aor.supermario.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "SUPER MARIO", "#FFFFFF");
        gui.drawText(new Position(5, 6), "BROS.", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}
