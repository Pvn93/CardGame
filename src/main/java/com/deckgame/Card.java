package com.deckgame;

public class Card {

 private Rank rank;

 private Suit suit;

 public Card(Rank rank, Suit suit){
     this.rank = rank;
     this.suit = suit;
 }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}

