package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewKingdom;
import io.github.syakuis.hfdp.chapter10.State;

public class HasCoinState implements KingdomState {
    private final NewKingdom kingdom;

    public HasCoinState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public void insertCoin() {
        Message.insertOneCoin();
    }

    @Override
    public void returnCoin() {
        Message.returnCoin();
        kingdom.change(State.NO_COIN);
    }

    @Override
    public void turn() {
        Message.turn();
        kingdom.change(State.SOLD);
    }

    @Override
    public void export() {
        Message.export();
    }
}
