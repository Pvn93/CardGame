package com.deckgame;

public class Player {

    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "com.deckgame.Player{" +
                "hand=" + hand +
                '}';
    }
}
