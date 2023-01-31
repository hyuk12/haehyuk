package j24_람다;


@FunctionalInterface    // 람다전용 인터페이스이니 추상메소드를 하나만 작성하라
public interface Instrument {
    public String play(String instrument);

    public default String play2(String instrument){
        return play(instrument);
    };
}
