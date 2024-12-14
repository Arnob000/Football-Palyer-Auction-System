package app;

import java.util.List;

import Play.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SalaryController {
	private Main main;
	@FXML
    private Label clubName;
	
    @FXML
    private TextField textField1;

    @FXML
    private TextArea playerInfo;

    @FXML
    private TextField textField2;

    @FXML
    void PressAction(ActionEvent event) {
        if(textField1.getText()==null || textField2.getText()==null || textField1.getText().equals("") || textField2.getText().equals("")){
            playerInfo.setText("Enter Salary Value");
        } 
        else {
        	double sal1, sal2;
        	sal1=Double.parseDouble(textField1.getText());
        	sal2=Double.parseDouble(textField2.getText());
        	List<Player> plist=main.club.searchSalary(sal1, sal2);
        	String text="Players Information:";
        	for(Player sr:plist) {
        		text+="\n\nPlayer Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
        	}
        	if(text.equals("Players Information:"))
        		playerInfo.setText("\nNo such player with this weekly salary range");
        	else
        		playerInfo.setText(text);
        }
    }

    @FXML
    void ResetAction(ActionEvent event) {
    	playerInfo.setText(null);
    	textField1.setText(null);
    	textField2.setText(null);
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
