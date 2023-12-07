import java.util.ArrayList;
import java.util.List;

public class Level1 extends Map{
    public Level1(int width,int height,Player player) {
        this.width = width;
        this.height = height;
        this.player=player;
        this.grounds = createGrounds();
        this.blocks = createBlocks();
        this.stairs = createStairs();
        this.poles = createPoles();
        this.monsters = createMonster();
        this.mysteryBlocks = createMystery();
        this.coins = createCoins();
        this.redMushrooms = createRedMushrooms();
        this.pipes = createPipes();
        //this.coins = createCoins();
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
        for(int c = 162; c >158;c--) {
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
        mysteryBlocks.add(new MysteryBlock(115, height - 7));
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


    private List<Pipe> createPipes(){
        List<Pipe> pipes = new ArrayList<>();
        pipes.add(new Pipe(30,height-4,'M'));
        pipes.add(new Pipe(30,height-5,'O'));
        pipes.add(new Pipe(31,height-4,'N'));
        pipes.add(new Pipe(31,height-5,'P'));
        pipes.add(new Pipe(40,height-4,'M'));
        pipes.add(new Pipe(40,height-5,'M'));
        pipes.add(new Pipe(40,height-6,'O'));
        pipes.add(new Pipe(41,height-4,'N'));
        pipes.add(new Pipe(41,height-5,'N'));
        pipes.add(new Pipe(41,height-6,'P'));
        pipes.add(new Pipe(48,height-4,'M'));
        pipes.add(new Pipe(48,height-5,'M'));
        pipes.add(new Pipe(48,height-6,'M'));
        pipes.add(new Pipe(48,height-7,'0'));
        pipes.add(new Pipe(49,height-4,'N'));
        pipes.add(new Pipe(49,height-5,'N'));
        pipes.add(new Pipe(49,height-6,'N'));
        pipes.add(new Pipe(49,height-7,'P'));
        pipes.add(new Pipe(59,height-4,'M'));
        pipes.add(new Pipe(59,height-5,'M'));
        pipes.add(new Pipe(59,height-6,'M'));
        pipes.add(new Pipe(59,height-7,'0'));
        pipes.add(new Pipe(60,height-4,'N'));
        pipes.add(new Pipe(60,height-5,'N'));
        pipes.add(new Pipe(60,height-6,'N'));
        pipes.add(new Pipe(60,height-7,'P'));
        pipes.add(new Pipe(167,height-4,'M'));
        pipes.add(new Pipe(167,height-5,'O'));
        pipes.add(new Pipe(168,height-4,'N'));
        pipes.add(new Pipe(168,height-5,'P'));
        pipes.add(new Pipe(183,height-4,'M'));
        pipes.add(new Pipe(183,height-5,'O'));
        pipes.add(new Pipe(184,height-4,'N'));
        pipes.add(new Pipe(184,height-5,'P'));
        return pipes;
    }


    private List <Monster> createMonster()
    {
        List <Monster> monsters = new ArrayList<>();
        monsters.add(new BrownMushroom(25, height - 4));

        monsters.add(new PiranhaPlant(30,height-6));
        monsters.add(new PiranhaPlant(31,height-6));

        monsters.add(new PiranhaPlant(40,height-7));
        monsters.add(new PiranhaPlant(41,height-7));

        monsters.add(new BrownMushroom(42, height - 4));

        monsters.add(new PiranhaPlant(48,height-8));
        monsters.add(new PiranhaPlant(49,height-8));

        monsters.add(new BrownMushroom(53, height - 4));
        monsters.add(new BrownMushroom(55, height - 4));

        monsters.add(new BrownMushroom(83, height - 13));
        monsters.add(new BrownMushroom(83, height - 15));

        monsters.add(new BrownMushroom(100, height - 4));
        monsters.add(new BrownMushroom(102, height - 4));

        monsters.add(new Turtle(110, height - 4));

        monsters.add(new BrownMushroom(117, height - 4));
        monsters.add(new BrownMushroom(119, height - 4));

        monsters.add(new BrownMushroom(127, height - 4));
        monsters.add(new BrownMushroom(129, height - 4));

        monsters.add(new BrownMushroom(131, height - 4));
        monsters.add(new BrownMushroom(133, height - 4));

        monsters.add(new PiranhaPlant(183,height-6));
        monsters.add(new PiranhaPlant(184,height-6));
        return monsters;
    }
}
