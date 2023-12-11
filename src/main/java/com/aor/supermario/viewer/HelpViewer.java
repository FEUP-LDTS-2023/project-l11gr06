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
        gui.drawText(new Position(20, 2), "GAME INSTRUCTIONS ", "#FFFFFF");
        gui.drawText(new Position(2, 5), "PRESS THE RIGHT OR LEFT ARRO@ TO RUN AND UP ARRO@ TO JUMP", "#FFFFFF");
        gui.drawText(new Position(2, 7), "PRESS X TO DO A FRONT JUMP AND Z TO DO A BACK JUMP", "#FFFFFF");
        gui.drawText(new Position(2, 9), "JUMP ON TOP OF THE ENEMIES TO KILL THEM", "#FFFFFF");
        gui.drawText(new Position(2, 11), "IF YOU BUMP INTO ONE OF THE MONSTERS YOU DIE", "#FFFFFF");
        gui.drawText(new Position(2, 13), "IF YOU ARE DONE PLAYING PRESS Q TO RETURN TO MENU", "#FFFFFF");
        gui.drawText(new Position(2, 15), "REACH THE FINAL FLAG TO @IN THE GAME", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(21, 18 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}