package src;

public class UI {

    public static void printInfo(Order obj){
        System.out.println(
                "Название: " + obj.getName() + "\n" +
                        "Сумма оплаты: " + obj.getPrice() + "\n" +
                        "Получатель: " + obj.getRecipient().getName() + "\n" +
                        "Статус: " + obj.getStatus() + "\n" +
                        "Пункт доставки: " + obj.getDeliveryPoint().getName()
        );

        System.out.println("Товары: ");
        printAllInfo(order.getListOfProducts());
    }
    public static void printInfo(Storage obj){
        System.out.println(
                "Название: " + obj.getName() + "\n" +
                        "Заполненность: " + obj.getSize() + "/" + obj.getCapacity() + "\n" +
                        "Ответственные лица: "
        );
        printAllInfo(obj.getEmployees());

        System.out.println("Товары: ");
        for(StorageCell cell: obj.getStorageCells()){
            printAllInfo(cell.getProducts());
        }

    }
    public static void printInfo(Product obj){
        System.out.println(
                "Название: " + obj.getName() + "\n" +
                        "Цена: " + obj.getPrice() + "\n" +
                        "Количество: " + obj.getCount() + "\n" +
                        "Размер: " + obj.getSizeValue() + "\n" +

        );
    }
    public static void printProfileInfo(Profile obj){
        System.out.println(
                "Имя: " + obj.getName() + "\n" +
                        "Возраст: " + obj.getAge() + "\n" +
                        "Пол: " + String
    if(obj.getSex()) {

        }
                        "Размер: " + obj.getSizeValue() + "\n" +

        );
    }
    public static void printInfo(Employee obj){
        System.out.println(
                "Имя: " + obj.getName() + "\n" +
                        "Цена: " + obj.getPrice() + "\n" +
                        "Количество: " + obj.getCount() + "\n" +
                        "Размер: " + obj.getSizeValue() + "\n" +

        );
    }



}
    public static void printMainMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Добро пожаловать!---\t
                        
                        \tВыберете раздел:\t
                        1) Заказы
                        2) Склады
                        3) Пункты продаж
                        4) Товары
                        5) Ответственные лица
                        6) Покупатели
                        
                        """
                );
    }
    public static void printActionOrdersMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Оформление
                        3) Смена статуса заказа
                        4) Возврат
           
                        
                        """
        );
    }
    public static void printActionOrderStatusMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) На складе
                        2) В пути
                        3) В пункте продажи
                        
                        """
        );
    }
    public static void printActionStorageMenu(){
            clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Перемещение товаров на другой склад
                        3) Открытие нового склада
                        4) Закрытие склада
                        5) Нанять работника на склад
                        6) Убрать работника со склада
                        
                        """
        );
    }
    public static void printActionSalingPointMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Открытие нового склада
                        3) Закрытие склада
                        4) Нанять работника на склад
                        5) Убрать работника со склада
                        
                        """
        );
    }
    public static void printActionProductMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Регистрация нового товара
                        3) Закрытие склада
                        4) Нанять работника на склад
                        5) Убрать работника со склада
                        
                        """
        );
    }



    public static void clearConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception E) {
            System.out.println(E);
        }
    }
    public static void printAllOrOneMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать обо всех
                        2) Показать об одном
                        
                        """
        );
    }
    public static void printEnterNameMenu(){
        clearConsole();
        System.out.println(" Введите имя:");
    }

}

