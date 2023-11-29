import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Turtle extends Monster{
    public Turtle(Position p){
        super(p);
    }
    public Turtle(int x, int y) {
        super(x,y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "T");
    }
    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position moveRight() {return new Position(getPosition().getX()+1, getPosition().getY());}
}