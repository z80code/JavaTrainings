package task01.model;

/**
 * Created by igor on 22.06.2015.
 */
public class Phone {

    private String type;
    private String number;

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", type, number);
    }
}
