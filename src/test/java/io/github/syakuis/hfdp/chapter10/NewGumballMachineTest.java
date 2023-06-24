package io.github.syakuis.hfdp.chapter10;

import org.junit.jupiter.api.Test;

class NewGumballMachineTest {
    @Test
    void test() {
        NewGumballMachine gumballMachine = new NewGumballMachine(10);

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.ejectQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();

        gumballMachine.turnCrank();
    }
}