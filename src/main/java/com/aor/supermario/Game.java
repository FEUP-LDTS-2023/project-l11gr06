package com.aor.supermario;

import com.aor.supermario.model.elements.Block;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.states.State;
import com.aor.supermario.gui.LanternaGUI;
import com.aor.supermario.model.Menu;
import com.aor.supermario.model.Map;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static int width_game = 65;
    public static int height_game = 20;

    //public static int map_width=250;
    //public static int map_height=20;

    //public Map map = new Map(250,20);
    public int points = 0;
    private final LanternaGUI gui;
    private State state;

    public LanternaGUI getGui() {
        return gui;
    }

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(width_game, height_game);
        this.state = new MenuState(new Menu());
    }
    /*
    public Game(int w,int h) throws IOException {
        //Terminal terminal = new DefaultTerminalFactory().createTerminal();
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(w, h)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);// we don’t need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        TerminalSize terminalSize = new TerminalSize(w, h);
        TextGraphics graphics = screen.newTextGraphics();
        // DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    }*/

    public void setState(State state) {
        this.state = state;
    }
/*
    private void draw() throws IOException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        player.draw(screen.newTextGraphics());
        screen.refresh();
    }
*/

    /*
    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }*/

    public void run() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}

    /*
            long t = System.currentTimeMillis();
            boolean saltovertical = false;

            if (key.getKeyType().toString() == "ArrowUp")
            {
                k = key;
                salto = true;
                processKey(key);
            }
            key = screen.readInput();
            if ((key.getKeyType().toString() == "ArrowRight"||key.getKeyType().toString() == "ArrowLeft") && salto)
            {
                salto = false;
                if(System.currentTimeMillis()<t+500)
                {
                    processKey(key);
                    draw();
                    if(!map.break_block()) {
                        for (int i = 0; i < 4; i++) {
                            processKey(k);
                            processKey(key);
                            draw();
                            if (map.break_block()) break;
                        }
                    }
                }
            }

            if (salto)
            {
                draw();
                for(int i=1; i<=4;i++)
                {
                    processKey(key);
                    draw();
                    if(map.break_block())break;
                    if (map.reveal_mysteryblock()) {
                        break;
                    }

                }
            }
            else {
                processKey(key);
                if (map.collect_coins()) {
                    points+=100;
                    draw();
            }
                if (map.collect_mushroom()) {
                    points+=1000;
                    draw();
                }
            }
            while(player.getPosition().getY()!=height_game)
            {
                if (map.collect_coins()) {
                    points+=100;
                    draw();
                }
                if (map.collect_mushroom()) {
                    points+=1000;
                    draw();
                }
                if(player.getPosition().getY()==height_game-1)
                {
                    terminal.close();
                    return;
                }
                if(map.collision_y()) break;
                Position p = new Position(player.getPosition().getX(),player.getPosition().getY()+1);
                player.setPosition(p);
                draw();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
        gui.close();
    }

}*/