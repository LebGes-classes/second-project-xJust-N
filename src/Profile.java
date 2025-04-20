package src;

public class Profile implements Printable {
    private String name;
    private int age;
    private boolean sex;

    Profile(String name, int age, boolean sex){
        setName(name);
        setAge(age);
        setSex(sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public void printInfo(){
        System.out.println(
                        "Имя: " + name + "\n" +
                        "Возраст: " + age + "\n" +
                        "Пол: " + (sex ? "М" : "Ж")
        );
    }


}
