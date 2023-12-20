package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class Ground extends Element {
    public Ground(int x, int y) {
        super(x,y);
    }

    public Ground(Position position) {
        super(position);
    }
}