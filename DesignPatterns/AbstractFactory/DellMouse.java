package DesignPatterns.AbstractFactory;

public class DellMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("DellMouse is clicking!");
    }
}
