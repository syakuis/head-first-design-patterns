package io.github.syakuis.hfdp.chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewKingdomTest {
    @Test
    void test() {
        NewKingdom kingdom = new NewKingdom(2);

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getState());

        kingdom.turn();
        assertEquals(State.NO_COIN, kingdom.getState());

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getState());

        kingdom.returnCoin();
        assertEquals(State.NO_COIN, kingdom.getState());

        kingdom.turn();
        assertEquals(State.NO_COIN, kingdom.getState());

        kingdom.insertCoin();
        assertEquals(State.HAS_COIN, kingdom.getState());

        kingdom.turn();
        assertEquals(State.SOLD_OUT, kingdom.getState());
    }
}