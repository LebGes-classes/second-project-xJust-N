package src;

import src.handlers.InputHandler;
import src.handlers.MainMenuInputHandler;
import src.repository.CompanyData;
import src.ui.UI;

import java.util.Scanner;

public class CompanyApp {
    private final CompanyData companyData;
    private final Scanner scanner;
    private boolean isRunning;


    CompanyApp(){
        companyData = CompanyData.getData();
        scanner = new Scanner(System.in);
        isRunning = false;
    }
    public void start(){
        companyData.load();
        run();
    }
    private void run() {
        UI ui = new UI();
        InputHandler.setCurrentHandler(new MainMenuInputHandler());
        InputHandler currentHandler;
        isRunning = true;

        while(isRunning){
            currentHandler = InputHandler.getCurrentHandler();
            ui.print(currentHandler);
            String command = ui.readLine().trim().toLowerCase();

            switch (command){
                case("back"):
                    InputHandler.setCurrentHandler(new MainMenuInputHandler());
                    break;
                case("exit"):
                    isRunning = false;
                    exit();
                    break;
                default:
                    currentHandler.handle(command);
                    break;
            }
        }
        
    }
    private void exit(){
        companyData.save();
    }
}
