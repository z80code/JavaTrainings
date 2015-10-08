package lesson.designpatterns.factorymethondwithvariant;

import lesson.designpatterns.factorymethod.AbstractStorage;

public class DbStorage extends lesson.designpatterns.factorymethondwithvariant.AbstractStorage {
    @Override
    public void perform() {
        System.out.println("write something to DB");
    }
}
