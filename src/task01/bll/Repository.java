package task01.bll;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    /**
     *
     * Return record with id
     *
     * @param id - record Id
     * @return record or null if record not found
     */
    T get(int id);
    List<T> getAll();
    List<T> get(Predicate<T> predicate);
    void add(T entity);
    void remove(T entity);
    void update(T entity);
    void sort(Comparator<T> comparator);
    void save();
}
