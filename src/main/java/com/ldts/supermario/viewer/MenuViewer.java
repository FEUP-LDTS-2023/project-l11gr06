package com.ldts.supermario.viewer;


import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.Menu;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(24, 5), "SUPER MARIO", "#FFFFFF");
        gui.drawText(new Position(24, 6), "BROS", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(24, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}
