package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewGumballMachine;
import io.github.syakuis.hfdp.chapter10.State;

public class NoQuarterState implements GumballMachineState {
    private final NewGumballMachine gumballMachine;

    public NoQuarterState(NewGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        Message.insertCoin();
        gumballMachine.change(State.HAS_QUARTER);
    }

    @Override
    public void ejectQuarter() {
        Message.insertCoin();
    }

    @Override
    public void turnCrank() {
        Message.insertCoin();
    }

    @Override
    public void dispense() {
        Message.insertCoin();
    }
}
