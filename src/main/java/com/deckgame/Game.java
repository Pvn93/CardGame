package com.deckgame;

import org.apache.log4j.Logger;

public class Game {

    private static final Logger logger = Logger.getLogger(Game.class);
    public static void main(String [] args){
        Deck deck = new Deck();
        Player playerA = new Player();
        Player playerB = new Player();
        dealCardsToThePlayers(deck, playerA, playerB, 3);

        Player winner = compareHandsOfEachPlayerAndPickWinner(deck,playerA, playerB);
        logger.info("Calculating winner .....");
        logger.info("The winner is :"+ winner);
        logger.info("The hand of each player:");
        logger.info(playerA);
        logger.info(playerB);

    }

    public static void dealCardsToThePlayers(Deck deck, Player playerA, Player playerB, int nbrOfCardsToDeal){
        for(int i=0; i < nbrOfCardsToDeal; i++) {
            playerA.getHand().getCards().add(deck.deal());
            playerB.getHand().getCards().add(deck.deal());
        }
    }

    public static Player compareHandsOfEachPlayerAndPickWinner(Deck deck ,Player playerA, Player playerB){
        int valueOfPlayerAHand = playerA.getHand().getValue();
        int valueOfPlayerBHand = playerB.getHand().getValue();
        if(logger.isDebugEnabled()) {
            logger.debug("playerA value:" + valueOfPlayerAHand);
            logger.debug("playerB value:" + valueOfPlayerBHand);
        }
        if(valueOfPlayerAHand > valueOfPlayerBHand){
            return playerA;
        }
        else if(valueOfPlayerBHand > valueOfPlayerAHand){
            return playerB;
        }
        else{
            logger.info("Tied...Dealing one more round and comparing");
            playerA.getHand().clearHand();
            playerB.getHand().clearHand();
            dealCardsToThePlayers(deck, playerA, playerB, 1);
            return compareHandsOfEachPlayerAndPickWinner(deck,playerA, playerB);
        }
    }
}
