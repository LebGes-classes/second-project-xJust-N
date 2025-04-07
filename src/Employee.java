package src;

public class Employee extends Profile {
    private String positionOnWork;
    private int yearsOnWork;

    Employee(String name, int age, boolean sex, String positionOnWork, int yearsOnWork){
        super(name, age, sex);
        CompanyData.add(this);
    }


    public String getPositionOnWork() {
        return positionOnWork;
    }

    public void setPositionOnWork(String positionOnWork) {
        this.positionOnWork = positionOnWork;
    }

    public int getYearsOnWork() {
        return yearsOnWork;
    }

    public void setYearsOnWork(int yearsOnWork) {
        this.yearsOnWork = yearsOnWork;
    }



}
