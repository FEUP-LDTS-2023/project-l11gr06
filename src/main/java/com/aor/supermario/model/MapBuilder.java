package com.aor.supermario.model;

import com.aor.supermario.elements.Player;

import java.util.List;

public abstract class MapBuilder {
    public Map createMap() {
        Map map = new Map(getWidth(), getHeight());

        Map.setPlayer(createPlayer());
        Map.setGrounds(createGrounds());
        Map.setBlocks(createBlocks());
        Map.setStairs(createStair());
        Map.setMysteryBlocks(createMysteryBlocks());
        Map.setCoins(createCoins());
        Map.setPipes(createPipes());
        Map.setGoalPoles(createGoalPole());
        Map.setRedMushrooms(createRedMushroom());
        //Map.setMonsters(createMonsters());

        return map;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<Map> createGrounds();
    protected abstract List<Map> createStair();
    protected abstract List<Map> createBlocks();
    protected abstract List<Map> createMysteryBlocks();
    protected abstract List<Map> createCoins();
    protected abstract List<Map> createPipes();
    protected abstract List<Map> createGoalPole();
    protected abstract List<Map> createRedMushroom();
    //protected abstract List<Map> createMonsters();
    protected abstract Player createPlayer();

}
