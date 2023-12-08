package com.aor.supermario.gui;

import com.aor.supermario.Game;
import com.aor.supermario.model.elements.MysteryBlock;
import com.aor.supermario.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        //graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/pixelbabania-vi-deluxe-light.ttf");
        //assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) {
            boolean salto=false;
            return ACTION.UP;
        }
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        return ACTION.NONE;
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#FFFF33");
    }
    @Override
    public void drawGround(Position position) {
        drawCharacter(position.getX(), position.getY(), '_', "#3333FF");
    }

    //@Override
    //public void drawMonster(Position position) {
    //    drawCharacter(position.getX(), position.getY(), 'M', "#CC0000");
    //}
    @Override
    public void drawBlock(Position position) {
        drawCharacter(position.getX(), position.getY(), 'B',"#8A3324");
    }
    @Override
    public void drawMysteryBlock(Position position) {
        if (MysteryBlock.getMysteryState() == 0) {
            drawCharacter(position.getX(), position.getY(), '?', "#8A3324");
        } else {
            drawCharacter(position.getX(), position.getY(), '!', "#8A3324");
        }
    }
    @Override
    public void drawStair(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#8A3324");
    }
    @Override
    public void drawPipe(Position position) {
        drawCharacter(position.getX(), position.getY(), 'P', "#8A3324");
    }
    @Override
    public void drawRedMushroom(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#8A3324");
    }
    @Override
    public void drawCoin(Position position) {
        drawCharacter(position.getX(), position.getY(), '0', "#8A3324");
    }
    @Override
    public void drawGoalPole(Position position) {
        if(position.getY() == Game.height_game-13)
            drawCharacter(position.getX(), position.getY(), '<', "#8A3324");
        else
        {
            drawCharacter(position.getX(), position.getY(), '|', "#8A3324");
        }
    }
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
