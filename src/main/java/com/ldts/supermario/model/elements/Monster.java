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
    /*
    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position moveRight() {return new Position(getPosition().getX()+1, getPosition().getY());}
    public Position moveUp() {return new Position(getPosition().getX(), getPosition().getY()-1);}
    public Position moveDown() {return new Position(getPosition().getX(), getPosition().getY()+1);}
*/
}
