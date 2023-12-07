package com.aor.supermario.gui;

import com.aor.supermario.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawPlayer(Position position);

    void drawGround(Position position);

    //void drawMonster(Position position);

    void drawBlock(Position position);

    void drawMysteryBlock(Position position);

    void drawStair(Position position);

    void drawPipe(Position position);
    void drawCoin(Position position);

    void drawRedMushroom(Position position);

    void drawGoalPole(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
