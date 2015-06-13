package Generics;

/**
 * Created by igor on 13.06.2015.
 */
public class GenericsExtends {
    public static void main(String[] args) {
        ReportPrinter<Double> one = new ReportPrinter<>(324.0);
        ReportPrinter<String> two = new ReportPrinter<>("Some text");
        ReportPrinter three = new ReportPrinter(42);

        one.printReport();
        two.printReport();
        three.printReport();
    }
}

class ReportPrinter<T> {

    // Так нельзя, информация о типе не сохраняется
    //T data = new T();

    T data;

    public ReportPrinter(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void printReport() {
        if(data!= null) {
            System.out.println(data.toString());
        } else {
            System.out.println("Printable data not found");
        }
    }
}
