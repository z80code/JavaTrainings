package lesson.enums;

public class Ex {

    public static void dosome(MonthsEnum month) {
        if(month.equals( MonthsEnum.July)) {

        }
    }

    public static void main(String[] args) {

//        dosome(Months.JULY);
//        dosome(4554);

        //dosome(MonthsEnum.July);
        //String s = Boolean.toString( MonthsEnum.July == FF.July);
//        System.out.println(MonthsEnum.December);
//
//        MonthsEnum month = MonthsEnum.valueOf("May");
//        System.out.println(month);

//        for(MonthsEnum e: MonthsEnum.values()) {
//            System.out.println(e);
//            System.out.println(e.getNum());
//        }

        MonthsEnum month = MonthsEnum.fromNum(7);
        System.out.println(month);

        //System.out.println();


    }


}

enum MonthsEnum {
    July(7), May(5), December(12);

    private int num;

    MonthsEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static MonthsEnum fromNum(int num) {
        for(MonthsEnum m: values()) {
            if(num == m.num)
                return m;
        }
        throw new IllegalArgumentException("invalid number");
    }
}

interface Months {
    int JULY = 1;
    int MAY = 2;
    int DECEMBER = 1;
}