package top.dpdaidai.basis.designPattern.observerMode;

/**
 * 抽象观察者/抽象订阅者
 */
public interface Observer {

    /**
     * subject 发布者 通知观察者/订阅者时 , 会调用订阅者observer的update()方法
     * @param message
     */
    void update(String message);

}
