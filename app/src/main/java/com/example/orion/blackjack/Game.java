package com.example.orion.blackjack;

import java.util.ArrayList;

public class Game{
    private Deck deck;
    boolean isHoleFlipped;
    int count;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    int chips;
    int currentBet;

    public Game(){
        deck = new Deck();
        chips = 1000;
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        //dealer's initial hole card
        isHoleFlipped = true;
        deal(0);
        deal(1);
    }

    public void deal(int player) {
        //player = 0; dealer = 1;
        if(player == 0){
            for (int i = 0; i < 2; i++) {
                Card c = deck.deal();
                count(c);
                playerHand.add(c);
            }
        } if(player == 1){
            for (int i = 0; i < 2; i++) {
                Card c = deck.deal();
                count(c);
                dealerHand.add(c);
            }
        }

    }

    public void count(Card c){
        if(c.getRank() >=2 && c.getRank() < 7)
            count++;
        else if((c.getRank() >= 10 && c.getRank() < 14) || c.getRank() == 1)
            count--;
    }

    public void newGame(int type){
        if(type == 0){
            //new hand
            playerHand = new ArrayList<>();
            dealerHand = new ArrayList<>();
            isHoleFlipped = true;
            currentBet = 0;
            deal(0);
            deal(1);
        } else if(type == 1){
            //new game entirely
            playerHand = new ArrayList<>();
            dealerHand = new ArrayList<>();
            isHoleFlipped = true;
            chips = 1000;
            currentBet = 0;
            deal(0);
            deal(1);
        }
    }

    public void hit(int player){
        if(player == 0){
            Card c = deck.deal();
            playerHand.add(c);
            count(c);
        } if(player == 1) {
            Card c = deck.deal();
            dealerHand.add(c);
            count(c);
        }
    }

    public int scoreAll(){
        int winner = -1;
        int playerScore = score(0);
        int dealerScore = score(1);
        if(playerScore > 21) return 1;
        if(dealerScore > 21) return 0;
        if(playerScore > dealerScore){
            winner = 0;
        } else if(dealerScore > playerScore){
            winner = 1;
        }
        //WINNER IS -1 ON A PUSH (MONEY RETURNED)
        return winner;
    }

    public int score(int player){
        if(player == 0){
            int score = 0;
            int numAces = 0;
            for(Card c : playerHand){
                int rank = c.getRank();
                if(rank < 11 && rank != 1){
                    score += rank;
                } else if(rank < 14 && rank > 10){
                    score += 10;
                } else{
                    score +=11;
                    numAces++;
                }
                while(score > 21 && numAces > 0){
                    score -= 10;
                    numAces--;
                }
            }
            return score;
        } else if(player == 1){
            int score = 0;
            int numAces = 0;
            for(Card c : dealerHand){
                int rank = c.getRank();
                if(rank < 11 && rank != 1){
                    score += rank;
                } else if(rank < 14 && rank != 1){
                    score += 10;
                } else{
                    score +=11;
                    numAces++;
                }
                while(score > 21 && numAces > 0){
                    score -= 10;
                    numAces--;
                }
            }
            return score;
        }
        return -1;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }
}
