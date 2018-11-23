package com.deckgametest;

import com.deckgame.Card;
import com.deckgame.Deck;
import com.deckgame.Game;
import com.deckgame.Hand;
import com.deckgame.Player;
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
public class GameTest {

    @InjectMocks
    @Spy
    Game game;


    @Test
    public void dealCardsToThePlayers() {
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();
        Game.dealCardsToThePlayers(deck, player1,player2,3);
        assertEquals(46,deck.getCards().size());
    }

    @Test
    public void compareHandsOfEachPlayerOne() {
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();

        Hand hand1 = new Hand();
        List<Card> cards1 = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card JackOfSpades = new Card(Rank.KING, Suit.SPADE);
        Card QueenOfSpades = new Card(Rank.QUEEN, Suit.SPADE);
        cards1.add(AceOfSpades);
        cards1.add(JackOfSpades);
        cards1.add(QueenOfSpades);
        hand1.setCards(cards1);


        List<Card> cards2 = new ArrayList<>();
        Hand hand2 = new Hand();
        Card AceOfSpades2 = new Card(Rank.ACE, Suit.SPADE);
        Card AceOfHeart = new Card(Rank.ACE, Suit.HEART);
        Card AceOfDiamond = new Card(Rank.ACE, Suit.DIAMOND);
        cards2.add(AceOfSpades2);
        cards2.add(AceOfHeart);
        cards2.add(AceOfDiamond);
        hand2.setCards(cards2);


        player1.setHand(hand1);
        player2.setHand(hand2);

        assertEquals(player2,Game.compareHandsOfEachPlayerAndPickWinner(deck,player1,player2));
    }

    @Test
    public void compareHandsOfEachPlayerTwo() {
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();

        Hand hand1 = new Hand();
        List<Card> cards1 = new ArrayList<>();
        Card AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        Card JackOfSpades = new Card(Rank.KING, Suit.SPADE);
        Card QueenOfSpades = new Card(Rank.FIVE, Suit.SPADE);
        cards1.add(AceOfSpades);
        cards1.add(JackOfSpades);
        cards1.add(QueenOfSpades);
        hand1.setCards(cards1);


        List<Card> cards2 = new ArrayList<>();
        Hand hand2 = new Hand();
        Card AceOfSpades2 = new Card(Rank.ACE, Suit.SPADE);
        Card AceOfHeart = new Card(Rank.TWO, Suit.HEART);
        Card AceOfDiamond = new Card(Rank.TWO, Suit.DIAMOND);
        cards2.add(AceOfSpades2);
        cards2.add(AceOfHeart);
        cards2.add(AceOfDiamond);
        hand2.setCards(cards2);


        player1.setHand(hand1);
        player2.setHand(hand2);

        assertEquals(player2,Game.compareHandsOfEachPlayerAndPickWinner(deck,player1,player2));
    }
}