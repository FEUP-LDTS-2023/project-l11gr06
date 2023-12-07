package com.aor.supermario.viewer.game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.aor.supermario.elements.Element;
import com.aor.supermario.viewer.*;

import java.util.List;

public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getGrounds(), new GroundViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());
        drawElements(gui, getModel().getMysteryBlocks(), new MysteryBlockViewer());
        drawElements(gui, getModel().getGoalPole(), new GoalPoleViewer());
        drawElements(gui, getModel().getPipes(), new PipeViewer());
        drawElements(gui, getModel().getRedMushrooms(), new RedMushroomViewer());
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());

        gui.drawText(new Position(10, 0), "Points: " + getModel().getPlayer().getPoints(), "#FFD700");
        //gui.drawText(new Position(0, 0), "Lives: " + getModel().getPlayer().getlives(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}