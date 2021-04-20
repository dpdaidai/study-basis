package top.dpdaidai.basis.designPattern.commandMode.demo;

/**
 * 转载https://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html
 *
 * 命令模式涉及到五个角色，它们分别是： ( 这里看不懂也没关系 )
 * 　　●　　客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。
 * 　　●　　命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 * 　　●　　具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 * 　　●　　请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
 * 　　●　　接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 *
 * @Author chenpantao
 * @Date 4/15/21 3:06 PM
 * @Version 1.0
 */
public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new Command(receiver);

        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        // 客户端通过调用者来执行命令
        // 调用者 Invoker 与 接收者 Receiver  通过 Command 命令接口解耦
        // 可以通过Command动态的修改receiver , 而不需要影响innoker
        invoker.action();
    }

}

//接收者
class Receiver {
    public void action() {
        //真正的业务逻辑
    }
}

//命令的实现
class Command {
    private Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.action();
    }
}

//客户端调用者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
