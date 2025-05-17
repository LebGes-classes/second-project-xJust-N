package app.main.model.storage;

import app.main.model.profile.Employee;

public interface Workable {     //Интерфейс для обозначения места как возможное место работы
    void add(Employee e);
    void remove(Employee e);
    String getName();
}
