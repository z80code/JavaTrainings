package com.itclass.jdbc.form;

public class RecordEntity {

    private int id;
    private String text;
    private double number;

    public RecordEntity(int id, String text, double number) {
        this.id = id;
        this.text = text;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RecordEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}
