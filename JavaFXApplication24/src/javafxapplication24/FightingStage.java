/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication24;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 *
 * @author wedun
 */
public class FightingStage extends Pane{
    private Image image;
    private BackgroundImage backgroundImage;
    private Background background;
    
    public FightingStage(GameInterface gameInterface){
        this.setPrefSize(1200, 920);
        try{
            image = new Image(new FileInputStream("Assets/background.png"));
            backgroundImage = new BackgroundImage(image,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            background = new Background(backgroundImage);
            this.setBackground(background);
        }
        catch(java.io.FileNotFoundException ex){
            
        }
        gameInterface.setCenter(this);
    }
}
