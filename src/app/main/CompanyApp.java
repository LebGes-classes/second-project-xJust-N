package app.main;

import app.main.handlers.InputHandler;
import app.main.handlers.MainMenuInputHandler;
import app.main.repository.CompanyData;
import app.main.ui.UI;

import java.util.NoSuchElementException;

public class CompanyApp {
    private final CompanyData companyData;
    private InputHandler currentHandler;
    private UI ui;
    private boolean isRunning;


    CompanyApp(){
        companyData = CompanyData.getData();
        ui = new UI();
        isRunning = false;
    }
    public void start(){
        companyData.load();
        currentHandler = new MainMenuInputHandler();
        run();
    }
    private void run() {
        isRunning = true;

        while(isRunning){
            ui.print(currentHandler);
            String command = ui.readLine();

            switch (command){
                case("back"):
                    currentHandler.setNextHandler(new MainMenuInputHandler());
                    break;
                case("exit"):
                    isRunning = false;
                    exit();
                    break;
                default:
                    try {
                        currentHandler.handle(command);
                    } catch (NoSuchElementException e) {
                        ui.printErrorMessage("Ошибка нахождения элемента!: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        ui.printErrorMessage("Ошибка формата ввода!: " + e.getMessage());
                    } catch (Exception e) {
                        ui.printErrorMessage("Непредвиденная ошибка!: " + e.getMessage());
                    }
                    break;
            }
            currentHandler = currentHandler.getNextHandler();
            companyData.save();
        }
        
    }
    private void exit(){
        companyData.save();
        ui.print("Goodbye!");
    }
}
