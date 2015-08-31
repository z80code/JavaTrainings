package anatations.proxy;

/**
 * Created by igor on 17.06.2015.
 */
public class SecurityRun {
    public static void main(String[] args) {

        BankOperations bankOperations = new BankOperations();
        IBankOperations secure = SecurityFactory.createSecurityObj(bankOperations);
        secure.check();
        System.out.println("---------");
        secure.check();
        System.out.println("---------");
        secure.transfer(23,3424);
        System.out.println("---------");
        secure.withdraw();
        System.out.println("---------");

    }
}

