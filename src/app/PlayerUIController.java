package app;

import java.util.Scanner;

import Play.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerUIController {
	private Main main;
	@FXML
    private Label clubName;
		
    @FXML
    private TextField playerName;

    @FXML
    private TextArea playerInfo;
    
    @FXML
    private ImageView image;

    @FXML
    private ListView<?> listView;

    @FXML
    void playerButtonAction(ActionEvent event) {
    	
        Player sr=main.club.searchPlayer(playerName.getText());
        if(sr==null){
            playerInfo.setText("No such player with this name");
        } 
        else {
        	String text="Players Information:\n\nPlayer Name: "+sr.getName()+"\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary();
        	playerInfo.setText(text);
        	String picture=sr.getName()+".PNG";
        	Image im=new Image(Main.class.getResourceAsStream(picture));
        	image.setImage(im);
        }
    }
  
    @FXML
    void ResetAction(ActionEvent event) {
    	playerInfo.setText(null);
    	playerName.setText(null);
    	image.setImage(null);
    }

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }
    
    public void load(Main ui) {
    	this.main=ui;
    	clubName.setText(main.clubName);
    	
    	ObservableList names = FXCollections.observableArrayList();
    	for(Player p: main.club.getPlayerList()) {
    		names.add(p.getName());
    	}
        listView.setItems(names);
        
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                   playerName.setText((String) newValue);
                }
        );
    }

}
