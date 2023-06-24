package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewGumballMachine;
import io.github.syakuis.hfdp.chapter10.State;

import java.util.Random;

public class HasQuarterState implements GumballMachineState {
    private final NewGumballMachine gumballMachine;
    private final Random random = new Random(System.currentTimeMillis());

    public HasQuarterState(NewGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        Message.insertOneCoin();
    }

    @Override
    public void ejectQuarter() {
        Message.returnCoin();
        gumballMachine.change(State.NO_QUARTER);
    }

    @Override
    public void turnCrank() {
        Message.turn();

        // 10% 확률로 당첨 여부
        int winner = random.nextInt(10);

        // 보너스 알맹이까지 총 2개이상 알맹이가 남아 있어야 한다.
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.change(State.WINNER);
        } else {
            gumballMachine.change(State.SOLD);
        }

    }

    @Override
    public void dispense() {
        Message.export();
    }
}
