import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PiranhaPlant extends Monster{
    private int openCloseState = 0;
    public PiranhaPlant(Position p){
        super(p);
    }
    public PiranhaPlant(int x, int y) {
        super(x,y);
    }

    void setOpenCloseState(int i)
    {
        openCloseState=i;
    }
    int getOpenCloseState()
    {
        return openCloseState;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8A3324"));
        graphics.enableModifiers(SGR.BOLD);
        if(openCloseState==0) graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "i");
        else if(openCloseState==1) graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "v");
        else if(openCloseState==2) graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "I");
        else if(openCloseState==3) graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()), "V");
    }
}