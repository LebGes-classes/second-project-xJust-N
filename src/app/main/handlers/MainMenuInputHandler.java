package app.main.handlers;

public class MainMenuInputHandler extends InputHandler{

    public MainMenuInputHandler(){}
    @Override
    public void printMenu() {
        ui.print(
                        """
                        \t---Добро пожаловать!---\t 
                        Выберете раздел:
                        1) Склады
                        2) Пункты продаж
                        3) Товары
                        4) Ответственные лица
                        5) Покупатели
                        """
        );
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): setNextHandler(new StorageInputHandler()); break;
            case("2"): setNextHandler(new SalingPointInputHandler()); break;
            case("3"): setNextHandler(new ProductInputHandler()); break;
            case("4"): setNextHandler(new EmployeeInputHandler()); break;
            case("5"): setNextHandler(new CustomerInputHandler()); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }
}
