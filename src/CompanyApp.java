package src;

import src.handlers.InputHandler;
import src.handlers.MainMenuInputHandler;

import java.util.Scanner;

public class CompanyApp {
    private final CompanyData companyData;
    private final Scanner scanner;
    private boolean isRunning;
    private InputHandler currentHandler;

    CompanyApp(){
        companyData = CompanyData.load();
        scanner = new Scanner(System.in);
        isRunning = false;
    }
    public void start(){
        run();
    }
    private void run() {
        isRunning = true;
        while(isRunning){
            currentHandler = InputHandler.getCurrentHandler();
            currentHandler.printMenu();

            System.out.println(
                    """
                    back) Вернуться в главное меню
                    exit) Закрыть приложение
                    """
            );

            String command = scanner.nextLine().trim().toLowerCase();
            switch (command){
                case("back"):
                    InputHandler.setCurrentHandler(new MainMenuInputHandler());
                    break;
                case("exit"):
                    isRunning = false;
                    break;
                default:
                    currentHandler.handle(command);
                    break;
            }
        }
        
    }


    public void setCurrentHandler(InputHandler currentHandler) {
        this.currentHandler = currentHandler;
    }
}
