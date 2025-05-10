package app.main.model.profile;

import app.main.model.storage.Printable;
import app.main.model.storage.Workable;

 

public class Employee extends Profile implements Printable {
    private String workName;
    private String positionOnWork;

    Employee(String name, int age, boolean sex, String work, String positionOnWork) {
        super(name, age, sex);
        setWorkName(work);
        setPositionOnWork(positionOnWork);
    }
    public Employee(String name, int age, boolean sex){
        this(name, age, sex, null,null);
    }

    public void setWorkName(String work){
        this.workName = work;
    }

    public void setPositionOnWork(String positionOnWork) {
        this.positionOnWork = positionOnWork;
    }


    public String getWorkName(){
        return workName;
    }

    public void removeWork(){
        this.workName = null;
        this.positionOnWork = null;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
                "Место работы:" + (workName == null? "none" : workName) + "\n" +
                "Должность: " + (positionOnWork == null? "none" : positionOnWork) + "\n\n";
    }
}
