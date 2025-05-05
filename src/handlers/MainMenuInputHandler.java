package handlers;

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
            case("1"): setCurrentHandler(new StorageInputHandler()); break;
            case("2"): setCurrentHandler(new SalingPointInputHandler()); break;
            case("3"): setCurrentHandler(new ProductInputHandler()); break;
            case("4"): setCurrentHandler(new EmployeeInputHandler()); break;
            case("5"): setCurrentHandler(new CustomerInputHandler()); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }
}
