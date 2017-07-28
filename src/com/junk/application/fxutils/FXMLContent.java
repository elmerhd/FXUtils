package com.junk.application.fxutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Elmerhd
 */
public abstract class FXMLContent {
    
    private final FXMLLoader loader;
    private Pane pane;
    String currentStyle = "defaultStyle";
    
    public FXMLContent(@SuppressWarnings("unchecked") Class c,@SuppressWarnings("unchecked")String fxml) {
        loader = new FXMLLoader(c.getResource(fxml));
    }
    
    /**
     * sets the controller of the fxml file
     * @param controller the controller class
     * @throws IOException 
     */
    public void setController(Object controller) throws IOException{
        loader.setController(controller);
        pane = (AnchorPane) loader.load();
        onLoad();
    }
    public void setStyleSheet(String styleSheetUrl){
        if(!pane.getStylesheets().isEmpty()){
            pane.getStylesheets().remove(currentStyle);
            pane.getStylesheets().add(styleSheetUrl);
            currentStyle = pane.getStylesheets().get(0);
        }else{
            pane.getStylesheets().add(styleSheetUrl);
            currentStyle = pane.getStylesheets().get(0);
        }
    }
    
    public void setStyleSheet(File file) throws FileNotFoundException, UnsupportedEncodingException{
        if(!file.exists()){
            throw new FileNotFoundException("File not found : "+file.getAbsolutePath());
        }else{
            String encoded = "file:///"+file.getAbsolutePath().replace("\\", "/").replaceAll(" ", "%20");
            setStyleSheet(encoded);
        }
    }
    /**
     * Gets the content pane;
     * @return the content pane.
     */
    public Pane getContent(){
        return pane;
    }
    
    /**
     * Initialization of components
     */
    public abstract void onLoad();
}
