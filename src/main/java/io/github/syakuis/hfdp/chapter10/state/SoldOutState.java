package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewGumballMachine;

public class SoldOutState implements GumballMachineState {
    private final NewGumballMachine gumballMachine;

    public SoldOutState(NewGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        Message.soldOut();
    }

    @Override
    public void ejectQuarter() {
        Message.insertCoin();
    }

    @Override
    public void turnCrank() {
        Message.soldOut();
    }

    @Override
    public void dispense() {
        Message.soldOut();
    }
}
