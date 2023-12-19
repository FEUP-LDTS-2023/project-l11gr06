package com.aor.supermario.model.elements;

import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.BrownMushroom;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class BrownMushroomTest {

    @Test
    void testDraw() {
        BrownMushroom brownMushroom = new BrownMushroom(3, 5);

        TextGraphics graphics = Mockito.mock(TextGraphics.class);

        brownMushroom.draw(graphics);

        verify(graphics).setForegroundColor(any(TextColor.class));
        verify(graphics).enableModifiers(SGR.BOLD);
        verify(graphics).putString(new TerminalPosition(3, 5), "#");
    }
}
