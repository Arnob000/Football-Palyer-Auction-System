package app;

import java.util.Iterator;
import java.util.List;

import Play.Player;
import javafx.application.Application;
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
import javafx.stage.Stage;

public class BuyController {

	private Main main;
	private List<Player> list;
	
	@FXML
    private Label clubName;

    @FXML
    private ListView<?> buyList;

    @FXML
    private TextField buyPlayerName;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private ImageView image;


	public void load(Main main) {
		this.main=main;
		clubName.setText(main.clubName);
		ObservableList names = FXCollections.observableArrayList();
		
		try {
			main.net.write("buy");
        	Object o=main.net.read();
        	if(o instanceof List<?>) {
        		list= (List<Player>)o;
        		for(Player p:list){
        			names.add(p.getName());
        		}
        	}	       	
        }catch(Exception e) {
			e.printStackTrace();
       	}
		
		buyList.setItems(names);
		buyList.getSelectionModel().selectedItemProperty().addListener(
			(observableValue, oldValue, newValue) -> {
                buyPlayerName.setText((String) newValue);
               	String text="";
               	for(Player sr:list) {
               		if(sr.getName().equalsIgnoreCase(buyPlayerName.getText())) {
               			text="Player Name: "+sr.getName()+"\n\nCountry: "+sr.getCountry()+"\nAge: "+sr.getAge()+"\nHeight: "+sr.getHeight()+"\nClub: "+sr.getClub()+"\nPosition: "+sr.getPosition()+"\nNumber: "+sr.getNumber()+"\nWeekly Salary: "+sr.getWeeklySalary()+"\n";
               			textArea.setText(text);
               			String picture=sr.getName()+".PNG";
                       	Image im=new Image(Main.class.getResourceAsStream(picture));
                       	image.setImage(im);
               		}
               	}
               	if(text.equalsIgnoreCase("")) {
               		textArea.setText("No such player with this name");
               		image.setImage(null);
               	}
            }
		);
	}
	
    @FXML
	void Buy(ActionEvent event) {
    	String n=buyPlayerName.getText();
    	buyPlayerName.setText(null);
    	textArea.setText(null);
    	image.setImage(null);
    	
    	 for(Player p:list){
         	/*if(p.getName().equalsIgnoreCase(n) && p.getClub().equalsIgnoreCase(club.getClubName()))
         	{	net.write("added");
         		net.write(p.getName());
         	}*///contradictory onser jonno
         	if(p.getName().equalsIgnoreCase(n)) {
 				p.setClub(main.clubName);
 				main.club.addPlayer(p);
 				try{
 					main.net.write("added");
 					main.net.write(p.getName());
 				}catch(Exception e) {
 					e.printStackTrace();
 				}
 				
 				buyList.getSelectionModel().clearSelection(buyList.getSelectionModel().getSelectedIndex());
 				//observe theke remove korte hobe
          	}
 		}
    	 Iterator<Player> itr= list.iterator();
	    	while(itr.hasNext()) {
	    		Player re=itr.next();
	    		if(re.getName().equalsIgnoreCase(n)) {
	    			itr.remove();
	    		}
	    	}
			buyList.refresh();
	}

    @FXML
    void ResetAction(ActionEvent event) {
    	buyPlayerName.setText(null);
    	textArea.setText(null);
    	image.setImage(null);
	}
    

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }

	
}


