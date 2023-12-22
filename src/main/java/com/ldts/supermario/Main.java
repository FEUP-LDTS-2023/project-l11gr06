package com.ldts.supermario;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static int lives=3;
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
            new Game().run();
    }
}
