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

    private List<Stair> stairs;

    private List<GoalPole> poles;
    private List<MysteryBlock> mysteryBlocks;
    private List<Coin> coins;
    private List<RedMushroom> redMushrooms;


    //private List<Coin> coins;
    public Map(int width,int height,Player player) {
        this.width = width;
        this.height = height;
        this.player=player;
        this.grounds = createGrounds();

        this.blocks = createBlocks();
        this.stairs = createStairs();
        this.poles = createPoles();
        this.mysteryBlocks = createMystery();
        this.coins = createCoins();
        this.redMushrooms = createRedMushrooms();
        //this.monsters = createMonsters();
    }
    private List<GoalPole> createPoles()
    {
        List<GoalPole> poles = new ArrayList<>();
        for(int i = 0; i < 9;i++) poles.add(new GoalPole(202,height-5-i));
        return poles;
    }

    private List<Ground> createGrounds() {
        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 71; c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 74; c <89;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 92; c <156;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 159; c <width;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }

        return grounds;
    }
    private List<Stair> createStairs() {
        List<Stair> stairs = new ArrayList<>();

        int i =0;
        for(int c = 137; c <141;c++) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }

        i =0;
        for(int c = 147; c > 143;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        i =0;
        for(int c = 151; c <156;c++) {
            if(c!=155)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }

        i =0;
        for(int c = 163; c >159;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        i =0;
        for(int c = 185; c <194;c++) {
            if(c!=193)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        stairs.add(new Stair(202,height-4));
        return stairs;
    }

    private List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(22, height - 7));
        blocks.add(new Block(24, height - 7));
        blocks.add(new Block(26, height - 7));
        blocks.add(new Block(80, height - 7));
        blocks.add(new Block(82, height - 7));
        for(int i = 83; i<=90;i++) blocks.add(new Block(i, height - 12));
        for(int i = 94; i<=96;i++) blocks.add(new Block(i, height - 12));
        blocks.add(new Block(97, height - 7)); //TEM COIN
        blocks.add(new Block(103, height - 7));
        blocks.add(new Block(104, height - 7)); //TEM ESTRELA
        blocks.add(new Block(121, height - 7));
        for(int i = 124; i<=126;i++) blocks.add(new Block(i, height - 12));
        blocks.add(new Block(131, height - 12));
        blocks.add(new Block(132, height - 7));
        blocks.add(new Block(133, height - 7));
        blocks.add(new Block(134, height - 12));
        blocks.add(new Block(172, height - 7));
        blocks.add(new Block(173, height - 7));
        blocks.add(new Block(175, height - 7));
        return blocks;
    }

    private List<MysteryBlock> createMystery()
    {
        List<MysteryBlock> mysteryBlocks = new ArrayList<>();
        mysteryBlocks.add(new MysteryBlock(18, height - 7));
        mysteryBlocks.add(new MysteryBlock(23, height - 7)); //TEM COGUMELO
        mysteryBlocks.add(new MysteryBlock(25, height - 7));
        mysteryBlocks.add(new MysteryBlock(24, height - 12));
        mysteryBlocks.add(new MysteryBlock(81, height - 7)); //TEM COGUMELO
        mysteryBlocks.add(new MysteryBlock(97, height - 12));
        mysteryBlocks.add(new MysteryBlock(109, height - 7));
        mysteryBlocks.add(new MysteryBlock(112, height - 7));
        mysteryBlocks.add(new MysteryBlock(112, height - 12)); //TEM COGUMELO
        mysteryBlocks.add(new MysteryBlock(132, height - 12));
        mysteryBlocks.add(new MysteryBlock(133, height - 12));
        mysteryBlocks.add(new MysteryBlock(174, height - 12));
        return mysteryBlocks;
    }

    private List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(18, height - 7));
        coins.add(new Coin(25, height - 7));
        coins.add(new Coin(24, height - 12));
        coins.add(new Coin(97, height - 12));
        coins.add(new Coin(109, height - 7));
        coins.add(new Coin(112, height - 7));
        coins.add(new Coin(132, height - 12));
        coins.add(new Coin(133, height - 12));
        coins.add(new Coin(174, height - 12));
        return coins;
    }

    private List<RedMushroom> createRedMushrooms() {
        List<RedMushroom> redMushrooms = new ArrayList<>();
        redMushrooms.add(new RedMushroom(23, height - 7));
        redMushrooms.add(new RedMushroom(81, height - 7));
        redMushrooms.add(new RedMushroom(112, height - 12));
        return redMushrooms;
    }



    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Ground ground : grounds)
            ground.draw(graphics);
        for (Block block : blocks)
            block.draw(graphics);
        for(Stair stair:stairs)
            stair.draw(graphics);
        for(GoalPole pole: poles)
            pole.draw(graphics);
        for (Coin coin:coins) {
            coin.draw(graphics);
        }
        for (RedMushroom m: redMushrooms) {
            m.draw(graphics);
        }
        for(MysteryBlock mysteryblock: mysteryBlocks)
            mysteryblock.draw(graphics);

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

    public boolean break_block()
    {
        for(Block block:blocks)
        {
            if(player.getPosition().equals(block.getPosition()))
            {
                blocks.remove(block);
                return true;
            }
        }
        return false;
    }

    public boolean reveal_mysteryblock()
    {
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            if(player.getPosition().equals(mysteryblock.getPosition()))
            {
                mysteryblock.setMysteryState(1);
                for (Coin coin:coins) {
                    if (coin.getPosition().equals(mysteryblock.getPosition())) {
                        Position p =new Position(coin.getPosition().getX(), coin.getPosition().getY()-1);
                        coin.setPosition(p);
                    }
                }
                for (RedMushroom mushroom:redMushrooms) {
                    if (mushroom.getPosition().equals(mysteryblock.getPosition())) {
                        Position p =new Position(mushroom.getPosition().getX(), mushroom.getPosition().getY()-1);
                        mushroom.setPosition(p);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean collect_coins() {
        for(Coin coin:coins) {
            for (MysteryBlock m:mysteryBlocks) {
                if (coin.getPosition().equals(m.getPosition())) return false;
            }
            if (player.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean collect_mushroom() {
        for(RedMushroom rm:redMushrooms) {
            for (MysteryBlock m:mysteryBlocks) {
                if (rm.getPosition().equals(m.getPosition())) return false;
            }
            if (player.getPosition().equals(rm.getPosition())) {
                //SUPERMARIO STATE
                redMushrooms.remove(rm);
                return true;
            }
        }
        return false;
    }

    public boolean collision_y()
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX(),block.getPosition().getY()-1);
            if(player.getPosition().equals(p)&&player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX(),ground.getPosition().getY()-1);
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX(),stair.getPosition().getY()-1);
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX(),mysteryblock.getPosition().getY()-1);
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        return false;
    }
    public boolean collision_x_front()
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX()-1,block.getPosition().getY());
            if(player.getPosition().equals(p)&&player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX()-1,ground.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX()-1,stair.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX()-1,mysteryblock.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        return false;
    }
    public boolean collision_x_back()
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX()+1,block.getPosition().getY());
            if(player.getPosition().equals(p)&&player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX()+1,ground.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX()+1,stair.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX()+1,mysteryblock.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        return false;
    }


    public void processKey(KeyStroke key) {
        System.out.println(key);
        String keyT = key.getKeyType().toString();
        int b_block = 0;
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
                if(!collision_x_back())if(player.getPosition().getX()!=0)movePlayer(player.moveLeft());
                break;
            case "ArrowRight":
                for(GoalPole pole: poles) if(player.getPosition().getX()==pole.getPosition().getX()) System.exit(0);
                if(!collision_x_front())
                {
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
                        for(Stair stair: stairs)
                        {
                            Position p = new Position(stair.getPosition().getX()-1,stair.getPosition().getY());
                            stair.setPosition(p);
                        }
                        for(GoalPole pole: poles)
                        {
                            Position p = new Position(pole.getPosition().getX()-1,pole.getPosition().getY());
                            pole.setPosition(p);
                        }
                        for(MysteryBlock mysteryblock:mysteryBlocks)
                        {
                            Position p = new Position(mysteryblock.getPosition().getX()-1,mysteryblock.getPosition().getY());
                            mysteryblock.setPosition(p);
                        }
                        for(Coin coin:coins)
                        {
                            Position p = new Position(coin.getPosition().getX()-1,coin.getPosition().getY());
                            coin.setPosition(p);
                        }
                        for(RedMushroom rm:redMushrooms)
                        {
                            Position p = new Position(rm.getPosition().getX()-1,rm.getPosition().getY());
                            rm.setPosition(p);
                        }

                    }
                }
                break;
        }
    }

}
