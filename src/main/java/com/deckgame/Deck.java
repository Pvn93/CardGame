package com.deckgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(){
        for(Rank rank : Rank.values()){
            for(Suit suit : Suit.values()){
                cards.add(new Card(rank,suit));
            }
        }
    }

    public Card deal(){
        Collections.shuffle(this.cards);
        return this.cards.remove(0);
    }

    @Override
    public String toString() {
        return "com.deckgame.Deck{" +
                "cards=" + cards +
                '}';
    }

    public List<Card> getCards(){
        return this.cards;
    }


}
