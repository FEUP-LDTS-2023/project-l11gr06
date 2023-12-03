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
            for(Monster m: map.monstersToMove()) {
                Thread t1 = new Thread(new Gravity(map,game,m));
                t1.start();
                if(map.collision_y(m)) {
                    if(m instanceof BrownMushroom || (m instanceof Turtle && ((Turtle) m).getState()==0) ) {
                        map.moveMonster(m);
                    }
                    else if (m instanceof Turtle && ((Turtle) m).getState()==2)
                    {
                        Thread t2 = new Thread(new TurtleMoving(map,game,m));
                        t2.start();
                    }
                        try {
                            game.draw();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                }
                if (map.monsterCollision(m))
                {
                    if(m instanceof Turtle && ((Turtle) m).getState()==1) ((Turtle) m).setState(2);
                    player.setPosition(new Position(player.getPosition().getX(),game.height_game-1));
                    return;
                }
                if(map.monsterDies(m)) break;
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
