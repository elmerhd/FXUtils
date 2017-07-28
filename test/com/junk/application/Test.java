package com.junk.application;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DEA-Elmer
 */
public class Test extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, UnsupportedEncodingException {
        
        MyContent testA = MyContent.getInstance(MyContent.class, "/com/junk/application/customContent.fxml");
        testA.setStyleSheet("/com/junk/application/customStyle.css");
        Scene scene = new Scene(testA.getContent(), 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
