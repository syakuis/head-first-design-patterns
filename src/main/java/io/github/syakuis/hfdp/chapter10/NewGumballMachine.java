package io.github.syakuis.hfdp.chapter10;

import io.github.syakuis.hfdp.chapter10.state.*;

public class NewGumballMachine {
    private final HasQuarterState hasQuarterState;
    private final NoQuarterState noQuarterState;
    private final SoldOutState soldOutState;
    private final SoldState soldState;
    private final WinnerState winnerState;
    private GumballMachineState currentState;
    private int count;
    private State state;

    public NewGumballMachine(int initCount) {
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);

        this.count = initCount;
        this.currentState = initCount > 0 ? hasQuarterState : soldOutState;
        this.state = initCount > 0 ? State.HAS_QUARTER : State.SOLD_OUT;
    }

    public void setCurrentState(GumballMachineState state) {
        this.currentState = state;
    }

    public void change(State state) {
        this.state = state;
        switch (state) {
            case HAS_QUARTER -> setCurrentState(hasQuarterState);
            case NO_QUARTER -> setCurrentState(noQuarterState);
            case SOLD_OUT -> setCurrentState(soldOutState);
            case SOLD -> setCurrentState(soldState);
            case WINNER -> setCurrentState(winnerState);
        }
    }

    public GumballMachineState getCurrentState() {
        return currentState;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        // 뇌 단련 - 동전을 넣지 않고 돌리면 구지 내보낼 필요가 없다.
        if (!(currentState instanceof NoQuarterState)) {
            currentState.dispense();
        }

    }

    public void refreshCount() {
        // 알맹이 갯수 갱신
        if (count > 0) count -= 1;
    }
}
