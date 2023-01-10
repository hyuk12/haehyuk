package j13_상속.casting2;

public class Main {

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Subway subway  = new Subway();

//        Transportation transportation = new Transportation();
//        Taxi t1 = (Taxi) transportation;    // 다운캐스팅
//
//        Transportation transportation1 = taxi;
//        Subway s1 = (Subway) transportation1;

        Transportation transportation2 = subway;

        Transportation[] transportations = new Transportation[6];

        transportations[0] = taxi;
        transportations[1] = subway;
        transportations[2] = taxi;
        transportations[3] = subway;
        transportations[4] = taxi;
        transportations[5] = subway;

        for (int i = 0; i < transportations.length; i++) {
            if (transportations[i] instanceof Taxi) {
                Taxi tx = (Taxi)transportations[i];
                tx.checkTaxiNumber();

            }else if (transportations[i] instanceof Subway) {
                Subway sw = (Subway) transportations[i];
                sw.checkRoute();

            }
            transportations[i].go();
            System.out.println();
        }
        // 일반 for 문에서 forEach 문으로 변경
        for (Transportation t : transportations) {
            t.stop();
            System.out.println();
        }

    }
}
