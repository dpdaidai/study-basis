package top.dpdaidai.basis.designPattern.commandMode;

/**
 *
 * 转载 https://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html
 *
 * AudioPlayer系统
 *      client Julia : 小女孩茱丽(Julia)有一个盒式录音机 , 茱丽(Julia)是客户端角色
 *      Invoker 录音机键盘: 此录音机有播音(Play)、倒带(Rewind)和停止(Stop)功能，录音机的键盘便是请求者(Invoker)角色；
 *      Receiver 接收者 :录音机
 *      Command类扮演抽象命令角色，而PlayCommand、StopCommand和RewindCommand便是具体命令类。
 *
 *      茱丽(Julia)不需要知道播音(play)、倒带(rewind)和停止(stop)功能是怎么具体执行的，
 *      这些命令执行的细节全都由键盘(Keypad)具体实施。茱丽(Julia)只需要在键盘上按下相应的键便可以了。
 *
 * 　　录音机是典型的命令模式。录音机按键把客户端与录音机的操作细节分割开来。
 *
 * 命令模式的优点
 * 　　●　　更松散的耦合
 * 　　命令模式使得发起命令的对象——客户端，和具体实现命令的对象——接收者对象完全解耦，
 *     也就是说发起命令的对象完全不知道具体实现对象是谁，也不知道如何实现。
 *
 * 　　●　　更动态的控制
 * 　　命令模式把请求封装起来，可以动态地对它进行参数化、队列化和日志化等操作，从而使得系统更灵活。
 *
 * 　　●　　很自然的复合命令
 * 　　命令模式中的命令对象能够很容易地组合成复合命令，也就是宏命令，从而使系统操作更简单，功能更强大。
 *
 * 　　●　　更好的扩展性
 * 　　由于发起命令的对象和具体的实现完全解耦，因此扩展新的命令就很容易，只需要实现新的命令对象，然后在装配的时候，
 *    把具体的实现对象设置到命令对象中，然后就可以使用这个命令对象，已有的实现完全不用变化。
 *
 * @Author chenpantao
 * @Date 4/20/21 12:36 PM
 * @Version 1.0
 */
public class Julia {
    public static void main(String[] args) {
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        //创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
