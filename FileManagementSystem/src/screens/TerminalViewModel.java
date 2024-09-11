package screens;

import com.filemanagementsystem.respository.FileManagementSystemRepository;
import utils.DirectoryNotFoundException;
import utils.InvalidCommandException;
import java.util.List;

public class TerminalViewModel {
    String getCurrentPath(){
        return FileManagementSystemRepository.getInstance().getCurrentPath();
    }
    void processCommand(List<String> processed) throws InvalidCommandException{
        if(processed.isEmpty()){
           return;
        }
        try {
            String command = processed.get(0);
            if(command.equals("cd")){
                if(processed.size() > 2){
                    throw new InvalidCommandException("Invalid command arguments");
                }
                FileManagementSystemRepository.getInstance().openDirectory(processed.get(1));
            }else if(command.equals("mkdir")){

            }else if(command.equals("touch")){

            }else if(command.equals("ls")){
                if(processed.size() == 1){
                FileManagementSystemRepository.getInstance().listDirectory();
                }else {
                    FileManagementSystemRepository.getInstance().listDirectory(processed.get(1));
                }
            } else if (command.equals("cat")) {
                FileManagementSystemRepository.getInstance().readFile(processed.get(processed.size()-1));
            } else {
                throw new InvalidCommandException(command);
            }
        }catch (InvalidCommandException e){
            System.out.println(e.getMessage());
        }
    }
}
