package app;


import java.util.ArrayList;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CountryWisePlayerController {
	private Main main;

	
	@FXML
    private Label clubName;
	
	@FXML
    private ListView<?> list1;

    @FXML
    private ListView<?> list2;

    @FXML
    void backAction(ActionEvent event) {
    	main.showSample(main.clubName);
    }
    
    
    public void load(Main ui) {
    	this.main=ui;
    	clubName.setText(main.clubName);
    	ObservableList lista= FXCollections.observableArrayList();
    	ObservableList listb= FXCollections.observableArrayList();
    	List<String> l=new ArrayList();
    	l=main.club.getPlayerCount();
    	
    	for(String s:l) {
    		String[] token=s.split(",");
    		lista.add(token[0]);    		
    	}
    	list1.setItems(lista);
    	for(String s:l) {
    		String[] token=s.split(",");
    		listb.add(token[1]);    		
    	}
    	list2.setItems(listb);
    	
    	
    }
    
    

}
