package Generics;

public class Begin {

    public static void main(String[] args) {
        Printable printable = new PrintableImpl();
        ReportPrinterOnly<Printable> printerOnly = new ReportPrinterOnly<>(printable);
        printerOnly.printReport();
    }
}

interface Printable {
    public String getPrintableReport();
}
class PrintableImpl implements Printable {

    @Override
    public String getPrintableReport() {
        return "Report";
    }
}

// Можно требовать реализации нескольких интерфейсов
//class ReportPrinterOnly<T extends Serializable&Printable > {
class ReportPrinterOnly<T extends Printable > {
    T data;
    // Можно так
    // Printable datalist;

    public ReportPrinterOnly(T data) {
        this.data = data;
        //datalist = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void printReport() {
        if(data!= null) {
            // !
            System.out.println(data.getPrintableReport());
        } else {
            System.out.println("Printable data not found");
        }
    }
}
