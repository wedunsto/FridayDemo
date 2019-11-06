/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author wedun
 */
public class PlayerControlledFighter extends Assets{
    private Image fighter;
    private Rectangle2D viewRectangle2D;
    
    public PlayerControlledFighter(FightingStage fightingStage){
        super(10.0,0.0,0.0,fightingStage.getPrefWidth(),fightingStage.getPrefHeight());
        try{
            fighter = new Image(new FileInputStream("Assets/Sora.png"));
            this.setImage(fighter);
            fightingStage.getChildren().add(this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayerControlledFighter.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewRectangle2D= new Rectangle2D(79, 159, 25, 51);
        this.setViewport(viewRectangle2D);
        this.setScaleX(3);
        this.setScaleY(3);
        this.setX(getParentWidth()/2-getBoundsInParent().getWidth()-100);
        this.setY(getParentHeight()-getBoundsInParent().getHeight());
    }
    
    @Override
    public void move(){
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));//determines direct and speed when GameObjects move horizontally
        if(newX >0 & newX <getParentWidth()-getFitWidth()){//if the x value of the new position is greater than
            this.setX( newX );//continue to set x position
        }
        else if(newX < 0){//if the x value is less than 
            this.setX(0);//statically set x value to the smallest value allowed
        }
        else if(newX > getParentWidth()){//statically set x value to the largest value allowed
            this.setX(getParentWidth());//statically set x value to the largest value allowed
        }
    }
}
