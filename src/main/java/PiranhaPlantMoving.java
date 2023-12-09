import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PiranhaPlantMoving implements Runnable{
    private Map map;
    private Game game;
    private Player player;

    public PiranhaPlantMoving(Map m, Game g, Player p)
    {
        map=m;
        game=g;
        player=p;
    }
    public void run() {
        List<Monster> l=new ArrayList<>();
        while(true) {
            for (Monster m : map.monstersToMove()) {
                if (m instanceof PiranhaPlant) {
                    l.add(m);
                }
            }
                    int state=0;
                    for(int i=0;i<3;i++) {
                        if(i==1)state=2;
                        else if(i==2)state=0;
                        for(int j=0;j<2;j++) {
                            try {
                                game.draw();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            for(Monster p: l)
                            {
                                ((PiranhaPlant) p).setOpenCloseState(state + 1);
                            }

                            try {
                                game.draw();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            for(Monster p: l)
                            {
                                ((PiranhaPlant) p).setOpenCloseState(state);
                            }
                            try {
                                game.draw();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                for(Monster p: l)
                {
                    ((PiranhaPlant) p).setOpenCloseState(4);
                }

                    try {
                        game.draw();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
