package io.github.syakuis.hfdp.chapter10;

public enum State {
    SOLD_OUT(0, "알맹이 매진"), NO_QUARTER(1, "동전 없음"), HAS_QUARTER(2, "동전 있음"), SOLD(3, "알맹이 판매"), WINNER(4, "당첨");

    private final int code;
    private final String message;

    State(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
