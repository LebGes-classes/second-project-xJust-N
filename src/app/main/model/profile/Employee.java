package app.main.model.profile;

import app.main.model.storage.Printable;
import app.main.model.storage.Workable;

 

public class Employee extends Profile implements Printable {
    private Workable work;
    private String positionOnWork;

    Employee(String name, int age, boolean sex, Workable work, String positionOnWork) {
        super(name, age, sex);
        setPositionOnWork(positionOnWork);
    }
    public Employee(String name, int age, boolean sex){
        this(name, age, sex, null,null);
    }

    public void setWork(Workable work){
        this.work = work;
    }

    public Workable getWork(){
        return work;
    }

    public void removeWork(){
        setWork(null);
    }

    public void setPositionOnWork(String positionOnWork) {
        this.positionOnWork = positionOnWork;
    }


    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
                "Место работы:" + (work == null? "none" : work.getName()) + "\n" +
                "Должность: " + (positionOnWork == null? "none" : positionOnWork) + "\n";
    }
}
