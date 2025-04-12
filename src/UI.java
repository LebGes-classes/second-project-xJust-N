package src;

import java.util.Collection;
import java.util.Map;

public class UI {

    public static void printAllInfo(Collection< ? extends Printable> c){
        for(Printable element : c){
            element.printInfo();
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
                        0) Выход
                        
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
    public static void printActionEmployeeMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Нанять сотрудника
                        3) Уволить сотрудника
                     
                        """
        );
    }
    public static void printActionCustomerMenu(){
        clearConsole();
        System.out.println(
                """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Создать аккаунт покупателя
                        3) Удалить аккаунт покупателя
                     
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
        System.out.println("Введите имя:");
    }
    public static void printEnterNameMenu(String name){
        clearConsole();
        System.out.println("Введите имя " + name + ": ");
    }
    public static void printErrorMenu(String message){
        System.out.println(message + "\n");
        System.out.println("1) Вернуться назад");
    }

}

