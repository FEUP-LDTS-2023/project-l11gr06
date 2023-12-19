package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.controller.PlayerController;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.elements.*;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {
    private PlayerController controller;
    private Viewer viewer;
    private Player player;
    private Game game;
    private Map map;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {

        map = new Map(20, 20);
        game= Mockito.mock(Game.class);
        viewer = Mockito.mock(GameViewer.class);
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
    void movePlayerRightEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT, 100);
        assertEquals(new Position(7, 15), player.getPosition());
    }
    @Test
    void movePlayerLeftEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.LEFT, 100);
        assertEquals(new Position(5, 15), player.getPosition());
    }
    @Test
    void movePlayerUpEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(new Position(6, 11), player.getPosition());
    }
    @Test
    void movePlayerJumpRightEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.JUMPR, 100);
        assertEquals(new Position(10, 11), player.getPosition());
    }
    @Test
    void movePlayerJumpLeftEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.JUMPL, 100);
        assertEquals(new Position(2, 11), player.getPosition());
    }


    @Test
    void movePlayerRightNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setStairs(Arrays.asList(new Stair(7, 15)));
        controller.step(game, GUI.ACTION.RIGHT, 100);
        assertEquals(new Position(6,15), player.getPosition());
    }
    @Test
    void moveHeroLeftNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setStairs(Arrays.asList(new Stair(5, 15)));
        controller.step(game, GUI.ACTION.LEFT, 100);
        assertEquals(new Position(6,15), player.getPosition());
    }
    @Test
    void movePlayerUpNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setMysteryBlocks(Arrays.asList(new MysteryBlock(6, 13)));
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(new Position(6,13), player.getPosition());
    }
}