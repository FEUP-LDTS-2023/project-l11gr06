package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public abstract class Monster extends Element{
    private boolean move=false;
    private int moveDirection = 0;
    // 0 -> trás
    // 1 -> frente

    public void setMove(boolean b) {move=b;}
    public boolean getMove() {return move;}
    public int getMoveDirection() {return moveDirection;}
    public void setMoveDirection(int moveDirection) {this.moveDirection = moveDirection;}
    public Monster(Position p){
        super(p);
    }
    public Monster(int x, int y) {
        super(x,y);
    }
}
