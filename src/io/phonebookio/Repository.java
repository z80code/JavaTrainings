package io.phonebookio;

import java.util.List;

/**
 * Created by igor on 25.06.2015.
 */
public interface Repository {
    PhoneRecord get(int id);
    List<PhoneRecord > getAll();
    void add(PhoneRecord phoneRecord);
    void update(PhoneRecord phoneRecord);
    void delete(PhoneRecord delete);
}
