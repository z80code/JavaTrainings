package practice.payers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

    public static void main(String[] args) {
        Random r = new Random();
        List<Payer> payers = new ArrayList<>();
        for (int i = 0; i<5; i++) {

            Payer p;
            if(r.nextBoolean()) {
                p = new LegalEntity("sdf",r.nextInt(50),r.nextInt());
            } else {
                p = new PersonEntity();
            }

            payers.add(p);
        }

        for (Payer payer: payers) {
            payer.pay(r.nextInt(100));
        }
    }

}
