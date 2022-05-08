package bankman;
import java.io.*;
import java.util.*;
public class bank {
 private HashMap<Integer,user> users;
 
  bank(){
	  users= new HashMap<Integer,user>();
  }
  public void adduser(int id,String password) {
	  if(users.containsKey(id)) {
		  System.out.println("User id already exists");
	  }
	  else {
		  user newuser = new user(id,password);
		  users.put(id, newuser);
		  System.out.println("Your Account is Succesfully created");
	  }
  }
  public void Transfermoney(int id,String password,int destid,double amount) {
	  user sender = users.get(id);
	  
	  if(verifycredentials(id,password)) {
		  if(sender.getbalance()>=amount) {
			  System.out.println("Transferring Money ....");
			  user reciever =users.get(destid);
			  if(reciever==null) {
				  System.out.println("Reciver not found");
				  return;
			  }
			  sender.setbalance(sender.getbalance()-amount);
			  reciever.setbalance(reciever.getbalance()+amount);
			  System.out.println("Transferred Money Succesfully");
			  System.out.println("Your new balance is"+sender.getbalance());
			  
		  }else {
			  System.out.println("Insufficient balance");
		  }
	  }
  }
  public boolean verifycredentials(int id,String password ) {
	  user User = users.get(id);
	  if(User==null)
		  return false;
	  return User.verifypassword(password);
  }
  public void addmoney(int id,double amount) {
	  user User = users.get(id);
	  User.addbalance(amount);
	  System.out.println("succesfully money added into your account");
	  System.out.println("Your new account balance : "+ User.getbalance());
  }
  public void checkbalance(int id) {
	  user User = users.get(id);
	  System.out.println("Your current account balance : "+ User.getbalance());
  }
  public void withdraw(int id,double amount) {
	  user User = users.get(id);
	  if(User.getbalance()>= amount) {
	  User.withdrawmoney(amount);
	  System.out.println("withdrawn completed succesfully");
	  System.out.println("Your new account balance : "+ User.getbalance());
	  }
	  else {
		 System.out.println("Insufficient balance"); 
	  }
  }
  public void deleteaccount(int id) {
	 
	  if(users.containsKey(id)) {
	  users.remove(id);
	  System.out.println("Your account has been succesfully deleted3");
	  }
  }
}
