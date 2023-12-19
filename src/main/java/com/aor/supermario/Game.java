package com.aor.supermario;

import com.aor.supermario.controller.MonsterMoving;
import com.aor.supermario.model.elements.Block;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.states.State;
import com.aor.supermario.gui.LanternaGUI;
import com.aor.supermario.model.Menu;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.game.MonsterViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

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

        int i=0;
        while (this.state != null) {
            if (state instanceof GameState && i==0) {
                Thread t1 = new Thread(new MonsterMoving(
                        ((GameState) state).getViewer().getModel(),
                        ((GameState) state).getViewer(),
                        this));
                t1.start();
                i = 1;
            }
            else if(!(state instanceof GameState)) i=0;
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

   /*               if (map.collect_coins())
                    points+=100;
                    draw();

                if (map.collect_mushroom())
                    points+=1000;
                    draw();
   */