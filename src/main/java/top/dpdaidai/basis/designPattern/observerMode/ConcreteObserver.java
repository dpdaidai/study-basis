package top.dpdaidai.basis.designPattern.observerMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体的订阅者/观察者 , 对Subject发布者的通知执行具体操作
 *
 * 这里订阅者是彩票购买人员
 * 订阅者是体彩中心
 *      1. 彩票购买人员在体彩中心订阅了当期彩票的号码
 *      2. 开奖时 , 体彩中心将号码挨个告诉购买人员
 *      3. 彩票购买人员将会拿着当期中奖号码和自己进行比对
 *
 * @Author chenpantao
 * @Date 4/20/21 11:39 AM
 * @Version 1.0
 */
public class ConcreteObserver implements Observer {

    private static final String TAG = "ConcreteObserver";

    private static final Logger logger = LoggerFactory.getLogger(ConcreteObserver.class);

    //用户名
    String name;

    //中奖号码
    String number;

    //初始化 观察者 / 订阅者 的用户名和号码
    public ConcreteObserver(String name, String number) {
        this.name = name;
        this.number = number;
    }

    //订阅后 , 有相关事件时 , 发布者通过订阅者的这个方法来进行通知 . 订阅者进而执行相应的逻辑
    //在这个示例中 , 订阅者会拿着号码比对自己是否中奖
    @Override
    public void update(String message) {
        logger.info("当期中奖号码是 : {}", message);
        if (this.number.equals(message)) {
            logger.info("{} 的号码是{}, 他中奖了", this.name, this.number);
        } else {
            logger.info("{} 的号码是{}, 他未能了", this.name, this.number);
        }
    }
}
