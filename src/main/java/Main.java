import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int lives = 3;
        while (lives > 0) {
            new Game(65, 20).runGame();
            lives--;
        }
        System.exit(0);
    }
}