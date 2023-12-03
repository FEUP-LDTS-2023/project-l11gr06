import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Turtle extends Monster{
    private int state = 0;
    public Turtle(Position p){
        super(p);
    }
    public Turtle(int x, int y) {
        super(x,y);
    }
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        graphics.enableModifiers(SGR.BOLD);
        if(state==0)
            graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "T");
        else
            graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "w");

    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}