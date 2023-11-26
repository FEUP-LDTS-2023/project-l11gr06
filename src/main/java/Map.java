import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private Player player;
    //private List<Monster> monsters;
    private int width;
    private int height;
    private List<Ground> grounds;
    private List<Block> blocks;


    //private List<Coin> coins;
    public Map(int width,int height,Player player) {
        this.width = width;
        this.height = height;
        this.player=player;
        this.grounds = createGrounds();
        this.blocks = createBlocks();
        //this.coins = createCoins();
        //this.monsters = createMonsters();
    }

    private List<Ground> createGrounds() {
        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 175; c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 178; c <221;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 224; c <383;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 386; c <width;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }

        return grounds;
    }
    private List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(18, height - 7));
        return blocks;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Ground ground : grounds)
            ground.draw(graphics);
        for (Block block : blocks)
            block.draw(graphics);
        graphics.setCharacter(player.getPosition().getX(), player.getPosition().getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public boolean canPlayerMove(Position p)
    {
        for (Ground ground : grounds){
            if (ground.getPosition().equals(p)) return false;}
        return p.getX()<width-1 && p.getX()>0 && p.getY()<height-3 && p.getY()>0;

    }


    public void movePlayer(Position position) {
        player.setPosition(position);}


    public void processKey(KeyStroke key) {
        System.out.println(key);
        String keyT = key.getKeyType().toString();
        switch (keyT) {
            case "ArrowUp":
                movePlayer(player.moveUp());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "ArrowLeft":
                if(player.getPosition().getX()!=0)movePlayer(player.moveLeft());
                break;
            case "ArrowRight":
                if(player.getPosition().getX()< Game.width_game/2) movePlayer(player.moveRight());
                else
                {
                    for(Ground ground: grounds)
                    {
                        Position p = new Position(ground.getPosition().getX()-1,ground.getPosition().getY());
                        ground.setPosition(p);
                    }
                    for(Block block: blocks)
                    {
                        Position p = new Position(block.getPosition().getX()-1,block.getPosition().getY());
                        block.setPosition(p);
                    }
                }
                break;
        }
    }

}
