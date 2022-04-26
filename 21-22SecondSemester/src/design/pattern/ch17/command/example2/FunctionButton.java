package design.pattern.ch17.command.example2;

public class FunctionButton {
    
    private Command command;
    
    /**
     * 为功能键注入命令
     */
    public void setCommand(Command command) {
        this.command = command;
    }
    
    /**
     * 发送请求
     */
    public void click() {
        System.out.println("单击功能键：");
        command.execute();
    }
}
