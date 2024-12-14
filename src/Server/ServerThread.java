package Server;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Play.Login;
import Play.Player;
import Util.NetworkUtil;

public class ServerThread implements Runnable {
	private List<Player> playerList;
	private List<Player> sellPlayer;
	private NetworkUtil network;
	private Thread th;
	private List<Player> finalList;

	ServerThread(List<Player> playerList, NetworkUtil net, List<Player> sellplayer){
		this.playerList=playerList;
		this.network=net;
		this.sellPlayer=sellplayer;
		
		th=new Thread(this);
		th.start();
	}
	
	public void run() {
		try {
			while(true) {
				Object o=network.read();
				if(o instanceof Login) {
					Login login=(Login) o;
					for(Player p: playerList) {
						if(p.getClub().equalsIgnoreCase(login.getClubName()) && p.getClub().equalsIgnoreCase(login.getPassword())) {
							login.setStatus(true);
							break;
							}							
					}
					network.write(login);
					if(login.getStatus()) {
						List<Player> sendList=new ArrayList();
						for(Player p: playerList) {
							if(p.getClub().equalsIgnoreCase(login.getClubName()))
								sendList.add(p);
						}
						network.write(sendList);
					}
					
				}
				
				if(o instanceof Player) {
					Player p=(Player)o;
					sellPlayer.add(p);
				}
				if(o instanceof String) {
					String s=(String)o;
					if(s.equalsIgnoreCase("buy"))
						network.write(sellPlayer);
					if(s.equalsIgnoreCase("added"))
					{
						o=network.read();
						if(o instanceof String) {
							String plname=(String)o;
						Iterator<Player> itr= sellPlayer.iterator();
						while(itr.hasNext()) {
     			    		Player p=itr.next();
     			    		if(p.getName().equalsIgnoreCase(plname)) {
     			    			itr.remove();     			    			
     			    		}
     			    	}
					}
					}
				}
				
				if(o instanceof List<?>) {
					finalList=(List<Player>)o;
					
     				for(Player p: finalList) {
     					Iterator<Player> itr= playerList.iterator();
     					while(itr.hasNext()) {
     			    		Player q=itr.next();
     			    		if(p.getName().equalsIgnoreCase(q.getName())) {
     			    			itr.remove();
       			    		}
     			    	}
					}
     				for(Player p: finalList) {
     					playerList.add(p);
     				}
					FileWriter writer = new FileWriter("D:\\EJAVA\\1905108 Final Project(3)\\src\\Server\\playersout.txt");
 			        
 			        for(Player p: playerList){
 			            writer.write(p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getNumber()+","+p.getWeeklySalary()+"\n");
 			        }
 			        writer.close();
					
				}
				
			}
			
				
		}catch(Exception e) {
			System.out.println("ServerThread:"+e);
		}finally {
			try {
				
				network.closeConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
