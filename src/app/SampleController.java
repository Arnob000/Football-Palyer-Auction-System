package app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;


public class SampleController {

    @FXML
    private MenuButton menuButton;

    @FXML
    private Label clubName;
    
    @FXML
    private ImageView image;

	private Main main;

    
    @FXML
    void Buy(ActionEvent event) {
    	main.showBuy();
    }

    @FXML
    void Exit(MouseEvent event) {
    	try {
    		main.net.write(main.club.getPlayerList());
			main.net.closeConnection();
			System.exit(0);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    void Sell(ActionEvent event) {
    	main.showSell();
    }


    @FXML									//player searching option
    void byPlayerName(ActionEvent event) {
    	main.showPlayerUIController();  	   
        
    }

    @FXML
    void byCountry(ActionEvent event) {
    	main.ShowCountryUIController();          
    }
    
    @FXML
    void byPosition(ActionEvent event) {
    	main.showPositionController();
    }

    @FXML
    void bySalaryRange(ActionEvent event) {
    	 main.showSalaryController();        
    }

    @FXML
    void countryWisePlayer(ActionEvent event) {
    	main.showCountryWisePlayerController();
    }
    
    @FXML
    void byHeightRange(ActionEvent event) {
    	main.showHeightController();      
    }
    @FXML								//club searching option
    void byMaxSalary(ActionEvent event) {
    	main.showMaxSalary();       
    }
    
    @FXML
    void byMaxAge(ActionEvent event) {
    	main.showMaxAge();        
    }

    @FXML
    void byMaxHeight(ActionEvent event) {
    	main.showMaxHeight();
    }
    
    @FXML
    void totalYearlySalary(ActionEvent event) {
    	double d=main.club.getTotalYearSalary();
    	String s=""+d;
    	Alert a=new Alert(Alert.AlertType.INFORMATION);
    	
    	a.setTitle(main.clubName);
    	a.setHeaderText(null);
    	a.setContentText("Total Yearly Salary: "+s);
    	a.setGraphic(null);
    	a.initStyle(StageStyle.DECORATED.UNDECORATED);
    	a.setHeight(0.2);
    	a.showAndWait();
    	
    }
    
    public void load(String s, Main main) {
    	clubName.setText(main.clubName);
    	this.main=main;
    	String picture=main.clubName+".PNG";
    	Image im= new Image(Main.class.getResourceAsStream(picture));
    	image.setImage(im);
    }

}
