package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class Turtle extends Monster{
    public Turtle(int x, int y) {
        super(x,y);
    }

    public Turtle(Position p){
        super(p);
    }

}