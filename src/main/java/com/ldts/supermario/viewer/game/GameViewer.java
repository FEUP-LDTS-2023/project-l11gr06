package com.ldts.supermario.viewer.game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.Element;
import com.ldts.supermario.viewer.Viewer;

import java.util.List;

import static com.ldts.supermario.Main.lives;

public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }
    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getGrounds(), new GroundViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());
        drawElements(gui, getModel().getGoalPole(), new GoalPoleViewer());
        drawElements(gui, getModel().getPipes(), new PipeViewer());
        drawElements(gui, getModel().getRedMushrooms(), new RedMushroomViewer());
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        drawElements(gui, getModel().getMysteryBlocks(), new MysteryBlockViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());

        gui.drawText(new Position(10, 2), "SCORE  " + getModel().getPlayer().getPoints(), "#FFD700");
        gui.drawText(new Position(43, 2), "LIVES  " + lives, "#FFD700");

    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}