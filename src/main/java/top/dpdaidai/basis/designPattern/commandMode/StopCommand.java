package top.dpdaidai.basis.designPattern.commandMode;

/**
 * @Author chenpantao
 * @Date 4/20/21 12:43 PM
 * @Version 1.0
 */
public class StopCommand implements Command {

    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.stop();
    }

}
