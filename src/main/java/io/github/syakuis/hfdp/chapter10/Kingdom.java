package io.github.syakuis.hfdp.chapter10;

public class Kingdom {
    private State currentState;
    private int count;

    public Kingdom(int initCount) {
        this.count = initCount;
        this.currentState = initCount > 0 ? State.HAS_COIN : State.SOLD_OUT;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void insertCoin() {
        switch (currentState) {
            case HAS_COIN -> Message.insertOneCoin();
            case NO_COIN -> {
                Message.insertCoin();
                currentState = State.HAS_COIN;
            }
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> Message.export();
        }
    }

    public void returnCoin() {
        switch (currentState) {
            case HAS_COIN -> {
                Message.returnCoin();;
                currentState = State.NO_COIN;
            }
            case NO_COIN, SOLD_OUT -> Message.insertCoin();
            case SOLD -> Message.export();

        }
    }

    public void turn() {
        switch (currentState) {
            case HAS_COIN -> {
                Message.turn();
                this.currentState = State.SOLD;
                export();
            }
            case NO_COIN -> Message.insertCoin();
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> Message.turnOne();
        }
    }

    private void export() {
        switch (currentState) {
            case HAS_COIN -> Message.export();
            case NO_COIN -> Message.insertCoin();
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> {
                Message.export();

                // 알맹이 갯수 갱신
                count -= 1;

                // 매진 여부 확인
                if (count == 0) {
                    Message.soldOut();
                    currentState = State.SOLD_OUT;
                } else {
                    currentState = State.NO_COIN;
                }
            }
        }
    }
}
