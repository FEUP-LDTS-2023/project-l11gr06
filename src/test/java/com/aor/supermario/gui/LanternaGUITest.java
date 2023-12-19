package com.aor.supermario.gui;

import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.MysteryBlock;
import com.aor.supermario.gui.*;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    public void getNextActionTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        GUI.ACTION action;

        Mockito.when(screen.pollInput()).thenReturn(null);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.NONE, action);

        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.QUIT, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.UP, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.DOWN, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.SELECT, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('q');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.QUIT, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('X');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPR, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('x');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPR, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('Z');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPL, action);

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('z');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPL, action);


    }

    @Test
    void drawPlayer() {
        gui.drawPlayer(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "+");
    }
    @Test
    void drawGround() {
        gui.drawGround(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "%");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "M");
    }
    @Test
    void drawBlock() {
        gui.drawBlock(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "&");
    }
    @Test
    void drawMysteryBlock0() {
        MysteryBlock mb= new MysteryBlock(1,1);
        mb.setMysteryState(0);
        gui.drawMysteryBlock(mb,new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FED000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }
    @Test
    void drawMysteryBlock1() {
        MysteryBlock mb= new MysteryBlock(1,1);
        mb.setMysteryState(1);
        gui.drawMysteryBlock(mb,new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "]");
    }
    @Test
    void drawStair() {
        gui.drawStair(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }
    @Test
    void drawPipe() {
        gui.drawPipe(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "<");
    }
    @Test
    void drawRedMushroom() {
        gui.drawRedMushroom(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "=");
    }
    @Test
    void drawCoin() {
        gui.drawCoin(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FED000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, ">");
    }
    @Test
    void drawGoalPole1() {
        gui.drawGoalPole(new Position(1, 7));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF007F"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 8, "[");
    }
    @Test
    void drawGoalPole2() {
        gui.drawGoalPole(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF007F"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "I");
    }
    @Test
    void drawBrownMushroom() {
        gui.drawBrownMushroom(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#9400D3"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "/");
    }
    @Test
    void drawTurtle() {
        gui.drawTurtle(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "~");
    }
    @Test
    void drawTurtleShell() {
        gui.drawTurtleShell(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "^");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void testClear() {
        gui.clear();

        Mockito.verify(screen).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();

        Mockito.verify(screen).close();
    }
}