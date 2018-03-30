package bankrecord;
import java.util.*;
import java.sql.*;
class Bank
{
    int account_no;
    String name;
    int amount;
  public void NewAccount()
  {
   Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number:");
   account_no=a.nextInt();
           System.out.println("Enter Account holders Name:");
   name=a.next();
           System.out.println("Enter Amount:");
   amount=a.nextInt();
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ss.executeUpdate("Insert into Bank values('"+account_no+"','"+name+"','"+amount+"')");
 System.out.println("Account created...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  public void Deposit()
  {
           Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number:");
   account_no=a.nextInt();
           System.out.println("Enter Amount you wants to deposit:");
   int m=a.nextInt();
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ss.executeUpdate("update Bank set Amount=Amount+'"+m+"'where Account_no='"+account_no+"'");
 System.out.println("Amount deposited...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  public void Withdraw()
  {
       Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number:");
   account_no=a.nextInt();
           System.out.println("Enter Amount you wants to withdraw:");
   int m=a.nextInt();
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ss.executeUpdate("update Bank set Amount=Amount-'"+m+"'where Account_no='"+account_no+"'");
 System.out.println("Amount Withdawn...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  public void Balance()
  {
      Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number:");
   account_no=a.nextInt();
    
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
  ResultSet rs=ss.executeQuery("select* from bank where Account_no='"+account_no+"'");
 System.out.println("\t\tAccount no \tName  \t\tAmount" );
 while(rs.next())
         {
             System.out.println("\t\t"+rs.getInt("account_no")+"\t\t"+rs.getString("name")+"\t\t"+rs.getInt("amount"));
         }  
 System.out.println("User Found...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  public void ViewAll()
  {
   try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ResultSet rs=ss.executeQuery("select* from bank");
 System.out.println("\t\tAccount no \tName  \t\tAmount" );
 while(rs.next())
         {
             System.out.println("\t\t"+rs.getInt("account_no")+"\t\t"+rs.getString("name")+"\t\t"+rs.getInt("amount"));
         }  
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
   
  }
  public void Close()
  {
      Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number to delete:");
   account_no=a.nextInt();
           
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ss.executeUpdate("delete from Bank where Account_no='"+account_no+"'");
 System.out.println("Account Closed...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  public void Modify()
  {
      Scanner a= new Scanner(System.in);
   System.out.println("Enter Account number:");
   account_no=a.nextInt();
           System.out.println("Enter Account holders Name:");
   name=a.next();
           System.out.println("Enter Amount:");
   amount=a.nextInt();
   
 try{
       Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fire@123");
 Statement ss=cn.createStatement();
 ss.executeUpdate("update Bank set Account_no='"+account_no+"',Name='"+name+"',Amount='"+amount+"'where Account_no='"+account_no+"'");
 System.out.println("Account updated...!!");
         cn.close();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  }
  }
public class BankRecord
{
    public static void main(String[] args) 
    {
         Scanner s=new Scanner(System.in);
    Bank b= new Bank();
         int choice;
       do
       {System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
         System.out.println();
         System.out.println("=====================================================================================");
         System.out.println("----------------------------Users Account Information--------------------------------");
         System.out.println("\t \tPress button from 1 to 8 to perform a function");
         System.out.println(" 1-->> Create New Account");
         System.out.println(" 2-->> Deposit amount ");
         System.out.println(" 3-->> Withdraw");
         System.out.println(" 4-->> Find user");
         System.out.println(" 5-->> View All account");
         System.out.println(" 6-->> Close an account");
         System.out.println(" 7-->> Modify");
         System.out.println(" 8-->> Exit");
         System.out.println();
         choice=s.nextInt();
         System.out.println("Your choice is:"+choice);
         switch(choice)
         {
             case 1:
                 b.NewAccount();
                 break;
                 
             case 2:
                 b.Deposit();
                 break;
      
             case 3:
                 b.Withdraw();
                 break;
                 
             case 4:
                 b.Balance();
                 break;
                 
             case 5:
                 b.ViewAll();
                 break;
                 
             case 6:
                 b.Close();
                 break;
                 
             case 7:
                 b.Modify();
                 break;                           
         }   
       }while(choice!=8);       
       }
}
           
       