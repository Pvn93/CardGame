package com.deckgametest;

import com.deckgame.Card;
import com.deckgame.Hand;
import com.deckgame.Rank;
import com.deckgame.Suit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class HandTest {


    @InjectMocks
    @Spy
    Hand hand;

    public static final int BEST_VALUE_OF_HAND = 99;
    public static final int SECOND_BEST_VALUE_OF_HAND = 98;
    public static final int THIRD_BEST_VALUE_OF_HAND = 97;


    @Test
    public void getValueOfHandConsecutive() {
        List<Card> cards = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card JackOfSpades = new Card(Rank.KING, Suit.SPADE);
        Card QueenOfSpades = new Card(Rank.QUEEN, Suit.SPADE);
        cards.add(AceOfSpades);
        cards.add(JackOfSpades);
        cards.add(QueenOfSpades);
        hand.setCards(cards);
        assertEquals(SECOND_BEST_VALUE_OF_HAND,hand.getValue());
    }

    @Test
    public void getValueOfHandTrail() {
        List<Card> cards = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card AceOfHeart = new Card(Rank.ACE, Suit.HEART);
        Card AceOfDiamond = new Card(Rank.ACE, Suit.DIAMOND);
        cards.add(AceOfSpades);
        cards.add(AceOfHeart);
        cards.add(AceOfDiamond);
        hand.setCards(cards);
        assertEquals(BEST_VALUE_OF_HAND,hand.getValue());
    }

    @Test
    public void getValueOfHandPair() {
        List<Card> cards = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card AceOfHeart = new Card(Rank.ACE, Suit.HEART);
        Card JackOfSpades = new Card(Rank.JACK, Suit.SPADE);
        cards.add(AceOfSpades);
        cards.add(AceOfHeart);
        cards.add(JackOfSpades);
        hand.setCards(cards);
        assertEquals(THIRD_BEST_VALUE_OF_HAND,hand.getValue());
    }

    @Test
    public void getValueOfHandHighestValue() {
        List<Card> cards = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card QueenOfSpades = new Card(Rank.QUEEN, Suit.SPADE);
        Card JackOfSpades = new Card(Rank.JACK, Suit.SPADE);
        cards.add(AceOfSpades);
        cards.add(QueenOfSpades);
        cards.add(JackOfSpades);
        hand.setCards(cards);
        assertEquals(14,hand.getValue());
    }

    @Test
    public void getValueOfHandSingleCard(){
        List<Card> cards = new ArrayList<>();
        Card ThreeOfSpades = new Card(Rank.THREE, Suit.SPADE);
        cards.add(ThreeOfSpades);
        hand.setCards(cards);
        assertEquals(3,hand.getValue());
    }

    @Test
    public void clearHand(){
        hand.clearHand();
        assertEquals(0,hand.getCards().size());
    }

    @Test
    public void getValueOfHandConsecutiveEdgeCase() {
        List<Card> cards = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card JackOfSpades = new Card(Rank.TWO, Suit.SPADE);
        Card QueenOfSpades = new Card(Rank.THREE, Suit.SPADE);
        cards.add(AceOfSpades);
        cards.add(JackOfSpades);
        cards.add(QueenOfSpades);
        hand.setCards(cards);
        assertEquals(SECOND_BEST_VALUE_OF_HAND,hand.getValue());
    }

}