package Play;
import java.io.Serializable;

public class Player implements Serializable{
    private String name, country, club, position;
    private int age, number;
    private double height, wSalary, ySalary;

    public Player(){
        this.name=null;
        this.country=null;
        this.club=null;
        this.position=null;
        this.age=0;
        this.number=0;
        this.height=0.00;
        this.wSalary=0.00;
        this.ySalary=0.00;
    }
    
    public void setName(String name){
        this.name=name;
    }

    public void setCountry(String country){
        this.country=country;
    }
    
    public void setAge(int age){
        this.age=age;
    }

    public void setHeight(double height){
        this.height=height;
    }

    public void setClub(String club){
        this.club=club;
    }

    public void setPosition(String position){
        this.position=position;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public void setWeeklySalary(double wSalary){
        this.wSalary=wSalary;
    }

    public String getName(){
        return this.name;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public String getPosition(){
        return this.position;
    }
    public String getClub(){
        return this.club;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public double getWeeklySalary(){
        return this.wSalary;
    }
    
    public double getYearSalary(){
        ySalary=wSalary*365/7;
        return ySalary;
    }

    public String printPlayer(){            //printing player info
        String s="Player Name: "+getName()+"\n\nCountry: "+getCountry()+"\nAge: "+getAge()+"\nHeight: "+getHeight()+"\nClub: "+getClub()+"\nPosition: "+getPosition()+"\nNumber: "+getNumber()+"\nWeekly Salary: "+getWeeklySalary();
        return s;
    }
}
