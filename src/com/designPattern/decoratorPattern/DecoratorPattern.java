package com.designPattern.decoratorPattern;

/**
 * 装饰模式
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Decorator decorator = new Decorator(sourceable);
        decorator.method();
    }
}
//Source类是被装饰类，Decorator类是一个装饰类，可以为Source类动态的添加一些功能
interface Sourceable {
    void method();
}
class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("Source");
    }
}
class Decorator implements Sourceable {
    Sourceable source;
    Decorator(Sourceable source){
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before");
        source.method();
        System.out.println("after");
    }
}

