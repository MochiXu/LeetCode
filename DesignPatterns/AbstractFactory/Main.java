package DesignPatterns.AbstractFactory;

public class Main {
    public static void main(String args[]) {

        //创建戴尔工厂
        PcFactory dellFactory = new DellFactory();
        //利用戴尔工厂创建鼠标和键盘
        Mouse dellMouse = dellFactory.createMouse();
        Keyboard dellKeyBoard = dellFactory.createKeyboard();
        dellMouse.click();
        dellKeyBoard.knock();

        //创建惠普工厂
        PcFactory hpFactory = new HpFactory();
        //利用惠普工厂创建鼠标和键盘
        Mouse hpMouse = hpFactory.createMouse();
        Keyboard hpKeyBoard = hpFactory.createKeyboard();
        hpMouse.click();
        hpKeyBoard.knock();

    }
}
