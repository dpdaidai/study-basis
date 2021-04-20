package top.dpdaidai.basis.designPattern.observerMode;


/**
 * 描述 : 抽象主题(抽象被观察者) / 抽象发布者
 */
public interface Subject {

    /**
     * 注册观察者 / 订阅者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移出观察者 / 订阅者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者 / 订阅者
     * @param message
     */
    void notifyObserver(String message);

}
