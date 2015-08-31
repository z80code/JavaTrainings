import hwskeleton.model.Record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by igor on 19.07.2015.
 */
public class SimpleEvents {

    public static void main(String[] args) {

        PrintReport printReport = new PrintReport();

        printReport.addEventListener( new PrintEvent() {
                                         @Override
                                         public void action() {
                                             System.out.println("Event");
                                         }
                                     });

        printReport.printSomething();
    }
}

interface PrintEvent {
    void action();
}

class PrintReport {

    PrintEvent event = null;

    public void addEventListener(PrintEvent event) {
        this.event = event;
    }


    public void printSomething(    ) {
        if(event!=null) {
           event.action();
        }
    }

}