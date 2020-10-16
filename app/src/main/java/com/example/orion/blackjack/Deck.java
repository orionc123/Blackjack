package com.example.orion.blackjack;

public class Deck {
    private Card[] cards;
    private int numCards;

    public Deck(){
        cards = new Card[52];
        load();
        shuffle();
    }

    private void load(){
        int i = 0;
        for(int rank = 1; rank < 14; rank++){
            for(int suit = 0; suit < 4; suit++){
                cards[i] = new Card(rank,suit);
                i++;
            }
        }
        numCards = 52;
    }

    public void shuffle(){
        for(int i = 0; i < numCards - 1; i++){
            int rand = (int) ((numCards - i)*Math.random() + i);
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
    }

    public Card deal(){
        if(numCards == 0){
            load();
            shuffle();
        }
        numCards--;
        return cards[numCards];
    }
}
