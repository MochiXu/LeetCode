package DesignPatterns.AbstractFactory;

public class HpMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("HpMouse is clicking!");
    }
}
