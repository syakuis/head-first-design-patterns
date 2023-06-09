package io.github.syakuis.hfdp.chapter10;

public class GumballMachine {
    private State currentState;
    private int count;

    public GumballMachine(int initCount) {
        this.count = initCount;
        this.currentState = initCount > 0 ? State.HAS_QUARTER : State.SOLD_OUT;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void insertQuarter() {
        switch (currentState) {
            case HAS_QUARTER -> Message.insertOneCoin();
            case NO_QUARTER -> {
                System.out.println("동전을 넣었습니다.");
                currentState = State.HAS_QUARTER;
            }
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> Message.export();
        }
    }

    public void ejectQuarter() {
        switch (currentState) {
            case HAS_QUARTER -> {
                Message.returnCoin();
                currentState = State.NO_QUARTER;
            }
            case NO_QUARTER -> System.out.println("동전을 넣어주세요.");
            case SOLD_OUT -> System.out.println("매진되었습니다.");
            case SOLD -> System.out.println("이미 알맹이를 뽑으셨습니다.");

        }
    }

    public void turnCrank() {
        switch (currentState) {
            case HAS_QUARTER -> {
                Message.turn();
                this.currentState = State.SOLD;
                dispense();
            }
            case NO_QUARTER -> System.out.println("동전을 넣어주세요.");
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> Message.turnOne();
        }
    }

    private void dispense() {
        switch (currentState) {
            case HAS_QUARTER -> System.out.println("알맹이를 내보낼수 없습니다.");
            case NO_QUARTER -> Message.insertCoin();
            case SOLD_OUT -> Message.soldOut();
            case SOLD -> {
                Message.export();

                // 알맹이 갯수 갱신
                if (count > 0) count -= 1;

                // 매진 여부 확인
                if (count == 0) {
                    Message.soldOut();
                    currentState = State.SOLD_OUT;
                } else {
                    currentState = State.NO_QUARTER;
                }
            }
        }
    }
}
