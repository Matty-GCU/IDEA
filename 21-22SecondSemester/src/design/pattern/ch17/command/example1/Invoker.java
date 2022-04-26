package design.pattern.ch17.command.example1;

public class Invoker {
    private AbstractCommand command;
    
    public Invoker(AbstractCommand command) {
        this.command = command;
    }
    
    public void setCommand(AbstractCommand command) {
        this.command = command;
    }
    
    /**
     * call command
     */
    public void call() {
        command.execute();
    }
}
