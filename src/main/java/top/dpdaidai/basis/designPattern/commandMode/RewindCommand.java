package top.dpdaidai.basis.designPattern.commandMode;

/**
 * @Author chenpantao
 * @Date 4/20/21 12:43 PM
 * @Version 1.0
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.rewind();
    }

}
