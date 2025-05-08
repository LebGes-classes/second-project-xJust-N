package app.main.ui;

import app.main.handlers.InputHandler;
import app.main.storage.Printable;

import java.util.Collection;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI(){
        scanner = new Scanner(System.in);
    }

    public void printAllInfo(Collection< ? extends Printable> c){
        for(Printable element : c){
            System.out.println(element.getInfo() + "\n");
        }
    }
    public void print(String message){
        clearConsole();
        System.out.println(message);
    }

    public void print(InputHandler handler){
        clearConsole();
        handler.printMenu();
        printBaseOptions();
    }
    private void printBaseOptions(){
        System.out.println(
                "back) Вернуться в главное меню " + "\n" +
                "save) Сохранить" + "\n" +
                "exit) Закрыть приложение"
        );
    }

    public void printErrorMessage(String message){
        System.out.println("Ошибка! " + message);
    }

    public String readLine(){
        return scanner.nextLine().trim().toLowerCase();
    }

    private void clearConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }
}
