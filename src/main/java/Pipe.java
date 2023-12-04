import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Pipe extends Element{
    private char character;
    public Pipe(Position p, char c) {
        super(p);
        character = c;
    }

    public Pipe(int x, int y, char c) {
        super(x, y);
        character = c;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), String.valueOf(character));
    }
}
