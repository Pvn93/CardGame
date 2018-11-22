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
        assertEquals(98,hand.getValue());
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
        assertEquals(99,hand.getValue());
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
        assertEquals(97,hand.getValue());
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
        assertEquals(1,hand.getValue());
    }

    @Test
    public void getValueOfHandSingleCard(){
        List<Card> cards = new ArrayList<>();
        Card ThreeOfSpades = new Card(Rank.THREE, Suit.SPADE);
        cards.add(ThreeOfSpades);
        hand.setCards(cards);
        assertEquals(2,hand.getValue());
    }

    @Test
    public void clearHand(){
        hand.clearHand();
        assertEquals(0,hand.getCards().size());
    }

}