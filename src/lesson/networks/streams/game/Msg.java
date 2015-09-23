package lesson.networks.streams.game;

import java.io.Serializable;
import java.util.Objects;

public class Msg implements Serializable{

    private Operation operation;
    private Object data;

    public Msg(Operation operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public Msg(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
