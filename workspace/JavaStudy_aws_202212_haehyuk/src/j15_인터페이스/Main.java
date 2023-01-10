package j15_인터페이스;

public class Main {

    public static void main(String[] args) {
        Equipment[] equipments = new Equipment[2];

        equipments[0] = new GeneralCalculator();
        equipments[1] = new SmartPhone();

        Calculator calculator = new Computer();
        calculator.multiplication(5.0,4);

        System.out.println("모든 장비 전원 켜기");
        for (Equipment equip : equipments) {
            equip.powerOn();
        }
        System.out.println();

        System.out.println("모든 장비에서 10과 20을 더하기");
        for (Equipment equip : equipments) {
            Calculator cal = (Calculator) equip;
            double result = cal.plus(10, 20);
            System.out.println("결과: " + result);
        }
        System.out.println();

        System.out.println("모든 장비에서 0과 10을 나누기");
        for (Equipment equip : equipments) {
            Calculator cal = (Calculator) equip;
            double result = cal.division(10, 0);
            System.out.println("결과: " + result);
        }
        System.out.println();

        System.out.println("모든 장비 전원 끄기");
        for (Equipment equip : equipments) {
            equip.powerOff();
        }
        System.out.println();
    }
}
