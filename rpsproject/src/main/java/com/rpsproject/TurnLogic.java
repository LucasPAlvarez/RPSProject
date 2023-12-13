package com.rpsproject;

import com.rpsproject.GameLogic.Picks;

public class TurnLogic implements Runnable{

    Picks pick;

    public TurnLogic(Picks pick){
        this.pick = pick;
    }

    @Override
    public void run() {
            GameLogic.changeLoggerText("Submited your pick, waiting for opponent.");

            if(pick == Picks.NONE){
                GameLogic.changeLoggerText("you must pick one of the options before submiting.");
            }else{
                GameLogic.setPlayerPick(pick);
                if(!GameLogic.getPlayingOnline()){
                    GameLogic.botTurn();
                }else{
                    GameLogic.sendPlayerPick();
                    while(GameLogic.oponentPick.equals(Picks.NONE)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                int result = GameLogic.compare();
                if(result>0){
                    GameLogic.incrisePlayerScoore();
                    GameLogic.changeLoggerText("You win");
                }else{
                    if(result < 0){
                        GameLogic.incriseOpponentScoore();
                        GameLogic.changeLoggerText("You loose");
                    }else{
                        GameLogic.changeLoggerText("It's a tie");
                    }
                }
                GameLogic.updateScore();
                GameLogic.startTurnOver();
                //gameUI.ChangeLoggerText("Finished");
            }
        }
}
