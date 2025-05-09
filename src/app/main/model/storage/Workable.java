package app.main.model.storage;

import app.main.model.profile.Employee;

public interface Workable {
    void add(Employee e);
    void remove(Employee e);
    String getName();
}
