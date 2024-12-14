package Play;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Country {
    private List<Player> player;
    private String countryName;


    Country(){
        player= new ArrayList();
        countryName=null;
    }
    
    public void addCountryPlayer(Player p){
        player.add(p);
    }
    public void setCountryName(String name) {
    	countryName=name;
    }
    public String getCountryName(){
        return this.countryName;
    }
    public int getPCount(){
        return player.size();        
    }

	public int removeCPlayer(String n) {
		Iterator<Player> itr= player.iterator();
    	while(itr.hasNext()) {
    		Player p=itr.next();
    		if(p.getName().equalsIgnoreCase(n)) {
    			itr.remove();
    		}
    	}
    	return getPCount();
	} 
    
   
}
