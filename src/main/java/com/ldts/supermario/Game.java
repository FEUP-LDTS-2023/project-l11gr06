package com.ldts.supermario;

import com.ldts.supermario.controller.MonsterMoving;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.states.State;
import com.ldts.supermario.gui.LanternaGUI;
import com.ldts.supermario.model.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static int width_game = 60;
    public static int height_game = 21;
    private final LanternaGUI gui;
    private State state;
    public LanternaGUI getGui() {
        return gui;
    }

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(width_game, height_game);
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState(){return state;}

    public void run() throws IOException, URISyntaxException, FontFormatException {
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
