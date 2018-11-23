package com.deckgame;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class Hand{
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


    public int getValue(){
        TreeMap<Rank, Integer> countMap = new TreeMap<>();
        ArrayList<Rank> rankArrayList = new ArrayList<>();
        if(cards.size() == 1){
            return cards.get(0).getRank().getCardinality();
        }
        else{
            for(Card card : cards){
                int count=0;
                if(countMap.size() > 0 && countMap.get(card.getRank()) != null) {
                    count = countMap.get(card.getRank());
                }
                countMap.put(card.getRank(),count+1);
                rankArrayList.add(card.getRank());
            }
            if (areThreeCardsOfTheSameNumber(countMap)) {
                return 99;
            }
            else if(areThreeNumbersConsecutive(rankArrayList)){
                return 98;
            }
            else if(areTwoCardsOfTheSameNumber(countMap)){
                return 97;
            }
            else{
                return getHighestRankedCard(countMap);
            }
        }

    }

    public boolean areThreeCardsOfTheSameNumber(TreeMap<Rank,Integer> map){
        for(Map.Entry entry : map.entrySet()){
            return entry.getValue().equals(3);
        }
        return false;
    }

    public boolean areThreeNumbersConsecutive(ArrayList<Rank> list){
        Collections.sort(list);
        int firstCardValue = list.get(0).getCardinality();
        int secondCardValue = list.get(1).getCardinality();
        int thirdCardValue = list.get(2).getCardinality();
        if(firstCardValue + secondCardValue + thirdCardValue == 19){
            return true;
        }
        return (abs(secondCardValue - firstCardValue )== 1) && (abs(thirdCardValue - secondCardValue) == 1);
    }

    public boolean areTwoCardsOfTheSameNumber(TreeMap<Rank,Integer> map){
        boolean result = false;
        for(Map.Entry entry : map.entrySet()){
            if(entry.getValue().equals(2)){
                result = true;
            }
        }
        return result;
    }

    public int getHighestRankedCard(TreeMap<Rank,Integer> map) {
        Rank highest = Rank.TWO;
        for (Rank rank : map.keySet()) {
            if (rank.getCardinality() > highest.getCardinality()) {
                highest = rank;
            }
        }
        return highest.getCardinality();
    }

    public void clearHand(){
        this.cards.clear();
    }

    @Override
    public String toString() {
        return "com.deckgame.Hand{" +
                "cards=" + cards +
                '}';
    }
}
