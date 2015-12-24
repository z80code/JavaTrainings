package practice.soccernext;

import java.io.IOException;
import java.net.SocketException;

public class Runner {

    public static void main(String[] args) throws IOException {
        boolean isNetwork = false;
        Game game = new Game(isNetwork);
        game.start();
    }
}
