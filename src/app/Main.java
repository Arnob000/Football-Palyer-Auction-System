package app;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Play.*;
import Util.NetworkUtil;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static Club club =new Club();
    public static List<Player> playerList; 
    public static NetworkUtil net; 
    public static Login login;
    private Stage stage;
    public String clubName;
    private double x=0;
    private double y=0;
    
  

    @Override
	public void start(Stage primaryStage) throws Exception {
		stage=primaryStage;
		stage.initStyle(StageStyle.DECORATED.UNDECORATED); // remove boarder
		login=new Login();
		connectServer();
		showClientController();
		
	}
    
    public void connectServer() throws IOException {
    	net=new NetworkUtil("127.0.0.1", 33333);
    }
    
    public void showClientController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Client.fxml"));
			Parent root = loader.load();
			
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			//loadSampleController;
			clientController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Login Page");
			Scene scene = new Scene(root,600,328);
			 
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
   
    public void showSample(String s) {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Club.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});

			//loadSampleController;
			SampleController controller= loader.getController();
			controller.load(s,this);
			
			stage.setTitle("Club Page");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    
    public void showPlayerUIController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("PlayerUI.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
	
			PlayerUIController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Player INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ShowCountryUIController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("CountryUI.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			CountryUIController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Player INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void showPositionController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Position.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			PositionController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Player INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showSalaryController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("SalaryRange.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
		
			SalaryController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Player INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showHeightController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("HeightRange.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			HeightController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Player INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showCountryWisePlayerController() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("CountryWisePlayer.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			CountryWisePlayerController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Country Wise Player Count");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showMaxSalary() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("MaxSalary.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			MaxSalaryController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Maximum Salary Player's INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMaxAge() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("MaxAge.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			MaxAgeController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Maximum Age Player's INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMaxHeight() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("MaxHeight.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			MaxHeightController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Maximum Height Player's INFO");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showSell() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Sell.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			SellController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Sell Player(s)");
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showBuy() {
		try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Buy.fxml"));
			Parent root = loader.load();
			root.setOnMousePressed(new EventHandler<MouseEvent>(){     //mouse control

				@Override
				public void handle(MouseEvent event) {
					x=event.getSceneX();
					y=event.getSceneY();
					
				}
				
			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					stage.setX(event.getScreenX()-x);
					stage.setY(event.getScreenY()-y);
					
				}
				
			});
			
			BuyController controller= loader.getController();
			controller.load(this);
			
			stage.setTitle("Buy Player(s)");
			Scene scene = new Scene(root,600,372);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
    public static void main(String[] args) throws Exception{
          launch(args);
    }
}
  
   

