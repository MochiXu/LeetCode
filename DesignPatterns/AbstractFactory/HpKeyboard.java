package DesignPatterns.AbstractFactory;

public class HpKeyboard implements Keyboard{
    @Override
    public void knock() {
        System.out.println("HpKeyboard is knocking!");
    }
}
