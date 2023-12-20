package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Ground;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MonsterMovingTest {

    private Map map;
    private Viewer viewer;
    private Game game;
    private MonsterMoving monsterMoving;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        map = new Map(20, 20);
        //game= new Game();
        //viewer = new GameViewer(map);
        viewer = mock(Viewer.class);
        game = mock(Game.class);
        monsterMoving = new MonsterMoving(map, viewer, game);
        map.setStairs(Arrays.asList());
        map.setBlocks(Arrays.asList());
        map.setMysteryBlocks(Arrays.asList());
        map.setCoins(Arrays.asList());
        map.setPipes(Arrays.asList());
        map.setRedMushrooms(Arrays.asList());
        map.setGoalPoles(Arrays.asList());
        map.setMonsters(Arrays.asList());
        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 20; c++) {
            grounds.add(new Ground(c, 19));
            grounds.add(new Ground(c, 18));
            grounds.add(new Ground(c, 17));
        }
        map.setGrounds(grounds);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new BrownMushroom(5, 16));
        map.setMonsters(monsters);
    }

    @Test
    void testMonsterstoMove() throws InterruptedException, IOException {
        Thread monsterMovingThread = new Thread(monsterMoving);
        monsterMovingThread.start();
        Thread.sleep(1000);
        assertEquals(map.monstersToMove().size(), map.getMonsters().size());
        monsterMovingThread.interrupt();
        monsterMovingThread.join();
    }
    @Test
    void isMonsterMoving() throws InterruptedException, IOException {
        Thread monsterMovingThread = new Thread(monsterMoving);
        monsterMovingThread.start();
        Thread.sleep(100);
        assertEquals(map.monstersToMove().get(0).getPosition(), new Position(4, 16));
        monsterMovingThread.interrupt();
        monsterMovingThread.join();
    }

}


