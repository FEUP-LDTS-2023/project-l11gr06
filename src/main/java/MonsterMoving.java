import java.io.IOException;

public class MonsterMoving implements Runnable{
    private Map map;
    private Game game;

    private Player player;
    public MonsterMoving(Map m, Game g, Player p)
    {
        map=m;
        game=g;
        player=p;
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
                if (map.monsterCollision(b))
                {
                    player.setPosition(new Position(player.getPosition().getX(),game.height_game-1));
                    return;
                }
                if(map.monsterDies(b)) break;
                try {
                    game.draw();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
