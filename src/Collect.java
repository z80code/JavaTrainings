import java.util.*;

/**
 * Created by igor on 20.06.2015.
 */
public class Collect {

    public static void main(String[] args) {

        int action = -1;

        List<MyObj> m =new ArrayList<>();

        m.add(new MyObj(1,"ob2"));
        m.add(new MyObj(3,"ob2"));
        m.add(new MyObj(2,"ob6"));
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("1 - sort by id");
            System.out.println("2 - sort by name");
            System.out.println("0 - to exit");

            action = scanner.nextInt();

            switch (action) {
                case 1:
                    Collections.sort(m, new SortById());
                    break;
                case 2:
                    Collections.sort(m, new SortByName());
                    break;
            }

            for(MyObj obj: m) {
                System.out.println(obj);
            }

        } while (action!=0);




    }
}

class SortById implements Comparator<MyObj>{

    @Override
    public int compare(MyObj o1, MyObj o2) {
        return Integer.compare(o1.id, o2.id);
    }
}

class SortByName implements Comparator<MyObj>{

    @Override
    public int compare(MyObj o1, MyObj o2) {
        return o1.name.compareTo(o2.name);
    }
}

class MyObj {

    public int id;
    public String name;
    public int number;

    public MyObj(int id, String name) {
        this.id =id;

        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %d   name: %s", id, name);
    }


    @Override
    public int hashCode() {
        return id*10+number+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if( !(obj instanceof MyObj) ) {
            return false;
        }

        MyObj inObj = (MyObj)obj;

        boolean c =
                (Integer.compare(this.id, inObj.id )==0) &&
                (this.name.compareTo(inObj.name)==0);

        return c;

    }
}
