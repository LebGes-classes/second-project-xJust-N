package src.handlers;

import src.objects.*;

import java.util.List;
import java.util.Map;


class StorageInputHandler extends InputHandler{

    private final Map<String, Storage> storages;
    private final Map<String, SalingPoint> salingPoints;
    private final Map<String, Employee> employees;
    
    StorageInputHandler(){
        storages = companyData.getStorages();
        salingPoints = companyData.getSalingPoints();
        employees = companyData.getEmployees();
    }

    @Override
    public void printMenu() {
        ui.print(
                        """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Перемещение товаров на другой склад
                        3) Отправка товара в пункт продажи
                        4) Открытие нового склада
                        5) Закрытие склада
                        6) Закуп товара на склад
                        7) Нанять работника на склад
                        8) Убрать работника со склада
                        
                        """
        );
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): infoMenu(storages); break;
            case("2"): moveProductsOnStorageMenu(); break;
            case("3"): moveProductsOnSalingPointMenu(); break;
            case("4"): newStorageMenu(); break;
            case("5"): closeStorageMenu(); break;
            case("6"): buyProductsOnStorageMenu(); break;
            case("7"): addEmployeeOnStorageMenu(); break;
            case("8"): removeEmployeeOnStorageMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }


    private void moveProductsOnStorageMenu() {
        ui.print("Введите имя склада отправителя");
        Storage st1 = storages.get(ui.readLine());
        ui.print("Введите имя склада получателя");
        Storage st2 = storages.get(ui.readLine());
        List<Product> listOfProducts = getListOfProductsByName();
        st1.move(st2, listOfProducts);
    }

    private void moveProductsOnSalingPointMenu() {
        ui.print("Введите имя склада отправителя");
        Storage storage = storages.get(ui.readLine());
        ui.print("Введите имя пункта выдачи");
        SalingPoint salingPoint = salingPoints.get(ui.readLine());
        List<Product> listOfProducts = getListOfProductsByName();
        storage.move(salingPoint, listOfProducts);
    }

    private void newStorageMenu(){
        ui.print("Введите имя склада");
        String name = ui.readLine().trim().toLowerCase();
        companyData.add(new Storage(name));
    }
    
    private void closeStorageMenu(){
        ui.print("Введите имя склада");
        String name = ui.readLine().trim().toLowerCase();
        companyData.removeStorage(name);
    }

    private void buyProductsOnStorageMenu(){
        ui.print("Введите имя склада");
        String name = ui.readLine().trim().toLowerCase();
        Storage storage = storages.get(name);
        List<Product> listOfProducts = getListOfProductsByName();
        storage.add(listOfProducts);
    }
    private void addEmployeeOnStorageMenu(){
        ui.print("Введите имя склада");
        String name = ui.readLine().trim().toLowerCase();
        Storage storage = storages.get(name);
        ui.print("Введите имя работника");
        name = ui.readLine().trim().toLowerCase();
        storage.add(employees.get(name));
    }

    private void removeEmployeeOnStorageMenu(){
        ui.print("Введите имя склада");
        String name = ui.readLine().trim().toLowerCase();
        Storage storage = storages.get(name);
        ui.print("Введите имя работника");
        name = ui.readLine().trim().toLowerCase();
        storage.remove(employees.get(name));
    }

}
