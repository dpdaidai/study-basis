package top.dpdaidai.basis.designPattern.commandMode;

/**
 * 接收者角色，由录音机类扮演
 *
 * @Author chenpantao
 * @Date 4/20/21 12:39 PM
 * @Version 1.0
 */
public class AudioPlayer {
    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }

}
