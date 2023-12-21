package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class Block extends Element {

    public Block(int x, int y) {
        super(x, y);
    }

    public Block(Position position) {
        super(position);
    }
}