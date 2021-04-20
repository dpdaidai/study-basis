package top.dpdaidai.basis.designPattern.observerMode;

import java.util.LinkedList;
import java.util.List;

/**
 * 具体的被观察者 / 发布者
 *
 * 这个示例中 , 被观察者/发布者 模拟了一个体彩中心
 * 它会接受彩票购买人员的订阅
 * 当开奖后 , 它会挨个通知购买人员当期彩票中奖号码
 *
 * @Author chenpantao
 * @Date 4/20/21 11:33 AM
 * @Version 1.0
 */
public class ConcreteSubject implements Subject {

    //创建集合来保存订阅者/观察者
    List<Observer> observerList;

    public ConcreteSubject() {
        observerList = new LinkedList<>();
    }

    //添加订阅者 / 观察者
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    //移出订阅者 / 观察者
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    //通知订阅者 / 观察者
    //本示例中 , 模拟体彩中心通知彩票购买人员中奖号码
    @Override
    public void notifyObserver(String message) {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(message);
        }
    }
}
