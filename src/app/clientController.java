package app;

import java.io.IOException;
import java.util.List;

import Play.Login;
import Play.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class clientController {

    @FXML
    private PasswordField passdwordField;

    @FXML
    private TextField clubField;

    @FXML
    private Label errorMsg;

	private Main main;

    @FXML
    void loginButton(ActionEvent event) {
    	Login login=new Login();
    	login.setClubName(clubField.getText());
    	
    	login.setPassword(passdwordField.getText());
    	 try{main.net.write(login);
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
        	try{Object o =main.net.read();
        		if(o instanceof Login) {
        			main.login=(Login)o;
        		}
        	if(main.login.getStatus()) {
        		 o =main.net.read();
           	if(o instanceof List<?>) {
         		main.playerList=(List<Player>)o;
         		for(Player p: main.playerList)             //creating club+ adding player 
                    main.club.addPlayer(p);
         	}
        	}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	if(main.login.getStatus()) {
        		main.clubName=main.playerList.get(0).getClub();
        		main.showSample(main.clubName);
        		}
        	else
        		errorMsg.setText("Login Unsuccessful");
    	 
    }

    @FXML
    void resetButton(ActionEvent event) {
    	clubField.setText(null);
    	passdwordField.setText(null);
    	errorMsg.setText(null);
    }
    
    @FXML
    void Exit(MouseEvent event) {
    	System.exit(0);
    }
    
    public void load(Main main) {
    	this.main=main;
    }

}
