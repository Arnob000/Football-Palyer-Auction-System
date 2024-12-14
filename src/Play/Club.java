package Play;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Club {
    private List<Player> playerList;
    private int playerCount;
    private int countryCount;
    private double totalySalary;
    private List<Country> countryList;

    public Club(){
        playerList=new ArrayList();
        countryList=new ArrayList();
        playerCount=0;
        countryCount=0;
        totalySalary=0.00;
    }

    public int addPlayer(Player p){
        if(playerCount >= 7){
            System.out.println("Maximum Numbers of Player Exceeded! Can't Add Anymore!");
            return 1;
        }
        playerList.add(p);
        //addCountryList(p);
        playerCount++;
        return -1;
    } 
    
   
    public String getClubName(){
        return playerList.get(0).getClub();
    }
    
    public Player searchPlayer(String name){
        
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getName().equalsIgnoreCase(name)){
                
                return playerList.get(i);
            }
        }
        return null;
    }
    
    public List<Player> searchCountry(String name){
        List<Player> a=new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getCountry().equalsIgnoreCase(name)){
               a.add(playerList.get(i));
            }
        }
        return a;
    }

    public List<Player> searchPosition(String pos){
    	List<Player> a=new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getPosition().equalsIgnoreCase(pos)){
                a.add(playerList.get(i));
            }
        }
        return a;
    
    }
    
     public List<Player> searchSalary(double s1, double s2){
    	 List<Player> a =new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getWeeklySalary()>=s1 && playerList.get(i).getWeeklySalary()<=s2){
                a.add(playerList.get(i));
            }
        }
        return a;
    
     }
     
     public List<Player> searchHeight(double h1, double h2){
    	 List<Player> a =new ArrayList();
         for(int i=0; i<playerCount; i++){
             if(playerList.get(i).getHeight()>=h1 && playerList.get(i).getHeight()<=h2){
                 a.add(playerList.get(i));
             }
         }
         return a;
     
     }

    public List<Player> maxSalaryPlayer(){
        double find=0.00;
        List<Player> a =new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(find < playerList.get(i).getWeeklySalary())
                find=playerList.get(i).getWeeklySalary();
        }
        
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getWeeklySalary() == find) {
            	a.add(playerList.get(i));
            }
        }
		return a;
    }

     public List<Player> maxAgePlayer(){
        int find=0;
        List<Player> a =new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(find < playerList.get(i).getAge())
                find=playerList.get(i).getAge();
        }
       
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getAge() == find) {
            	a.add(playerList.get(i));
            }
        }
        return a;
    }

     public List<Player> maxHeightPlayer(){
        double find=0.00;
        List<Player> a =new ArrayList();
        for(int i=0; i<playerCount; i++){
            if(find < playerList.get(i).getHeight())
                find=playerList.get(i).getHeight();
        }
     
        for(int i=0; i<playerCount; i++){
            if(playerList.get(i).getHeight() == find) {
            	a.add(playerList.get(i));
            }
        }return a;
    }
    
    public double getTotalYearSalary(){
    	totalySalary=0.0;
        for(int j=0; j < playerCount; j++){
            totalySalary+=playerList.get(j).getYearSalary();
        }
        return totalySalary;
    }  
    
    public void addCountryList(Player p){
        for(Country c: countryList){
           if(c.getCountryName().equalsIgnoreCase(p.getCountry())){
                c.addCountryPlayer(p);
                return;
            }
        }
        Country C=new Country();
        C.addCountryPlayer(p);
        C.setCountryName(p.getCountry());
        countryList.add(C);
        countryCount++;
    }
    
    public List<String> getPlayerCount(){
    	String s="";
    	List<String> l=new ArrayList();
    	countryList=new ArrayList();
    	countryCount=0;
    	
    	for(Player p:getPlayerList()) {
    		addCountryList(p);
    	}
        for(int i=0; i<countryCount; i++){
            Country C=new Country();
            C=countryList.get(i);
            s=C.getCountryName()+","+C.getPCount();
            l.add(s);
        }
        return l;
    }
    
    public List<Player> getPlayerList(){
    	return playerList;
    }
    
    public void removePlayer(String n) {
    	//removeCountryPlayer(n);
    	Iterator<Player> itr= playerList.iterator();
    	while(itr.hasNext()) {
    		Player p=itr.next();
    		if(p.getName().equalsIgnoreCase(n)) {
    			itr.remove();
    			playerCount--;
    		}
    	}
    	
    }
    
    public void removeCountryPlayer(String n) {
    	for(Country c: countryList) {
    		int a=c.removeCPlayer(n);
    		if(a==0)
    			countryCount--;
    	}
    }
}
