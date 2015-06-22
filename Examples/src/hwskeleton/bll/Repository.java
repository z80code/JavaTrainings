package hwskeleton.bll;

import java.util.List;

/**
 * Created by igor on 22.06.2015.
 */
public interface Repository<T> {
    T get(int id);
    List<T> getAll();
    void add(T entity);
    void remove(T entity);
    void update(T entity);
}
