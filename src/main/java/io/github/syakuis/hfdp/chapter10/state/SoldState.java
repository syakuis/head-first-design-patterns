package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewGumballMachine;
import io.github.syakuis.hfdp.chapter10.State;

public class SoldState implements GumballMachineState {
    private final NewGumballMachine gumballMachine;

    public SoldState(NewGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        Message.export();
    }

    @Override
    public void ejectQuarter() {
        Message.export();
    }

    @Override
    public void turnCrank() {
        Message.turnOne();
    }

    @Override
    public void dispense() {
        Message.export();

        gumballMachine.refreshCount();

        if (gumballMachine.getCount() == 0) {
            Message.soldOut();
            gumballMachine.change(State.SOLD_OUT);
        } else {
            gumballMachine.change(State.NO_QUARTER);
        }
    }
}
