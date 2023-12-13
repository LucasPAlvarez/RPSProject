package com.rpsproject;

import java.util.Random;

public class GameLogic {
    
    enum Picks{
        NONE,
        SCISSORS,
        ROCK,
        PAPER
    }

    static int playerScoore = 0;
    static int opponenetScoore = 0;

    static Picks oponentPick = Picks.NONE;
    static Picks playerPick = Picks.NONE;

    static boolean playingOnline = false;

    static GameJFrame gameUI = null;

    static Random botLogic = null;

    static OnlinePlay op = null;

    public static void getUI(GameJFrame gameInstance){
        gameUI = gameInstance;
    }

    public static void changeLoggerText(String t){
        gameUI.ChangeLoggerText(t);
    }

    public static void playTurn(Picks pick){
        Thread turn = new Thread(new TurnLogic(pick));
        turn.start();
    };

    public static void incrisePlayerScoore() {
        ++playerScoore;
    }
    public static void incriseOpponentScoore(){
        ++opponenetScoore;
    }

    public static void updateScore() {
        gameUI.updateScoores(playerScoore, opponenetScoore);
    }

    public static void botTurn(){
        if(botLogic == null){
            botLogic = new Random(System.currentTimeMillis());
        }
        
        int result = (int)(Math.abs(botLogic.nextInt())%3)+1;
        //System.out.println("this is the random number: " + getRando);
        oponentPick = Picks.values()[result];
    }

    public static void turnOnline(boolean t, OnlinePlay onlinePlay){
        op = onlinePlay;
        playingOnline = t;
    }

    public static int compare(){
        switch (playerPick) {
            case SCISSORS:
                switch (oponentPick) {
                    case SCISSORS:
                        return 0;
                    case ROCK:
                        return -1;
                    case PAPER:
                        return 1;
                    default:
                        break;
                }
                break;
            case ROCK:
                switch (oponentPick) {
                    case SCISSORS:
                        return 1;
                    case ROCK:
                        return 0;
                    case PAPER:
                        return -1;
                    default:
                        break;
                }
                break;
            case PAPER:
                switch (oponentPick) {
                    case SCISSORS:
                        return -1;
                    case ROCK:
                        return 1;
                    case PAPER:
                        return 0;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        System.err.println("Error al comparar");
        return 0;
    }

    public static void onlineOpponentPick(String input) {
        oponentPick = Picks.values()[Integer.parseInt(input)];

    }

    public static void startTurnOver() {
        playerPick = Picks.NONE;
        oponentPick = Picks.NONE;
        gameUI.buttonsTurnOn();
    }

    public static void sendPlayerPick() {
        op.sendPick(playerPick);
    }

    public static void setPlayerPick(Picks pick) {
        playerPick = pick;
    }

    public static boolean getPlayingOnline() {
        return playingOnline;
    }

}
