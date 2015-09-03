package lesson.anatations.proxy;

/**
 * Created by igor on 18.06.2015.
 */
public interface IBankOperations {
    public double check();
    public boolean withdraw();
    public boolean transfer(int accontNumber, double amount);
}
