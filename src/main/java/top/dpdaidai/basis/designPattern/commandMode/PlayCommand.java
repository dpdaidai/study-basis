package top.dpdaidai.basis.designPattern.commandMode;

/**
 *
 * 具体命令角色类
 *
 * @Author chenpantao
 * @Date 4/20/21 12:41 PM
 * @Version 1.0
 */
public class PlayCommand implements Command{

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }

}
