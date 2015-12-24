package practice.soccernext;

import java.io.IOException;

public class ActiveHandler {

    private ActiveHandler() { }
    private static Handler handler = new DefaultHandler();

    public static void setHandler(Handler newHandler) {
        handler = newHandler;
    }

    public static void send(String message) throws IOException {
        handler.send(message);
    }
}

class DefaultHandler implements Handler{

    @Override
    public void send(String message) {

    }
}


