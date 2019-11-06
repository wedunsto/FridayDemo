/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication24;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wedun
 */
public class JavaFXApplication24 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GameInterface root = new GameInterface();
        Scene scene = new Scene(root, 1200, 920);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getPlayerControlledFighter().requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
