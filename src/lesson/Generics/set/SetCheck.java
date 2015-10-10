package lesson.Generics.set;

import lesson.anatations.proxy.SecureLogic;

import java.util.HashSet;

/**
 * Created by igor on 10.10.2015.
 */
public class SetCheck {

    public static void main(String[] args) {
        SetCheck check1 = new SetCheck(1,5);
        SetCheck check2 = new SetCheck(1,8);
        SetCheck check3 = new SetCheck(2,3);

        HashSet<SetCheck> setChecks = new HashSet<>();

        System.out.println(setChecks.add(check1));
        System.out.println(setChecks.add(check2));
        System.out.println(setChecks.add(check3));




    }

    public SetCheck(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int a ;
    int b ;
    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SetCheck) {
            SetCheck check = (SetCheck)obj;
            return a==check.a && b==check.b;
        }
        return false;
    }
}
