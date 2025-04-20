package src;

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
    public void printInfo() {
        super.printInfo();
        System.out.println(
                        "Должность: " + positionOnWork + "\n" +
                        "Опыт работы: " + yearsOnWork
        );
    }


}
