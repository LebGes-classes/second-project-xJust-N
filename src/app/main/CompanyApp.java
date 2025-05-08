package app.main;

import app.main.handlers.InputHandler;
import app.main.handlers.MainMenuInputHandler;
import app.main.repository.CompanyData;
import app.main.ui.UI;

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
                case("save"):
                    companyData.save();
                    break;
                default:
                    currentHandler.handle(command);
                    break;
            }
            currentHandler = currentHandler.getNextHandler();
        }
        
    }
    private void exit(){
        companyData.save();
        ui.print("Goodbye!");
    }
}
