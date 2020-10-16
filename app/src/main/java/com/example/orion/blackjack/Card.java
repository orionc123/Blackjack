package com.example.orion.blackjack;

public class Card {
    private int rank;
    private int suit;



    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getIndex(){
        //This gets the index of the card image stored in the Bitmap[]
        return (rank - 2) + suit * 13;
    }

    public int getRank(){
        return rank;
    }
}
