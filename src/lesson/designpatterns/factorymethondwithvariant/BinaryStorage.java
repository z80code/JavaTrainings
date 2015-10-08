package lesson.designpatterns.factorymethondwithvariant;

import lesson.designpatterns.factorymethod.AbstractStorage;

public class BinaryStorage extends lesson.designpatterns.factorymethondwithvariant.AbstractStorage {

    @Override
    public void perform() {
        System.out.println("Write to binary file");
    }
}
