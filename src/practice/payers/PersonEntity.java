package practice.payers;

/**
 * Created by igor on 06.12.2015.
 */
public class PersonEntity implements Payer{


    @Override
    public void pay(int count) {
        System.out.println("==============");

        System.out.println("Bye: "+ count);
        System.out.println("CostPerOne: "+ CostPerOne);

        System.out.println("Cost: "+ count*CostPerOne);
        System.out.println("==============");
    }
}
