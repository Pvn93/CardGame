package com.deckgametest;

import com.deckgame.Deck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class DeckTest {

    @InjectMocks
    @Spy
    Deck deck;


    @Test
    public void deal() {
        deck.deal();
        assertEquals(51,deck.getCards().size());
    }

    @Test
    public void initialization(){
        assertEquals(52, deck.getCards().size());
    }
}