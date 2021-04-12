package top.dpdaidai.basis.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的创建
 * 1、通过数组
 * 2、通过集合来
 * 3、通过Stream.generate方法来创建
 * 4、通过Stream.iterate方法来创建
 * 5、其他API创建
 *
 * Stream常用API
 * 中间操作
 * 过滤 filter
 * 去重 distinct
 * 排序 sorted
 * 截取 limit、skip
 * 转换 map/flatMap
 * 其他 peek
 *
 * Stream常用API
 * 终止操作
 * 循环 forEach
 * 计算 min、max、count、 average
 * 匹配 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny
 * 汇聚 reduce
 * 收集器 toArray collect
 *
 * @Author chenpantao
 * @Date 4/12/21 3:35 PM
 * @Version 1.0
 */
public class StreamDemo {

    //通过数组生成
    static void generateStream() {
        String[] strings = new String[]{"a", "b", "c", "d"};
        Stream<String> stream = Stream.of(strings);
        stream.forEach(System.out::println);
    }

    //通过集合生成
    static void generateStream1() {
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //使用generate生成无线流
    static void generateStream2() {
        Stream<Long> generate = Stream.generate(() -> System.currentTimeMillis());
        generate.forEach(System.out::println);
    }

    //使用limit截断流
    static void generateStream3() {
        Stream<Long> generate = Stream.generate(() -> System.currentTimeMillis());
        generate.limit(10).forEach(System.out::println);
    }

    //使用iterator生成流
    static void generateStream4() {
        Stream<Integer> iterate = Stream.iterate(1, e -> e + 2);
        iterate.limit(10).forEach(System.out::println);

    }

    //其他方式
    static void generateStream5() {
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        generateStream();
//        generateStream1();
//        generateStream2();
//        generateStream3();
//        generateStream4();
//        generateStream5();


        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5, 6);

        //中间操作 : 如果调用得方法返回值是Stream , 则是中间操作

        //filter
        list.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

        //终止操作
        //count
        long count = list.stream().filter(e -> e % 2 == 0).count();
        System.out.println(count);

        //sum
        int sum = list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e).sum();
        System.out.println(sum);

        //max
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());

        //min
        Optional<Integer> min = list.stream().min((a, b) -> a - b);
        System.out.println(min.get());

        //findFirst
        Optional<Integer> first = list.stream().filter(e -> e % 2 == 0).findFirst();
        System.out.println(first.get());

        //Optional为空
        Optional<Integer> noElement = list.stream().filter(e -> e % 7 == 0).findFirst();
        System.out.println(noElement.isPresent());

        //1  流在 '终止操作' 前不会运行中间操作
        //2  流内每个元素单独前进 , 不是每次中间操作结束后 , 形成一个新得流再进行下一个操作
        Stream<Integer> stream = list.stream().filter(e -> {
            System.out.println(e);
            if (e % 2 == 0) {
                return true;
            }
            return false;
        });
        System.out.println("steam在终止操作前不会执行中间操作");
        Optional<Integer> first1 = stream.filter(e -> e % 1 == 0).findAny();
        System.out.println("执行完毕 , 流在满足终止操作时 , 就会立刻停止 : findAny - " + first1.get());
//        System.out.println(stream.filter(e -> e % 1 == 0).count());


        //获取最大值和最小值 , 不使用 min 和 max 方法
        Optional<Integer> min1 = list.stream().sorted().findFirst();
        System.out.println(min1.get());
        Optional<Integer> max1 = list.stream().sorted((a, b) -> b - a).findFirst();
        System.out.println(max1.get());

        //字符串排序
        List<String> stringList = Arrays.asList("java", "c#", "python", "scala");
        stringList.stream().sorted().forEach(System.out::println);
        stringList.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

        //返回集合对象
        List<Integer> collect = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        //去重操作
        list.stream().distinct().forEach(System.out::println);

        //利用set去重
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);

        //skip , limit
        Stream.iterate(1, e -> e + 1).limit(50).skip(20).limit(10).forEach(System.out::println);

        //String -> [] -> list
        String s = "1,2,3,4,5";
        System.out.println(Stream.of(s.split(",")).mapToInt(e -> Integer.valueOf(e)).sum());
        System.out.println(Stream.of(s.split(",")).mapToInt(Integer::valueOf).sum());


        //使用构造方法构造person
        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(e -> new Person(e)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);

        //使用static构造person
        Stream.of(str2.split(",")).map(e -> Person.build(e)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //peek
        //将stream中得每一个数值打印出来 , 并且求和
        System.out.println(Stream.of(s.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        //allMath 检查流中元素是否都满足条件
        System.out.println(list.stream().allMatch(e -> e % 2 == 0));
        System.out.println(list.stream().allMatch(e -> e >= 0));




    }

}
