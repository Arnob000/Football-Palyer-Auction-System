package app;

import java.util.ArrayList;
import java.util.List;

import Play.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CountryUIController {
	private Main main;
	@FXML
    private Label clubName;
	
    @FXML
    private TextField textCountry;

    @FXML
    private TextArea textArea;

    @FXML
    void PressAction(ActionEvent event) {
    	if(textCountry.getText()== null || textCountry.getText().equals("")) {
    		textArea.setText("Enter Country Name");
       	}
    	
    	else {
    	List<Player> a=main.club.searchCountry(textCountry.getText());
        
        	String text="Players Information:";
        	for(Player sr:a) {
        		 text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
           	}
        	if(text.equals("Players Information:"))
        		textArea.setText("\nNo such player with this country and club");
        	else
        		textArea.setText(text);
    	}
    }

    @FXML
    void ResetAction(ActionEvent event) {
    	textCountry.setText(null);
    	textArea.setText(null);
    }

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }
    
    public void load(Main ui) {
    	this.main=ui;
    	clubName.setText(main.clubName);
    }

}
