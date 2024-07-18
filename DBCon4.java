
import java.util.*;
import java.sql.*;



public class DBCon4
{


public static void main(String[] args)
 {
	 
	 
	 Scanner s = new Scanner(System.in);
	 try (s;){
	 try
	 {
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Qazmlp01");        
		 
		 //Creating Connection
		 PreparedStatement ps1 = con.prepareStatement("insert into BankCustomer52 values(?)");          
		 //compilation
		 
		 PreparedStatement ps2 = con.prepareStatement("select Name from BankCustomer52");	
		 //Compilation
		 
		 while(true)
		 {
			 System.out.println("****choice****");
			 System.out.println("\t1.AddCustomer"+"\n\t2.ViewAllcustomers");
		     System.out.println("Enter the Choice:");
		     int choice = Integer.parseInt(s.nextLine());
		 
		     
		     switch(choice)
		     {
		    	 case 1:
		     System.out.println("Enter the CustomerName:");
		     String cN= s.nextLine();
		     
		     
		     
		     //Setting data to ps1-object
		     ps1.setString(1, cN);
		     
		  int K = ps1.executeUpdate(); //Execution
		  if(K>0)
		  {
			  System.out.println("Customer Added SuccesFully..");
			  
		  }
		    break;
		     
		 case 2:
			 ResultSet rs = ps2.executeQuery();        //Execution
			 System.out.println("****All Customers Details****");
			 
			 while(rs.next())
		{
		System.out.println(rs.getString(1));
		 }//End of the loop
		     break;
		     
		 case 3:
			 
		   System.out.println("Operation on DB Stoped..");
		 System.exit(0);
		 default:System.out.println("Invalid Choice..");
		 } //End of Switch
	 }//End of Loop
	 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		    		 
 }//end of try with resource	    		 
		    		 
		    		 
}	    		 
		    		 


}


