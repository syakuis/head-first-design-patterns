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

    public NewKingdom(int initCount) {
        this.hasCoinState = new HasCoinState(this);
        this.noCoinState = new NoCoinState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);

        this.count = initCount;
        this.currentState = initCount > 0 ? hasCoinState : soldOutState;
    }

    public void setCurrentState(KingdomState state) {
        this.currentState = state;
    }

    public void change(State state) {
        switch (state) {
            case HAS_COIN -> setCurrentState(hasCoinState);
            case NO_COIN -> setCurrentState(noCoinState);
            case SOLD_OUT -> setCurrentState(soldOutState);
            case SOLD -> setCurrentState(soldState);
        }
    }

    public KingdomState getCurrentState() {
        return currentState;
    }

    public int getCount() {
        return count;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void returnCoin() {
        currentState.returnCoin();
    }

    public void turn() {
        currentState.turn();
        currentState.export();
    }

    public void resetCount() {
        Message.export();

        // 알맹이 갯수 갱신
        if (count > 0) count -= 1;
    }
}
