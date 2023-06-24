package io.github.syakuis.hfdp.chapter10;

import org.junit.jupiter.api.Test;
class GumballMachineTest {
    @Test
    void test() {
        GumballMachine gumballMachine = new GumballMachine(2);

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.ejectQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();
    }
}