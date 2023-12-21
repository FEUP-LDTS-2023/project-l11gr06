package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.BrownMushroom;
import com.ldts.supermario.model.elements.Turtle;
import com.ldts.supermario.model.elements.TurtleShell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;


class MonsterViewerTest {

    @Test
    void drawTurtle() {
        GUI gui = Mockito.mock(GUI.class);
        Turtle turtle = new Turtle(new Position(5, 10));
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(turtle, gui);
        verify(gui).drawTurtle(new Position(5, 10));
    }

    @Test
    void drawTurtleShell() {
        GUI gui = Mockito.mock(GUI.class);
        TurtleShell turtleShell = new TurtleShell(new Position(8, 15));
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(turtleShell, gui);
        verify(gui).drawTurtleShell(new Position(8, 15));
    }

    @Test
    void drawBrownMushroom() {
        GUI gui = Mockito.mock(GUI.class);
        BrownMushroom brownMushroom = new BrownMushroom(new Position(12, 20));
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(brownMushroom, gui);
        verify(gui).drawBrownMushroom(new Position(12, 20));
    }
}
