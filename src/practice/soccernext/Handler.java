package practice.soccernext;


import java.io.IOException;

public interface Handler {
    void send(String message) throws IOException;
}
