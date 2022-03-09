package DesignPatterns.AbstractFactory;

public class DellKeyboard implements Keyboard{
    @Override
    public void knock() {
        System.out.println("DellKeyboard is knocking!");
    }
}
