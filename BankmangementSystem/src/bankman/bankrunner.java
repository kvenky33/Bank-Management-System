package bankman;
import java.io.*;
import java.util.*;
public class bankrunner {
  public static void main (String args[]) {
	  bank unionbank = new bank();
	  System.out.println("Welcome to Unionbank");
	  int option;
	  
	  do {
		  System.out.println("Choose the options");
		  System.out.println("1. create an account");
		  System.out.println("2. Transfer Money");
		  System.out.println("3. add money");
		  System.out.println("4. check account balance");
		  System.out.println("5. withdraw money");
		  System.out.println("6. Delete account");
		  System.out.println("8.exit");
		  Scanner sc= new Scanner(System.in);
		  option = sc.nextInt();
		  int id,senderid,recieverid;
		  String password;
		  double amount;
		  boolean logic;
		  switch(option) {
		  case 1:
			  System.out.println("Enter  your user id");
			   id =sc.nextInt();
			  System.out.println("Enter your password");
			   password = sc.next();
			  
			  unionbank.adduser(id, password);
			  break;
		  case 2:
			  System.out.println("Enter user id");
			  senderid = sc.nextInt();
			  System.out.println("Enter your password");
			  password = sc.next();
			   logic = unionbank.verifycredentials(senderid, password);
			  if(logic) {
				  System.out.println("Enter reciever id : ");
				  recieverid = sc.nextInt();
				  System.out.println("Enter the amount to be Transferred");
				  amount = sc.nextDouble();
				  unionbank.Transfermoney(senderid, password, recieverid, amount);
			  }else {
				  System.out.println("Bad credentials");
			  }
			  break;
		  case 3 :
			  System.out.println("Enter user id");
			  id = sc.nextInt();
			  System.out.println("Enter your password");
			  password = sc.next();
			   logic = unionbank.verifycredentials(id, password);
			  if(logic) {
				  System.out.println("Enter the amount to be added");
				  amount = sc.nextDouble();
				  unionbank.addmoney(id, amount);
				  
			  }else {
				  System.out.println("Bad credentials");
			  }
			  break;
		  case 4 :
			  System.out.println("Enter user id");
			  id = sc.nextInt();
			  System.out.println("Enter your password");
			  password = sc.next();
			   logic = unionbank.verifycredentials(id, password);
			  if(logic) {
				  unionbank.checkbalance(id);
			  }
			  else {
				  System.out.println("Bad credentials");
			  }
			  break;
			  
		  case 5:
			  System.out.println("Enter user id");
			  id = sc.nextInt();
			  System.out.println("Enter your password");
			  password = sc.next();
			   logic = unionbank.verifycredentials(id, password);
			  if(logic) {
				  System.out.println("Enter the amount to be withdraw from account");
				  amount = sc.nextDouble();
				  unionbank.withdraw(id, amount);
				  
			  }else {
				  System.out.println("Bad credentials");
			  }
			  break;
		  case 6 :
			  System.out.println("Enter user id");
			  id = sc.nextInt();
			  System.out.println("Enter your password");
			  password = sc.next();
			   logic = unionbank.verifycredentials(id, password);
			  if(logic) {
				 unionbank.deleteaccount(id);
			  }else {
				  System.out.println("Bad credentials");
			  }
			  break;
		  case 8 :
			  break;
			  
		default :
			break;
		  }
		  
	  }while(option != 8);
  }
}
