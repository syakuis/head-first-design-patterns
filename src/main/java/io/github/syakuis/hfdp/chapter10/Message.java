package io.github.syakuis.hfdp.chapter10;

public class Message {
    private static final String INSERT_ONE_COIN = "동전을 한 개만 넣어 주세요.";
    private static final String INSERT_COIN = "동전을 넣어 주세요.";
    private static final String SOLD_OUT = "매진되었습니다.";
    private static final String EXPORT = "알맹이를 내보내고 있습니다.";
    private static final String RETURN_COIN = "동전을 반환됩니다.";
    private static final String TURN_ONE = "손잡이를 한 번만 돌려 주세요.";
    private static final String TURN = "손잡이를 돌리셨습니다.";

    public static void insertOneCoin() {
        System.out.println(INSERT_ONE_COIN);
    }

    public static void insertCoin() {
        System.out.println(INSERT_COIN);
    }

    public static void soldOut() {
        System.out.println(SOLD_OUT);
    }

    public static void export() {
        System.out.println(EXPORT);
    }

    public static void returnCoin() {
        System.out.println(RETURN_COIN);
    }

    public static void turnOne() {
        System.out.println(TURN_ONE);
    }

    public static void turn() {
        System.out.println(TURN);
    }

}
