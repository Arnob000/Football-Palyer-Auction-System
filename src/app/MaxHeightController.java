package app;

import java.util.List;
import java.util.Scanner;

import Play.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MaxHeightController {
	private Main main;
		
    @FXML
    private TextArea playerInfo;

    @FXML
    private Label clubName;

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }
    
    public void load(Main ui) {
    	this.main=ui;
    	clubName.setText(main.clubName);
    	List<Player> plist=main.club.maxHeightPlayer();
    	String text="Players Information:";
    	for(Player sr:plist) {
    		text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
    	}
    	if(text.equals("Players Information:"))
    		playerInfo.setText("\nNo such club with this name");
    	else
    		playerInfo.setText(text);
    }

}
