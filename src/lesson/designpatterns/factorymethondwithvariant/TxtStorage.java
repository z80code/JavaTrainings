package lesson.designpatterns.factorymethondwithvariant;

import lesson.designpatterns.factorymethod.AbstractStorage;

public class TxtStorage extends lesson.designpatterns.factorymethondwithvariant.AbstractStorage {

    @Override
    public void perform() {
        System.out.println("Write something to text file");
    }
}
