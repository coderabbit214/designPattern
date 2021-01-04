package com.designPattern.abstractFactoryPattern;


/**
 * 抽象工厂模式
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory shape = FactoryProducer.getFactory("SHAPE");
        System.out.println(shape.getColor("RED"));
        Shape rectangle = shape.getShape("RECTANGLE");
        rectangle.draw();
    }
}
//创建工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————//
//创建抽象类获取工厂
abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
//实现抽象类
class ColorFactory extends AbstractFactory{
    public Color getColor(String colorType){
        if(colorType.equalsIgnoreCase("RED")){
            return new Red();
        } else if(colorType.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
//实现抽象类
class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————//
//创建颜色接口
interface Color{
    void fill();
}
//创建颜色实现类
class Red implements Color{

    @Override
    public void fill() {
        System.out.println("red");
    }
}
//创建颜色实现类
class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("blue");
    }
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————//
//创建图形接口类
interface Shape{
    void draw();
}
//创建图形实现类
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
//创建图形实现类
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
