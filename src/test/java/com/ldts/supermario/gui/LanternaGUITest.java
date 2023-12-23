package com.ldts.supermario.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.MysteryBlock;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;
    private Terminal terminal;


    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        terminal = Mockito.mock(Terminal.class);
        when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }

    @Test
    void testLoadSquareFont() throws IOException, URISyntaxException, FontFormatException {
        LanternaGUI lanternaGUI = new LanternaGUI(screen);
        AWTTerminalFontConfiguration fontConfig = lanternaGUI.loadSquareFont();
        assertNotNull(fontConfig);
    }


    @Test
    public void getNextActionTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        GUI.ACTION action;

        when(screen.pollInput()).thenReturn(null);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.NONE, action);

        when(screen.pollInput()).thenReturn(keyStroke);
        when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.QUIT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.UP, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.DOWN, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.SELECT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('q');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.QUIT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('X');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPR, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('x');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPR, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('Z');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPL, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('z');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.JUMPL, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('A');
        action = gui.getNextAction();
        Assertions.assertEquals(GUI.ACTION.NONE, action);
    }

    @Test
    void drawPlayer() {
        gui.drawPlayer(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        verify(tg, times(1)).putString(1, 2, "+");
    }
    @Test
    void drawGround() {
        gui.drawGround(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        verify(tg, times(1)).putString(1, 2, "%");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        verify(tg, times(1)).putString(1, 2, "M");
    }
    @Test
    void drawBlock() {
        gui.drawBlock(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        verify(tg, times(1)).putString(1, 2, "&");
    }
    @Test
    void drawMysteryBlock0() {
        MysteryBlock mb= new MysteryBlock(1,1);
        mb.setMysteryState(0);
        gui.drawMysteryBlock(mb,new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FED000"));
        verify(tg, times(1)).putString(1, 2, "#");
    }
    @Test
    void drawMysteryBlock1() {
        MysteryBlock mb= new MysteryBlock(1,1);
        mb.setMysteryState(1);
        gui.drawMysteryBlock(mb,new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        verify(tg, times(1)).putString(1, 2, "]");
    }
    @Test
    void drawStair() {
        gui.drawStair(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF6400"));
        verify(tg, times(1)).putString(1, 2, "$");
    }
    @Test
    void drawPipe() {
        gui.drawPipe(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        verify(tg, times(1)).putString(1, 2, "<");
    }
    @Test
    void drawRedMushroom() {
        gui.drawRedMushroom(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        verify(tg, times(1)).putString(1, 2, "=");
    }
    @Test
    void drawCoin() {
        gui.drawCoin(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FED000"));
        verify(tg, times(1)).putString(1, 2, ">");
    }
    @Test
    void drawGoalPole1() {
        gui.drawGoalPole(new Position(1, 7));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF007F"));
        verify(tg, times(1)).putString(1, 8, "[");
    }
    @Test
    void drawGoalPole2() {
        gui.drawGoalPole(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF007F"));
        verify(tg, times(1)).putString(1, 2, "I");
    }
    @Test
    void drawBrownMushroom() {
        gui.drawBrownMushroom(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#9400D3"));
        verify(tg, times(1)).putString(1, 2, "/");
    }
    @Test
    void drawTurtle() {
        gui.drawTurtle(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        verify(tg, times(1)).putString(1, 2, "~");
    }
    @Test
    void drawTurtleShell() {
        gui.drawTurtleShell(new Position(1, 1));

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        verify(tg, times(1)).putString(1, 2, "^");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        verify(tg, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(tg, times(1)).putString(1, 1, "Hello World");

        gui.drawText(new Position(2, 2), "Another Text", "#FF0000");
        verify(tg, times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        verify(tg, times(1)).putString(2, 2, "Another Text");
    }

    @Test
    void testClear() {
        gui.clear();

        verify(screen).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();

        verify(screen).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();

        verify(screen).close();
    }
}