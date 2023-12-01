package org.example;

import java.io.IOException;

public class MonsterMoving implements Runnable{
    private Map map;
    private Game game;
    public MonsterMoving(Map m, Game g)
    {
        map=m;
        game=g;
    }
    public void run() {
        while(true)
        {
            for(BrownMushroom b: map.monstersToMove()) {
                Thread t1 = new Thread(new Gravity(map,game,b));
                t1.start();
                if(map.collision_y(b)) {
                    map.moveMonster(b);
                    try {
                        game.draw();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            try {
                game.draw();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
