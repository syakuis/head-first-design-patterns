package io.github.syakuis.hfdp.chapter10.state;

public interface KingdomState {
    // insertQuarter
    void insertCoin();
    // ejectQuarter
    void returnCoin();
    // turnQuarter
    void turn();
    //dispense
    void export();
}
