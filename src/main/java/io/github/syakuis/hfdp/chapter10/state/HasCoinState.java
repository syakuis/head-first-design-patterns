package io.github.syakuis.hfdp.chapter10.state;

import io.github.syakuis.hfdp.chapter10.Message;
import io.github.syakuis.hfdp.chapter10.NewKingdom;
import io.github.syakuis.hfdp.chapter10.State;

import java.util.Random;

public class HasCoinState implements KingdomState {
    private final NewKingdom kingdom;
    private final Random random = new Random(System.currentTimeMillis());

    public HasCoinState(NewKingdom kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public void insertCoin() {
        Message.insertOneCoin();
    }

    @Override
    public void returnCoin() {
        Message.returnCoin();
        kingdom.change(State.NO_COIN);
    }

    @Override
    public void turn() {
        Message.turn();

        // 10% 확률로 당첨 여부
        int winner = random.nextInt(10);

        // 보너스 알맹이까지 총 2개이상 알맹이가 남아 있어야 한다.
        if (winner == 0 && kingdom.getCount() > 1) {
            kingdom.change(State.WINNER);
        } else {
            kingdom.change(State.SOLD);
        }

    }

    @Override
    public void export() {
        Message.export();
    }
}
