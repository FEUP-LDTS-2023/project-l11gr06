package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class TurtleShell extends Monster{
    private int state = 1;

    //state=1 -> carapaça parada
    //state=2 -> carapaça a mover

    public TurtleShell(int x, int y) {
        super(x,y);
    }
    public TurtleShell(Position position) {
        super(position);
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}
