import java.io.IOException;

public class TurtleMoving implements Runnable{
    Monster monster;
    Map map;
    Game game;
    public TurtleMoving(Map m, Game g, Monster mt)
    {
        map=m;
        game=g;
        monster=mt;
    }
    @Override
    public void run() {
        while(((Turtle) monster).getState()==2)
        {
            map.moveMonster(monster);
            try {
                game.draw();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
