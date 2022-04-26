package design.pattern.ch17.command.example1;

public class ConcreteCommand extends AbstractCommand {
    
    private Receiver receiver;
    
    /**
     * execute command
     */
    @Override
    public void execute() {
        receiver.action();
    }
}
