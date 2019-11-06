/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication24;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author wedun
 */
public class GameInterface extends BorderPane{
    private FightingStage fightingStage;
    private PlayerControlledFighter playerControlledFighter;
    private MovePlayer movePlayer;
    public GameInterface(){
        fightingStage = new FightingStage(this);
        playerControlledFighter = new PlayerControlledFighter(fightingStage);
        movePlayer = new MovePlayer();
        playerControlledFighter.setSpeed(10.0);
        playerControlledFighter.setOnKeyPressed(movePlayer);
    }
    
    private class MovePlayer implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            switch(event.getCode()){
                case LEFT:
                    playerControlledFighter.setDirection(180.0);
                    playerControlledFighter.move();
                    break;
                case RIGHT:
                    playerControlledFighter.setDirection(0.0);
                    playerControlledFighter.move();
                    break;
            }
        } 
    }
    
    public PlayerControlledFighter getPlayerControlledFighter(){
        return playerControlledFighter;
    }
}
