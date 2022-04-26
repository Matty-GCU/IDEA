package design.pattern.ch17.command.example2;

public class ExitCommand extends Command {
    
    /**
     * 请求的最终接收者
     */
    private SystemExitClass systemExitClass;
    
    public ExitCommand() {
        systemExitClass = new SystemExitClass();
    }
    
    @Override
    public void execute() {
        systemExitClass.exit();
    }
}
