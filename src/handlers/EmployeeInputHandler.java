package handlers;

import profile.Employee;

import java.util.Map;

public class EmployeeInputHandler extends InputHandler {
    private final Map<String, Employee> employees;

    EmployeeInputHandler(){
        employees = companyData.getEmployees();
    }

    @Override
    public void printMenu() {
        ui.print(
                """
                \t---Выберете действие---\t
                
                1) Показать информацию
                2) Сменить должность у сотрудника
                3) Регистрация сотрудника
                4) Увольнение сотрудника
                """
        );
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): infoMenu(employees); break;
            case("2"): setPositionOnWorkMenu(); break;
            case("3"): registerEmployeeMenu(); break;
            case("4"): deleteEmployeeMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }
    private void setPositionOnWorkMenu(){
        ui.print("Введите имя сотрудника");
        String name = ui.readLine();
        Employee e = employees.get(name);
        ui.print("Введите должность");
        String pos = ui.readLine();
        e.setPositionOnWork(pos);
    }
    private void registerEmployeeMenu(){
        ui.print("Введите имя сотрудника");
        String name = ui.readLine();
        ui.print("Введите возраст");
        int age = Integer.parseInt(ui.readLine());
        ui.print("Введите пол(м/ж)");
        String in = ui.readLine();
        companyData.add(new Employee(name, age, in.equals("м")));
    }
    private void deleteEmployeeMenu(){
        ui.print("Введите имя сотрудника");
        String name = ui.readLine();
        Employee e = employees.get(name);
        e.getWork().remove(e);
    }
}
