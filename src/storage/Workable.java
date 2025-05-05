package storage;

import profile.Employee;

public interface Workable {
    void add(Employee e);
    void remove(Employee e);
    String getName();
}
