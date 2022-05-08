package bankman;

public class user {
 private int id;
 private String password;
 private double balance;
 
  user(int id,String password){
	  this.id = id;
	  this.password =password;
	  balance =1000;
  }
  
  public int getid() {
	  return this.id;
  }
  public double getbalance() {
	  return balance;
  }
  public void setbalance(double balance) {
	  this.balance=balance;
  }
  public boolean verifypassword(String password) {
	  return  this.password.equals(password);
  }
  public void addbalance(double amount) {
	  this.balance = this.balance+amount;
  }
  public void withdrawmoney(double amount) {
	  this.balance = this.balance - amount;
  }
}
