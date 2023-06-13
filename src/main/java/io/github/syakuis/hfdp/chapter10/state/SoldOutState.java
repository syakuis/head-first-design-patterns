package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewKingdom;

public class SoldOutState implements KingdomState {
    private final NewKingdom kingdom;

    public SoldOutState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }
    @Override
    public void insertCoin() {
        Message.soldOut();
    }

    @Override
    public void returnCoin() {
        Message.insertCoin();
    }

    @Override
    public void turn() {
        Message.soldOut();
    }

    @Override
    public void export() {
        Message.soldOut();
    }
}
