import java.util.Scanner;
public class Account {
    private double money;
    private int id;
    private String username;
    private String password;
    public Account(){
        this.money = 0.0;
        this.id = 0;
        this.username = "";
        this.password = "";
    }
    public void setUsername(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your desired username?");
        this.username = s.nextLine();
    }
    public void setPassword(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your desired password?");
        this.password = s.nextLine();
    }
    public void setid(){
        this.id = this.username.length() * 1000 + password.length();
    }
    public int getId(){
        return this.id;
    }
    public void inputMoney(double m){
        if(m <= 0){
            System.out.println("#################################");
            System.out.println("#                               #");
            System.out.println("#       The value of input      #");
            System.out.println("#            is to low.         #");
            System.out.println("#                               #");
            System.out.println("#################################");
        }else{
            this.money += m;
        }
    }
    public boolean checkMoney(double money){
        if(this.money >= money){
            return true;
        }else{
            return false;
        }
    }
    public void removeMoney(double money){
        this.money -= money;
    }
    public String getName(){
        return username;
    }
    public double getMoney(){
        return this.money;
    }
}
