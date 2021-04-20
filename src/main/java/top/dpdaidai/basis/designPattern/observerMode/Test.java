package top.dpdaidai.basis.designPattern.observerMode;

/**
 *
 * 转载https://www.jianshu.com/p/cbf47463e0ed
 *
 * 观察者模式 / 订阅-发布模式
 * 观察者就是订阅者 , 被观察者就是发布者
 * 是一种一对一或者一对多的依赖关系，当一个对象改变状态，依赖它的对象会收到通知并自动更新。
 *
 * 我更喜欢称呼为订阅-发布模式 . 它可以这样理解
 *      1.  角色分为订阅者和发布者
 *      2.  订阅者到发布者这里注册自己
 *      3.  发布者在发生事情的时候 , 调用订阅者的某个方法 , 来完成业务逻辑
 *
 * * 这里订阅者是彩票购买人员
 *   订阅者是体彩中心
 *  *      1. 彩票购买人员在体彩中心订阅了当期彩票的号码
 *  *      2. 开奖时 , 体彩中心将号码挨个告诉购买人员
 *  *      3. 彩票购买人员将会拿着当期中奖号码和自己进行比对
 *
 *
 * @Author chenpantao
 * @Date 4/20/21 12:01 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        //创建发布者/体彩中心
        ConcreteSubject concreteSubject = new ConcreteSubject();

        //创建订阅者/彩票购买人员A
        ConcreteObserver a = new ConcreteObserver("A", "123456");

        //创建订阅者/彩票购买人员B
        ConcreteObserver b = new ConcreteObserver("B", "222222");

        //订阅者到发布者处注册自己
        //购买人员到体彩中心留下自己的联系方式
        concreteSubject.registerObserver(a);
        concreteSubject.registerObserver(b);

        //发布者通知订阅者
        //体彩中心发送购买人员当期号码
        concreteSubject.notifyObserver("222222");


    }

}
