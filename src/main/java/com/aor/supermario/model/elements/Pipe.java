package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;

public class Pipe extends Element {
    public Pipe(int x, int y) { super(x, y);}

    public Pipe(Position position) {
        super(position);
    }
}
