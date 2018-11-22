package com.deckgame;

public enum Suit {
    SPADE(1),
    HEART(2),
    DIAMOND(3),
    CLUB(4);

    private int cardinality;

    Suit(int cardinality){
        this.cardinality = cardinality;
    }

}