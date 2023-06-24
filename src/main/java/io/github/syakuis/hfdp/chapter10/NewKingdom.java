package io.github.syakuis.hfdp.chapter10;

import io.github.syakuis.hfdp.chapter10.state.*;

public class NewKingdom {
    private HasCoinState hasCoinState;
    private NoCoinState noCoinState;
    private SoldOutState soldOutState;
    private SoldState soldState;
    private WinnerState winnerState;
    private KingdomState currentState;
    private int count;
    private State state;

    public NewKingdom(int initCount) {
        this.hasCoinState = new HasCoinState(this);
        this.noCoinState = new NoCoinState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);

        this.count = initCount;
        this.currentState = initCount > 0 ? hasCoinState : soldOutState;
        this.state = initCount > 0 ? State.HAS_COIN : State.SOLD_OUT;
    }

    public void setCurrentState(KingdomState state) {
        this.currentState = state;
    }

    public void change(State state) {
        this.state = state;
        switch (state) {
            case HAS_COIN -> setCurrentState(hasCoinState);
            case NO_COIN -> setCurrentState(noCoinState);
            case SOLD_OUT -> setCurrentState(soldOutState);
            case SOLD -> setCurrentState(soldState);
            case WINNER -> setCurrentState(winnerState);
        }
    }

    public KingdomState getCurrentState() {
        return currentState;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void returnCoin() {
        currentState.returnCoin();
    }

    public void turn() {
        currentState.turn();
        // 뇌 단련 - 동전을 넣지 않고 돌리면 구지 내보낼 필요가 없다.
        if (!(currentState instanceof NoCoinState)) {
            currentState.export();
        }

    }

    public void refreshCount() {
        // 알맹이 갯수 갱신
        if (count > 0) count -= 1;
    }
}
