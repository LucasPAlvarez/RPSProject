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
        if(gameUI != null){
            gameUI.ChangeLoggerText("Submited your pick, waiting for opponent.");

            if(pick == Picks.NONE){
                gameUI.ChangeLoggerText("you must pick one of the options before submiting.");
            }else{
                playerPick = pick;
                if(!playingOnline){
                    botTurn();
                }else{
                    op.sendPick(playerPick);
                    while(oponentPick.equals(Picks.NONE)){}
                }
                int result = compare();
                if(result>0){
                    playerScoore++;
                    gameUI.ChangeLoggerText("You win");
                }else{
                    if(result < 0){
                        opponenetScoore++;
                        gameUI.ChangeLoggerText("You loose");
                    }else{
                        gameUI.ChangeLoggerText("It's a tie");
                    }
                }
                updateScore();
                playerPick = Picks.NONE;
                oponentPick = Picks.NONE;
                gameUI.buttonsTurnOn();
                //gameUI.ChangeLoggerText("Finished");
            }

        }else{
            System.err.println("No existe el UI");
        }
    };

    private static void updateScore() {
        gameUI.updateScoores(playerScoore, opponenetScoore);
    }

    private static void botTurn(){
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




    private static int compare(){
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

}
