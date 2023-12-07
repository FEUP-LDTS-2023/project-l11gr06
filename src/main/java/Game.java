import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game{

    public static int width_game = 65;
    public static int height_game = 20;
    public Player player = new Player(3, height_game-4);

    public Map map = new Map(585,20,player);
    private final TerminalScreen screen;
    private Terminal terminal;
    public Game(int w,int h) throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(w, h)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);// we don’t need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        TerminalSize terminalSize = new TerminalSize(w, h);
        TextGraphics graphics = screen.newTextGraphics();
    }



    public void draw() throws IOException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        player.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void runGame() throws IOException {
        Thread t1 = new Thread(new MonsterMoving(map,this,player));
        t1.start();
        Thread t_ = new Thread(new PiranhaPlantMoving(map,this,player));
        t_.start();
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
            long t = System.currentTimeMillis();
            boolean salto = false;
            KeyStroke k=key;
            if (key.getKeyType().toString() == "ArrowUp")
            {
                k = key;
                salto = true;
                processKey(key);
            }
            key = screen.readInput();
            if ((key.getKeyType().toString() == "ArrowRight"||key.getKeyType().toString() == "ArrowLeft") && salto)
            {
                salto = false;
                if(System.currentTimeMillis()<t+500)
                {
                    processKey(key);
                    draw();
                    if(!map.break_block()) {
                        for (int i = 0; i < 4; i++) {
                            processKey(k);
                            processKey(key);
                            draw();
                            if (map.break_block()) break;
                        }
                    }
                }
            }

            if (salto)
            {
                draw();
                for(int i=1; i<=4;i++)
                {
                    processKey(key);
                    draw();
                    if(map.break_block())break;

                }
            }
            else processKey(key);
            Thread t2 = new Thread(new Gravity(map,this,player));
            t2.start();
            if(player.getPosition().getY()==height_game-1)
            {
                terminal.close();
                return;
            }


        }
    }
    private void processKey(KeyStroke key) {
        map.processKey(key);
    }
}