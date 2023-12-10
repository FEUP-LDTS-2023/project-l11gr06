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
        gui.drawText(new Position(24, 5), "GAME INSTRUCTIONS: ", "#FFFFFF");
        gui.drawText(new Position(15, 6), "     ", "#FFFFFF");
        gui.drawText(new Position(15, 7), "PRESS THE RIGHT OR LEFT ARROW TO RUN", "#FFFFFF");
        gui.drawText(new Position(15, 8), "PRESS THE UP ARROW TO JUMP", "#FFFFFF");
        gui.drawText(new Position(15, 9), "JUMP ON TOP OF THE ENEMIES TO KILL THEM", "#FFFFFF");
        gui.drawText(new Position(15, 10), "IF YOU BUMP INTO THEM, YOU DIE", "#FFFFFF");
        gui.drawText(new Position(15, 11), "AFTER 3 LIVES, YOU LOSE", "#FFFFFF");
        gui.drawText(new Position(15, 12), "REACH THE FINAL FLAG TO WIN THE GAME", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText( new Position(24, 14 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}