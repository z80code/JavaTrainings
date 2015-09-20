package lesson.networks.streams.linalg;

import java.io.Serializable;

public class Pack implements Serializable{
    private Message message;
    private Object data;

    public Pack() {
    }

    public Pack(Message message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
