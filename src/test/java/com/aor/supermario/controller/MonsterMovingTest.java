package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterMovingTest {
    /*private PlayerController controller;
    private Viewer viewer;
    private Player player;
    private Game game;
    private Map map;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        map = new Map(20, 20);
        game = new Game();
        viewer = new GameViewer(map);
        player = new Player(6, 15);
        map.setPlayer(player);
        map.setGrounds(Arrays.asList());
        map.setStairs(Arrays.asList());
        map.setBlocks(Arrays.asList());
        map.setMysteryBlocks(Arrays.asList());
        map.setCoins(Arrays.asList());
        map.setPipes(Arrays.asList());
        map.setRedMushrooms(Arrays.asList());
        map.setGoalPoles(Arrays.asList());
        map.setMonsters(Arrays.asList());

        controller = new PlayerController(map, viewer);
    }

    @Test
    void testMonsterMoving() throws InterruptedException {
        map.getMonsters().add(new BrownMushroom(25, 20 - 4));
        MonsterMoving monsterMoving = new MonsterMoving(map, viewer, game);
        Position old_p = map.monstersToMove().get(0).getPosition();

        // Create a thread to run MonsterMoving
        Thread monsterMovingThread = new Thread(monsterMoving);
        monsterMovingThread.start();

        // Allow some time for the thread to execute
        Thread.sleep(900); // Adjust this time according to your requirements

        // Interrupt the thread to stop the loop
        monsterMovingThread.interrupt();

        // Wait for the MonsterMoving thread to finish
        monsterMovingThread.join();

        // Assertions based on the expected behavior
        Position p = new Position(map.monstersToMove().get(0).getPosition().getX()-1,map.monstersToMove().get(0).getPosition().getY());
        assertEquals(old_p,p);
    }*/
}

