# Problem Statement
The festival season is here and you realise it's hard to play all those complicated card games when you're drunk. You decide to create a simple luck-based game for people to play when they have limited motor and sensory control.

## Prerequisites
* Java 8

## Basic Rules:
* Use a standard deck of cards (no Joker).
* Each player is dealt three cards.
* 'A' is considered to have a number value of 1.
* 'A' is considered the top card in a face-off. So the order is A > K > Q > J > 10...2

## Victory:
* A trail (three cards of the same number) is the highest possible combination.
* The next highest is a sequence (numbers in order, e.g., 4,5,6. A is considered to have a value of 1).
* The next highest is a pair of cards.
* If all else fails, the top card (by number value wins).
* If the top card has the same value, each of the tied players draws another card till a winner is found.
* For now the suit (spades/hearts etc...), does not matter.

## Installation
* Clone this repository and navigate to project root directory
* Run the application by providing the number of players as an argument to the gradle task 'run'
* Eg: If you want the game simulated between two players, run the following:
```bash
./gradlew run --args "2"


