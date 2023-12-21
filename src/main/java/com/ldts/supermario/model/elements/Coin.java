package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class Coin extends Element {
    public Coin(int x, int y) {
        super(x, y);
    }

    public Coin(Position p) {
        super(p);
    }
}