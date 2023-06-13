package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewKingdom;
import io.github.syakuis.hfdp.chapter10.State;

public class NoCoinState implements KingdomState {
    private final NewKingdom kingdom;

    public NoCoinState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }
    @Override
    public void insertCoin() {
        Message.insertCoin();
        kingdom.change(State.HAS_COIN);
    }

    @Override
    public void returnCoin() {
        Message.insertCoin();
    }

    @Override
    public void turn() {
        Message.insertCoin();
    }

    @Override
    public void export() {
        Message.insertCoin();
    }
}
