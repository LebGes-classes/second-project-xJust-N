package com.app.handlers;

import com.app.model.profile.Employee;

import java.io.IOException;
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
    public void handle(String command) throws IOException {
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
        Employee e = getObjectByInput(employees);
        ui.print("Введите должность");
        String pos = ui.readLine();
        e.setPositionOnWork(pos);
    }
    private void registerEmployeeMenu() throws IOException {
        ui.print("Введите имя сотрудника");
        String name = ui.readLine();
        if(employees.containsKey(name))
            throw new IOException(name + " уже существует");

        ui.print("Введите возраст");
        int age = parseInt(ui.readLine());
        ui.print("Введите пол(м/ж)");
        String in = ui.readLine();
        companyData.add(new Employee(name, age, in.equals("м")));
    }
    private void deleteEmployeeMenu(){
        ui.print("Введите имя сотрудника");
        Employee e = getObjectByInput(employees);
        e.removeWork();
        companyData.remove(e);
    }
}
