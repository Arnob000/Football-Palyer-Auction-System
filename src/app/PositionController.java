package app;

import java.util.List;
import java.util.Scanner;

import Play.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PositionController {
	private Main main;
	@FXML
    private Label clubName;
		
    @FXML
    private TextArea playerInfo;

    
    
    @FXML
    void Defender(ActionEvent event) {
    	List<Player> plist=main.club.searchPosition("Defender");
        String text="Players Information:";
    	for(Player sr:plist) {
    		 text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
       	}
    	if(text.equals("Players Information:"))
    		playerInfo.setText("\nNo such player with this position");
    	else
    		playerInfo.setText(text);
    }
    

    

    @FXML
    void Forward(ActionEvent event) {
    	List<Player> plist=main.club.searchPosition("Forward");
        String text="Players Information:";
    	for(Player sr:plist) {
    		 text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
       	}
    	if(text.equals("Players Information:"))
    		playerInfo.setText("\nNo such player with this position");
    	else
    		playerInfo.setText(text);
    }

    @FXML
    void Goalkeeper(ActionEvent event) {
    	List<Player> plist=main.club.searchPosition("Goalkeeper");
        String text="Players Information:";
    	for(Player sr:plist) {
    		 text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
       	}
    	if(text.equals("Players Information:"))
    		playerInfo.setText("\nNo such player with this position");
    	else
    		playerInfo.setText(text);
    }

    @FXML
    void Midfielder(ActionEvent event) {
    	List<Player> plist=main.club.searchPosition("Midfielder");
        String text="Players Information:";
    	for(Player sr:plist) {
    		 text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
       	}
    	if(text.equals("Players Information:"))
    		playerInfo.setText("\nNo such player with this position");
    	else
    		playerInfo.setText(text);
    }
    
    @FXML
    void ResetAction(ActionEvent event) {
    	playerInfo.setText(null);
    }

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }
    
    public void load(Main main) {
    	this.main=main;
    	clubName.setText(main.clubName);
    }

}
