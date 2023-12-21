package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;

public class Ground extends Element {
    public Ground(int x, int y) {
        super(x,y);
    }

    public Ground(Position p) {
        super(p);
    }
}