package io.github.syakuis.hfdp.chapter10.state;

public interface GumballMachineState {
    // insertQuarter
    void insertQuarter();
    // ejectQuarter
    void ejectQuarter();
    // turnQuarter
    void turnCrank();
    //dispense
    void dispense();
}
