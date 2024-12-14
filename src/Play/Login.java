package Play;

import java.io.Serializable;

public class Login implements Serializable {
	private String clubName;
    private String password;
    private boolean status;

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    
    public String getClubName() {
        return clubName;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
    public boolean getStatus() {
        return status;
    }
}
