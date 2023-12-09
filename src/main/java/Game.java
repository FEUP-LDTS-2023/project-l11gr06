import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private KeyStroke key;

    public static int width_game = 65;
    public static int height_game = 20;
    public Player player = new Player(3, height_game-4);

    public Map map = new Map(250,20,player);
    public int points=0;
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
        // DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    }

    public KeyStroke getKey()
    {
        return key;
    }

    public void draw() throws IOException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        player.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void runGame() throws IOException {
        Thread t1 = new Thread(new MonsterMoving(map, this, player, terminal));
        t1.start();
        Thread t2 = new Thread(new PiranhaPlantMoving(map, this, player));
        t2.start();
        while (true) {
            for (Monster m : map.monstersToMove()) {
                if(map.monsterDies(m))
                {   draw();
                    break;}
                else if (map.monsterCollision(m)) {
                    if (m instanceof Turtle) {
                        if (((Turtle) m).getState() == 1) ((Turtle) m).setState(2);
                        else terminal.close();
                    }
                }
            }
            draw();
            key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'x' || key.getCharacter() == 'X'
                    || key.getCharacter() == 'z' || key.getCharacter() == 'Z')) {
                int x = 0;
                while (x < 4) {
                    draw();
                    if (map.break_block()) {
                        draw();
                        break;
                    }
                    if (map.reveal_mysteryblock()) {
                        draw();
                        break;
                    }
                    map.movePlayer(player.moveUp());
                    x++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if (map.collision_x_front(player)) break;
                    processKey(key);
                    draw();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (key.getKeyType().toString() == "ArrowUp") {
                int x = 0;
                while (x < 5) {
                    if (map.break_block()) break;
                    if (map.reveal_mysteryblock()) {
                        break;
                    }
                    processKey(key);
                    draw();
                    x++;
                }
            } else processKey(key);
            while (player.getPosition().getY() != height_game-1) {

                if (map.collision_y(player)) break;
                Position p = new Position(player.getPosition().getX(), player.getPosition().getY() + 1);
                player.setPosition(p);
                draw();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (map.collect_coins()) {
                points += 100;
                draw();
            }
            if (map.collect_mushroom()) {
                points += 1000;
                draw();
            }
            if (player.getPosition().getY() == height_game - 1) {
                t1.interrupt();
                t2.interrupt();
                terminal.close();

                return;
            }


        }
    }
    public void processKey(KeyStroke key) throws IOException {
        map.processKey(key);
    }
}