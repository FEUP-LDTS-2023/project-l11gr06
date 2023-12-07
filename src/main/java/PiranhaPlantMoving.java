import java.io.IOException;

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
        while(true) {
            for (Monster m : map.monstersToMove()) {
                if (m instanceof PiranhaPlant) {
                    Monster pl = m;
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
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            ((PiranhaPlant) m).setOpenCloseState(state + 1);
                            try {
                                game.draw();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            ((PiranhaPlant) m).setOpenCloseState(state);
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
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    ((PiranhaPlant) m).setOpenCloseState(4);
                    try {
                        game.draw();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
