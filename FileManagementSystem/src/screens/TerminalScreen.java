package screens;

import utils.BaseScreen;
import utils.InvalidCommandException;

import java.util.List;

public class TerminalScreen extends BaseScreen {
    TerminalViewModel viewModel;
    public TerminalScreen(){
        viewModel = new TerminalViewModel();
    }
    public static void main(String[] args) throws InvalidCommandException{
        TerminalScreen ts = new TerminalScreen();
        ts.onCreate();

    }
    public void onCreate() throws InvalidCommandException {
        while (true){
            System.out.print(viewModel.getCurrentPath()+ " > ");
            List<String> processed = getProcessedCommands();
            viewModel.processCommand(processed);
        }
    }
}
