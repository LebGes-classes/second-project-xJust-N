
import handlers.InputHandler;
import handlers.MainMenuInputHandler;
import repository.CompanyData;
import ui.UI;

public class CompanyApp {
    private final CompanyData companyData;
    private boolean isRunning;


    CompanyApp(){
        companyData = CompanyData.getData();
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
            String command = ui.readLine();

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
