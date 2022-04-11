package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) 
    {
    	String parola = txtParola.getText().toLowerCase();
    	Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    	
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	
    	
    	for(String s : anagrammi)
    	{
    		if(model.isCorrect(s))
    			txtAnagrammiCorretti.appendText(s+"\n");
    		else
    			txtAnagrammiErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	txtParola.clear();
    }
    
    public void setModel(Model model)
    {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
