package Server;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Play.Player;
import Util.NetworkUtil;

public class Server {
private ServerSocket serverSocket;
private List<Player> playerList;
public List<Player> sellPlayer;



 Server() throws Exception{
	 playerList = readPlayerInfo();
	 try {
	 serverSocket = new ServerSocket(33333);
	 sellPlayer= new ArrayList();
	 while(true) {
		 Socket clientSocket= serverSocket.accept();
		 serve(clientSocket);
	 }
	 }catch(Exception e) {
		 System.out.println("Server Exception:"+e);
	 }
 }
 
 public void serve(Socket clientSocket) throws IOException {
	 NetworkUtil net=new NetworkUtil(clientSocket);
	 new ServerThread(playerList, net, sellPlayer);
	 
 }
 
 public static List<Player> readPlayerInfo() throws Exception{     //reading from file
     List<Player> plrList = new ArrayList();
     FileReader fplr = new FileReader("D:\\EJAVA\\1905108 Final Project(3)\\src\\Server\\players.txt");
     Scanner scn=new Scanner(fplr);
     while(true){
         if(!scn.hasNextLine())
             break;
         String line = scn.nextLine();

         String[] tokens= line.split(",");
         Player p = new Player();
         p.setName(tokens[0]);
         p.setCountry(tokens[1]);
         p.setAge(Integer.parseInt(tokens[2]));
         p.setHeight(Double.parseDouble(tokens[3]));
         p.setClub(tokens[4]);
         p.setPosition(tokens[5]);
         p.setNumber(Integer.parseInt(tokens[6]));
         p.setWeeklySalary(Double.parseDouble(tokens[7]));
   
         plrList.add(p);
     }
     fplr.close();

     return plrList;
 }
 
    public static void main(String[] args) throws Exception {
    	Server s= new Server();
    }
 
}
