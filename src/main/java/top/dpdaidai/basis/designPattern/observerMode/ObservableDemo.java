package top.dpdaidai.basis.designPattern.observerMode;


import rx.Observable;
import rx.Subscriber;

/**
 *
 * 基于rx 框架下实现的观察者模式demo
 *
 * TODO 还需要更细致的了解
 *
 * @Author chenpantao
 * @Date 4/15/21 2:48 PM
 * @Version 1.0
 */
public class ObservableDemo {

    public static void main(String[] args) {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("0 0 ");
                subscriber.onCompleted();
            }

        });

        observable.subscribe(subscriber);


    }

}
