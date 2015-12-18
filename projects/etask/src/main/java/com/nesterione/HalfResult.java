package com.nesterione;

public class HalfResult extends Result{
    @Override
    public String toString() {
        // TODO
        return getLogin() + ";" + getTest() + ";" + getStringDate() + ";" + getMark()*10;
    }
}
