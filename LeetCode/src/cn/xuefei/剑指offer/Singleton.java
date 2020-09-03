package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-08-31
 * @version: 1.0
 * @description: TODO
 */
public class Singleton {
    // volatile两个作用 可见性和禁止指令重排序
    private volatile static Singleton singleton = null;
    private String test;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    // 分配内存
                    // 空间置零
                    // 给singleton赋值 (singleton就是不null了,这会出问题,要用volatile禁止指令重排序)
                    // 调用构造函数
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
