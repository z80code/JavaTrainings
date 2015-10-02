package lesson.enums;

public class Example {

    public static void check(Days day) {



    }

    public static void main(String[] args) {

        Days days = Days.Wednesday;


        System.out.println(days);

        Days day = Days.fromText("Понедельникава");

        System.out.println(day);

        System.out.println( days.ordinal() );

        System.out.println("========");
        for(Days d :  Days.values()) {
            System.out.println(d.getText());
        }

    }


}

enum Days {
    Monday("Понедельник"),
    Tuesday("Вторник"),
    Wednesday("Среда") ;

    public String getText() {
        return text;
    }

    private String text;

    Days(String text) {
        this.text = text;
    }

    static Days fromText(String text) {

        for (Days d : Days.values()) {
            if(d.getText().compareTo(text)==0)
                return d;
        }

        throw new IllegalArgumentException("invalid text");
    }

}

interface DaysOfWeek {
    int MONDAY = 0;
    int TUESDAY = 1;
}