package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;

public class HasCoinState implements KingdomState {
    @Override
    public void insertCoin() {
        Message.insertOneCoin();
    }

    @Override
    public void returnCoin() {
        Message.returnCoin();
    }

    @Override
    public void turn() {

    }

    @Override
    public void export() {

    }
}
