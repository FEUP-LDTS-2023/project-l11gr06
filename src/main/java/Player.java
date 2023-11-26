import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element {
    public Player(int x, int y) {

        super(x, y);
    }
    public Player(Position p) {
        super(p);
    }
    public Position moveUp(Player pl) {
        long beginJump=System.currentTimeMillis();
        for (int i=0; i<5; i++) {
            if (System.currentTimeMillis()==beginJump + 125) {
                Position p = new Position(getPosition().getX(), getPosition().getY()+1);
                pl.setPosition(p);
                beginJump+=125;
            }

        }
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    //public Position moveRight() {
    //    return new Position(getPosition().getX()+1, getPosition().getY());
    //}


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }

}