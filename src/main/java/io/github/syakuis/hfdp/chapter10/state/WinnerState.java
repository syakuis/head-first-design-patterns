package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.NewKingdom;

public class WinnerState implements KingdomState {
    private final NewKingdom kingdom;

    public WinnerState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }
    @Override
    public void insertCoin() {

    }

    @Override
    public void returnCoin() {

    }

    @Override
    public void turn() {

    }

    @Override
    public void export() {

    }
}
