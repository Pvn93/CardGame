package com.deckgame;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class Game {

    private static final Logger logger = Logger.getLogger(Game.class);

    public static void main(final String [] args) throws InValidNbrOfPlayersException {

        final int nbrOfCardsToDeal = 3;
        final int nbrOfPlayers = Integer.parseInt(args[0]);
        if(nbrOfPlayers <= 1){
            throw new InValidNbrOfPlayersException("The game needs at least two players");
        }

        List<Player> players = new ArrayList<>();
        // add all the players to a list
        for(int i=0; i < nbrOfPlayers; i++){
            players.add(new Player());
        }
        // deal each player the cards
        Deck deck = new Deck();
        for(int i=0; i < nbrOfCardsToDeal; i++){
            players.stream().forEach(p -> dealCardToPlayer(deck,p));
        }

        Player winner = pickWinner(deck,players);
        if(logger.isInfoEnabled()) {
            logger.info("Calculating winner .....");
            logger.info("The winner is :" + winner);
            logger.info("The hand of each player:" + players);
        }
    }


    public static void dealCardToPlayer(Deck deck, Player player){
        player.getHand().getCards().add(deck.deal());
    }

    public static Player pickWinner(Deck deck , List<Player> players){

        TreeMap<Integer,List<Player>> playerHandValueMap = new TreeMap<>(Collections.reverseOrder());
        List<Player> playersHavingSameValue;

        for(Player p : players){
            if(playerHandValueMap.get(p.getHand().getValue()) == null){
                playersHavingSameValue = new ArrayList<>();
            }
            else{
                playersHavingSameValue = playerHandValueMap.get(p.getHand().getValue());
            }
            playersHavingSameValue.add(p);
            playerHandValueMap.put(p.getHand().getValue(), playersHavingSameValue);
        }

        if(logger.isDebugEnabled()) {
            logger.debug("playerHandValueMap:" + playerHandValueMap);
        }

        Optional<Integer> firstValue = playerHandValueMap.keySet().stream().findFirst();

        // if only player has the highest hand value, declare that player as winner
        if(firstValue.isPresent() && playerHandValueMap.get(firstValue.get()).size() == 1){
            return playerHandValueMap.get(firstValue.get()).get(0);
        }
        // if more than one player has the same hand value, deal one more round to those players and compare again
        else{
            // find tied players
            List<Player> tiedPlayers = playerHandValueMap.get(firstValue.get());
            if(logger.isInfoEnabled()) {
                logger.info("Tied between " + tiedPlayers.size() + " players");
            }
            // clear their hand
            if(logger.isDebugEnabled()) {
                logger.debug("Hands of the tied players....");
                logger.debug(tiedPlayers);
            }
            tiedPlayers.stream().forEach(p -> p.getHand().clearHand());

            // deal once again to them
            if(logger.isInfoEnabled()) {
                logger.info("Dealing them one more round");
            }
            tiedPlayers.stream().forEach(p -> dealCardToPlayer(deck,p));

            // return the winner
            return pickWinner(deck, tiedPlayers);
        }

    }

}
