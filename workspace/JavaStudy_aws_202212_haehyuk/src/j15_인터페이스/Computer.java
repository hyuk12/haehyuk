package j15_인터페이스;

public class Computer implements Calculator{

    @Override
    public double plus(double x, double y) {
        return 0;
    }

    @Override
    public double minus(double x, double y) {
        return 0;
    }

    @Override
    public double multiplication(double x, double y) {
        return Calculator.super.multiplication(x, y);
    }

    @Override
    public double division(double x, double y) {
        if (x == 0 || y == 0) {
            return ERROR;
        }
        return x / y;
    }
}
