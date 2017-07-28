/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junk.application;

import com.junk.application.fxutils.FXMLContent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author DEA-Elmer
 */
public class MyContent extends FXMLContent {
    
    public static MyContent getInstance(Class c, String fxml){
        MyContent testA = null;
        try {
            testA =  new MyContent(c, fxml);
        } catch (IOException ex) {
            Logger.getLogger(MyContent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testA;
    }
    
    @FXML
    private TextField txt;

    @FXML
    private Button btn;
    public MyContent(Class c, String fxml) throws IOException {
        super(c, fxml);
        setController(this);
        
    }

    @Override
    public void onLoad() {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("test");
            }
        });
    }

    

    
    
    
}
