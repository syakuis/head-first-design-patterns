package io.github.syakuis.hfdp.chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class KingdomTest {
    @Test
    void test() {
        Kingdom kingdom = new Kingdom(2);

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getCurrentState());

        kingdom.turn();
        assertEquals(State.NO_COIN, kingdom.getCurrentState());

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getCurrentState());

        kingdom.returnCoin();
        assertEquals(State.NO_COIN, kingdom.getCurrentState());

        kingdom.turn();
        assertEquals(State.NO_COIN, kingdom.getCurrentState());

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getCurrentState());

        kingdom.turn();
        assertEquals(State.SOLD_OUT, kingdom.getCurrentState());
    }
}