package src.objects;

public class Employee extends Profile implements Printable {
    private String positionOnWork;
    private int yearsOnWork;

    Employee(String name, int age, boolean sex, String positionOnWork, int yearsOnWork) {
        super(name, age, sex);
        setPositionOnWork(positionOnWork);
        setYearsOnWork(yearsOnWork);
    }


    public void setPositionOnWork(String positionOnWork) {
        this.positionOnWork = positionOnWork;
    }


    public void setYearsOnWork(int yearsOnWork) {
        this.yearsOnWork = yearsOnWork;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Должность: " + positionOnWork + "\n" +
                "Опыт работы: " + yearsOnWork + "\n";
    }
}
