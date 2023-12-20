package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class Block extends Element {

    public Block(int x, int y) {
        super(x, y);
    }

    public Block(Position position) {
        super(position);
    }
}