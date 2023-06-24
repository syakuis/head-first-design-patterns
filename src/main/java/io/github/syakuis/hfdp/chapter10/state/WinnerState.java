package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewKingdom;
import io.github.syakuis.hfdp.chapter10.State;

public class WinnerState implements KingdomState {
    private final NewKingdom kingdom;
    public WinnerState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }
    @Override
    public void insertCoin() {
        Message.export();
    }

    @Override
    public void returnCoin() {
        Message.export();
    }

    @Override
    public void turn() {
        Message.turnOne();
    }

    @Override
    public void export() {
        Message.export();

        kingdom.refreshCount();

        if (kingdom.getCount() == 0) {
            Message.soldOut();
            kingdom.change(State.SOLD_OUT);
        } else {
            System.out.println(Message.WINNER);
            kingdom.refreshCount();

            if (kingdom.getCount() > 0) {
                kingdom.change(State.NO_COIN);
            } else {
                Message.soldOut();
                kingdom.change(State.SOLD_OUT);
            }
        }
    }
}
