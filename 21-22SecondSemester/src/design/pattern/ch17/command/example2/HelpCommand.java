package design.pattern.ch17.command.example2;

public class HelpCommand extends Command {
    
    private HelpDocDisplayer helpDocDisplayer;
    
    public HelpCommand() {
        helpDocDisplayer = new HelpDocDisplayer();
    }
    @Override
    public void execute() {
        helpDocDisplayer.display();
    }
}
