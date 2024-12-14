package app;
import Play.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SellController {

    @FXML
    private Label clubName;

    @FXML
    private ListView<?> pList;

    @FXML
    private TextField sellPlayerName;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private ImageView image;

	private Main main;

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }

    @FXML
    void sell(ActionEvent event) {
    	String n=sellPlayerName.getText();
    	Player p=main.club.searchPlayer(n);
        try {
        	main.net.write(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
        main.club.removePlayer(n); //ektu contradictory
        sellPlayerName.setText(null);
        textArea.setText(null);
        image.setImage(null);
    }
    
    public void load(Main main) {
    	this.main=main;
    	clubName.setText(main.clubName);
    	    	
    	ObservableList names = FXCollections.observableArrayList();
    	for(Player p: main.club.getPlayerList()) {
    		names.add(p.getName());
    	}
        
        pList.setItems(names);
        pList.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                   sellPlayerName.setText((String) newValue);
                   Player sr=main.club.searchPlayer(sellPlayerName.getText());
                   if(sr==null){
                       textArea.setText("No such player with this name");
                       image.setImage(null);
                   } 
                   else {
                   	String text="Player Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary()+"\n";
                   	textArea.setText(text);
                   	String picture=sr.getName()+".PNG";
                   	Image im=new Image(Main.class.getResourceAsStream(picture));
                	image.setImage(im);
                   }
                }
        );
    }

}
