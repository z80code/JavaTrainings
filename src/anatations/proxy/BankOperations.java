package anatations.proxy;

/**
 * Created by igor on 18.06.2015.
 */
public class BankOperations implements IBankOperations {

    @MethodAnnotation(securityLevel = SecurityLevel.LOW)
    public double check() {
        // Logic
        return 42;
    }

    @MethodAnnotation(securityLevel = SecurityLevel.HIGH)
    public boolean withdraw() {
        // Logic
        return true;
    }

    @MethodAnnotation
    public boolean transfer(int accontNumber, double amount) {
        // Logic
        return true;
    }
}
