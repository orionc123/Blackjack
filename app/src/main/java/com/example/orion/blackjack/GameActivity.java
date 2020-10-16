package com.example.orion.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements Runnable{
    private SurfaceHolder sHolder;
    private Thread thread;
    private boolean lock = true;
    Button ten;
    Button fifty;
    Button hundred;
    Game game;
    Bitmap[] cards;
    Bitmap cardBack;
    boolean gameOver = false;
    boolean waiting = false;

    Bitmap twoclubs;
    Bitmap threeclubs;
    Bitmap fourclubs;
    Bitmap fiveclubs;
    Bitmap sixclubs;
    Bitmap sevenclubs;
    Bitmap eightclubs;
    Bitmap nineclubs;
    Bitmap tenclubs;
    Bitmap jclubs;
    Bitmap qclubs;
    Bitmap kclubs;
    Bitmap aclubs;
    Bitmap twodiamonds;
    Bitmap threediamonds;
    Bitmap fourdiamonds;
    Bitmap fivediamonds;
    Bitmap sixdiamonds;
    Bitmap sevendiamonds;
    Bitmap eightdiamonds;
    Bitmap ninediamonds;
    Bitmap tendiamonds;
    Bitmap jdiamonds;
    Bitmap qdiamonds;
    Bitmap kdiamonds;
    Bitmap adiamonds;
    Bitmap twohearts;
    Bitmap threehearts;
    Bitmap fourhearts;
    Bitmap fivehearts;
    Bitmap sixhearts;
    Bitmap sevenhearts;
    Bitmap eighthearts;
    Bitmap ninehearts;
    Bitmap tenhearts;
    Bitmap jhearts;
    Bitmap qhearts;
    Bitmap khearts;
    Bitmap ahearts;
    Bitmap twospades;
    Bitmap threespades;
    Bitmap fourspades;
    Bitmap fivespades;
    Bitmap sixspades;
    Bitmap sevenspades;
    Bitmap eightspades;
    Bitmap ninespades;
    Bitmap tenspades;
    Bitmap jspades;
    Bitmap qspades;
    Bitmap kspades;
    Bitmap aspades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = new Game();
        loadImages();
        SurfaceView sView = findViewById(R.id.surfaceView);
        sHolder = sView.getHolder();
        thread = new Thread(this);
        thread.start();
        ten = findViewById(R.id.ten);
        fifty = findViewById(R.id.fifty);
        hundred = findViewById(R.id.hundred);
    }

    private void loadImages(){
        cardBack = BitmapFactory.decodeResource(getResources(), R.drawable.cardback);
        cardBack = Bitmap.createScaledBitmap(cardBack, 300, 436, false);
        cards = new Bitmap[52];
        twoclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c2);
        twoclubs = Bitmap.createScaledBitmap(twoclubs, 300, 436, false);
        cards[0] = twoclubs;
        threeclubs= BitmapFactory.decodeResource(getResources(),R.drawable.c3);
        threeclubs = Bitmap.createScaledBitmap(threeclubs, 300, 436, false);
        cards[1] = threeclubs;
        fourclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c4);
        fourclubs = Bitmap.createScaledBitmap(fourclubs, 300, 436, false);
        cards[2] = fourclubs;
        fiveclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c5);
        fiveclubs = Bitmap.createScaledBitmap(fiveclubs, 300, 436, false);
        cards[3] = fiveclubs;
        sixclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c6);
        sixclubs = Bitmap.createScaledBitmap(sixclubs, 300, 436, false);
        cards[4] = sixclubs;
        sevenclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c7);
        sevenclubs = Bitmap.createScaledBitmap(sevenclubs, 300, 436, false);
        cards[5] = sevenclubs;
        eightclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c8);
        eightclubs = Bitmap.createScaledBitmap(eightclubs, 300, 436, false);
        cards[6] = eightclubs;
        nineclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c9);
        nineclubs = Bitmap.createScaledBitmap(nineclubs, 300, 436, false);
        cards[7] = nineclubs;
        tenclubs = BitmapFactory.decodeResource(getResources(),R.drawable.c10);
        tenclubs = Bitmap.createScaledBitmap(tenclubs, 300, 436, false);
        cards[8] = tenclubs;
        jclubs = BitmapFactory.decodeResource(getResources(),R.drawable.cj);
        jclubs = Bitmap.createScaledBitmap(jclubs, 300, 436, false);
        cards[9] = jclubs;
        qclubs = BitmapFactory.decodeResource(getResources(),R.drawable.cq);
        qclubs = Bitmap.createScaledBitmap(qclubs, 300, 436, false);
        cards[10] = qclubs;
        kclubs = BitmapFactory.decodeResource(getResources(),R.drawable.ck);
        kclubs = Bitmap.createScaledBitmap(kclubs, 300, 436, false);
        cards[11] = kclubs;
        aclubs = BitmapFactory.decodeResource(getResources(),R.drawable.ca);
        aclubs = Bitmap.createScaledBitmap(aclubs, 300, 436, false);
        cards[12] = aclubs;
        twodiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d2);
        twodiamonds = Bitmap.createScaledBitmap(twodiamonds, 300, 436, false);
        cards[13] = twodiamonds;
        threediamonds= BitmapFactory.decodeResource(getResources(),R.drawable.d3);
        threediamonds = Bitmap.createScaledBitmap(threediamonds, 300, 436, false);
        cards[14] = threediamonds;
        fourdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d4);
        fourdiamonds = Bitmap.createScaledBitmap(fourdiamonds, 300, 436, false);
        cards[15] = fourdiamonds;
        fivediamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d5);
        fivediamonds = Bitmap.createScaledBitmap(fivediamonds, 300, 436, false);
        cards[16] = fivediamonds;
        sixdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d6);
        sixdiamonds = Bitmap.createScaledBitmap(sixdiamonds, 300, 436, false);
        cards[17] = sixdiamonds;
        sevendiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d7);
        sevendiamonds = Bitmap.createScaledBitmap(sevendiamonds, 300, 436, false);
        cards[18] = sevendiamonds;
        eightdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d8);
        eightdiamonds = Bitmap.createScaledBitmap(eightdiamonds, 300, 436, false);
        cards[19] = eightdiamonds;
        ninediamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d9);
        ninediamonds = Bitmap.createScaledBitmap(ninediamonds, 300, 436, false);
        cards[20] = ninediamonds;
        tendiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.d10);
        tendiamonds = Bitmap.createScaledBitmap(tendiamonds, 300, 436, false);
        cards[21] = tendiamonds;
        jdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.dj);
        jdiamonds = Bitmap.createScaledBitmap(jdiamonds, 300, 436, false);
        cards[22] = jdiamonds;
        qdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.dq);
        qdiamonds = Bitmap.createScaledBitmap(qdiamonds, 300, 436, false);
        cards[23] = qdiamonds;
        kdiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.dk);
        kdiamonds = Bitmap.createScaledBitmap(kdiamonds, 300, 436, false);
        cards[24] = kdiamonds;
        adiamonds = BitmapFactory.decodeResource(getResources(),R.drawable.da);
        adiamonds = Bitmap.createScaledBitmap(adiamonds, 300, 436, false);
        cards[25] = adiamonds;
        twohearts = BitmapFactory.decodeResource(getResources(),R.drawable.h2);
        twohearts = Bitmap.createScaledBitmap(twohearts, 300, 436, false);
        cards[26] = twohearts;
        threehearts= BitmapFactory.decodeResource(getResources(),R.drawable.h3);
        threehearts = Bitmap.createScaledBitmap(threehearts, 300, 436, false);
        cards[27] = threehearts;
        fourhearts = BitmapFactory.decodeResource(getResources(),R.drawable.h4);
        fourhearts = Bitmap.createScaledBitmap(fourhearts, 300, 436, false);
        cards[28] = fourhearts;
        fivehearts = BitmapFactory.decodeResource(getResources(),R.drawable.h5);
        fivehearts = Bitmap.createScaledBitmap(fivehearts, 300, 436, false);
        cards[29] = fivehearts;
        sixhearts = BitmapFactory.decodeResource(getResources(),R.drawable.h6);
        sixhearts = Bitmap.createScaledBitmap(sixhearts, 300, 436, false);
        cards[30] = sixhearts;
        sevenhearts = BitmapFactory.decodeResource(getResources(),R.drawable.h7);
        sevenhearts = Bitmap.createScaledBitmap(sevenhearts, 300, 436, false);
        cards[31] = sevenhearts;
        eighthearts = BitmapFactory.decodeResource(getResources(),R.drawable.h8);
        eighthearts = Bitmap.createScaledBitmap(eighthearts, 300, 436, false);
        cards[32] = eighthearts;
        ninehearts = BitmapFactory.decodeResource(getResources(),R.drawable.h9);
        ninehearts = Bitmap.createScaledBitmap(ninehearts, 300, 436, false);
        cards[33] = ninehearts;
        tenhearts = BitmapFactory.decodeResource(getResources(),R.drawable.h10);
        tenhearts = Bitmap.createScaledBitmap(tenhearts, 300, 436, false);
        cards[34] = tenhearts;
        jhearts = BitmapFactory.decodeResource(getResources(),R.drawable.hj);
        jhearts = Bitmap.createScaledBitmap(jhearts, 300, 436, false);
        cards[35] = jhearts;
        qhearts = BitmapFactory.decodeResource(getResources(),R.drawable.hq);
        qhearts = Bitmap.createScaledBitmap(qhearts, 300, 436, false);
        cards[36] = qhearts;
        khearts = BitmapFactory.decodeResource(getResources(),R.drawable.hk);
        khearts = Bitmap.createScaledBitmap(khearts, 300, 436, false);
        cards[37] = khearts;
        ahearts = BitmapFactory.decodeResource(getResources(),R.drawable.ha);
        ahearts = Bitmap.createScaledBitmap(ahearts, 300, 436, false);
        cards[38] = ahearts;
        twospades = BitmapFactory.decodeResource(getResources(),R.drawable.s2);
        twospades = Bitmap.createScaledBitmap(twospades, 300, 436, false);
        cards[39] = twospades;
        threespades = BitmapFactory.decodeResource(getResources(),R.drawable.s3);
        threespades = Bitmap.createScaledBitmap(threespades, 300, 436, false);
        cards[40] = threespades;
        fourspades = BitmapFactory.decodeResource(getResources(),R.drawable.s4);
        fourspades = Bitmap.createScaledBitmap(fourspades, 300, 436, false);
        cards[41] = fourspades;
        fivespades = BitmapFactory.decodeResource(getResources(),R.drawable.s5);
        fivespades = Bitmap.createScaledBitmap(fivespades, 300, 436, false);
        cards[42] = fivespades;
        sixspades = BitmapFactory.decodeResource(getResources(),R.drawable.s6);
        sixspades = Bitmap.createScaledBitmap(sixspades, 300, 436, false);
        cards[43] = sixspades;
        sevenspades = BitmapFactory.decodeResource(getResources(),R.drawable.s7);
        sevenspades = Bitmap.createScaledBitmap(sevenspades, 300, 436, false);
        cards[44] = sevenspades;
        eightspades = BitmapFactory.decodeResource(getResources(),R.drawable.s8);
        eightspades = Bitmap.createScaledBitmap(eightspades, 300, 436, false);
        cards[45] = eightspades;
        ninespades = BitmapFactory.decodeResource(getResources(),R.drawable.s9);
        ninespades = Bitmap.createScaledBitmap(ninespades, 300, 436, false);
        cards[46] = ninespades;
        tenspades = BitmapFactory.decodeResource(getResources(),R.drawable.s10);
        tenspades = Bitmap.createScaledBitmap(tenspades, 300, 436, false);
        cards[47] = tenspades;
        jspades = BitmapFactory.decodeResource(getResources(),R.drawable.sj);
        jspades = Bitmap.createScaledBitmap(jspades, 300, 436, false);
        cards[48] = jspades;
        qspades = BitmapFactory.decodeResource(getResources(),R.drawable.sq);
        qspades = Bitmap.createScaledBitmap(qspades, 300, 436, false);
        cards[49] = qspades;
        kspades = BitmapFactory.decodeResource(getResources(),R.drawable.sk);
        kspades = Bitmap.createScaledBitmap(kspades, 300, 436, false);
        cards[50] = kspades;
        aspades = BitmapFactory.decodeResource(getResources(),R.drawable.sa);
        aspades = Bitmap.createScaledBitmap(aspades, 300, 436, false);
        cards[51] = aspades;
    }

    public void hitClick(View view){
        game.hit(0);
        if(game.score(0) > 21)
            dealerTurn();
        waiting = false;
    }

    public void stayClick(View view){
        waiting = false;
        dealerTurn();
    }

    private void dealerTurn(){
        game.isHoleFlipped = false;
        while(game.score(1) < 17){
            game.hit(1);
        }
        waiting = false;
        if(game.scoreAll() == 1){
            game.currentBet = 0;
        } else if(game.scoreAll() == 0){
            game.chips += game.currentBet * 2;
        } else if(game.scoreAll() == -1){
            game.chips += game.currentBet;
        }
    }

    public void reset(){
        game.newGame(1);
        waiting = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_nexthand){
            game.newGame(0);
            waiting = false;
        }
        if (id == R.id.action_newgame) {
            reset();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gamemenu, menu);
        return true;
    }

    @Override
    public void run() {
        //lock to handle issues with pausing & managing the thread
        while(lock){
            if(!sHolder.getSurface().isValid())
                continue;
            if(gameOver)
                reset();
            if(waiting)
                continue;
            Canvas canvas = sHolder.lockCanvas();
            draw(canvas);
            sHolder.unlockCanvasAndPost(canvas);
            waiting = true;
        }
    }

    public void bet10(View view){
        if(game.chips >= 10) {
            game.chips -= 10;
            game.currentBet += 10;
        }
    }

    public void bet50(View view){
        if(game.chips >= 50) {
            game.chips -= 50;
            game.currentBet += 50;
        }
    }

    public void bet100(View view){
        if(game.chips >= 100) {
            game.chips -= 100;
            game.currentBet += 100;
        }

    }

    private void draw(Canvas c){
        //in this method, dealer == 0 and player == 1
        c.drawColor(Color.rgb(0,135,0));
        for(int i = 0; i < 2; i++){
            ArrayList<Card> hand;
            if(i == 0)
                hand = game.getDealerHand();
            else {
                hand = game.getPlayerHand();
            }
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(75);
            int score;
            if(i == 0)
                score = game.score(1);
            else {
                score = game.score(0);
            }
            if(score > 21) {
                c.drawText("BUST", c.getWidth()/2 - 130, 400 + i * 400, paint);
            }
            if(i == 1)
                c.drawText("You: " + score, c.getWidth() / 2 - 130 , 160 + i * 700, paint);
             else if(i == 0){
                c.drawText("Dealer: " + score, c.getWidth() / 2 - 170 , 170 + i * 700, paint);
            }
            c.drawText("Count: " + game.count, c.getWidth() / 2 - 135, c.getHeight() - 80, paint);
            for(int j = 0 ; j < hand.size(); j++) {
                Card card = hand.get(j);
                if( i == 0 && j == 0 && game.isHoleFlipped){
                    c.drawBitmap(cardBack,300 + j * 150, 250 + i * 700, null);
                } else {
                    c.drawBitmap(cards[card.getIndex()], 300 + j * 150, 250 + i * 700, null);
                }
            }
            if(i == 0){
                c.drawText("Place your bet:", c.getWidth() / 2 - 245, c.getHeight() - 475, paint);
                paint.setTextSize(40);
                c.drawText("Chips: " + game.chips, c.getWidth() / 8 - 125 , 170, paint);
                c.drawText("Current Bet: " + game.currentBet, c.getWidth() * 7 / 8 - 170 , 170, paint);
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    private void pause() {
        //kill run()
        lock = false;
        //Wait for thread to be killed, then exit & release thread
        //I was unable to get thread handlers to work correctly, so I had to do the handling myself
        while(true){
            try {
                thread.join();
            } catch (InterruptedException e) {
                break;
            }
        }
        game = null;
        thread = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume();
    }

    private void resume() {
        //Restart thread, reset lock
        lock = true;
        thread = new Thread(this);
        game = new Game();
        thread.start();
        waiting = false;
    }
}