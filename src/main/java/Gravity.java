import java.io.IOException;

public class Gravity implements Runnable {
    private Map map;
    private Game game;

    private Element element;
    public Gravity(Map m, Game g, Element e)
    {
        map=m;
        game=g;
        element=e;
    }
    public void run() {
        while(element.getPosition().getY()!=game.height_game)
        {
            if(element.getPosition().getY()==game.height_game-1 && element instanceof Player) return;
            if(map.collision_y(element)) break;
            Position p = new Position(element.getPosition().getX(),element.getPosition().getY()+1);
            element.setPosition(p);
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
