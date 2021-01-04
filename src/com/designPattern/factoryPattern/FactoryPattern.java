package com.designPattern.factoryPattern;

/**
 * 工厂模式
 */
public class FactoryPattern {
//使用
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}
//创建工厂
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
//创建接口类
interface Shape{
    void draw();
}
//创建实现类
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
//创建实现类
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

