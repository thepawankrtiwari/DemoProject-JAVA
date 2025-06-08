import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Project {

public static void main(String[] args)  {
		
//		Step 1: Load the driver into the memory 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Step 2: Establish the connection using that loaded driver
		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root", "Pwn7380sql#");
		
		
//		Step 3: Display appropriate message on the console.

		if(c != null) { 
			
//		---------------- CODE FOR I N S E R T I N G --------------------
			
//			-------------- executeUpdate() Function --------------
//			   ------------ gives value in int Set -------------
			
			  Scanner sc= new Scanner(System.in);
			  
			  System.out.println("Enter your id:"); int id=sc.nextInt();
			  
			  System.out.println("Enter Your Name"); String name=sc.next();
			  
			  System.out.println("Enter Your Branch"); String branch=sc.next();
			  
			  
			  String query = "insert into students values(?, ?, ?);";
			  
			  PreparedStatement stmt = c.prepareStatement(query); 
			   
			  stmt.setInt(1, id); stmt.setString(2, name); stmt.setString(3, branch);
			  
			  
			  int info = stmt.executeUpdate();
			  
			  System.out.println(info); 
			  
			  System.out.println("Student Information added!");
			 
			
//			---------------CODE FOR S E L E C T   Q U E R Y--------------------
			
//				  ---------------- executeQuery() Function --------------
//					  ------------gives value in Result Set ---------
			
				/*
				 * String query = "select * from students;";
				 * 
				 * PreparedStatement stmt = c.prepareStatement(query);
				 * 
				 * ResultSet rs = stmt.executeQuery();
				 * 
				 * while(rs.next()) { System.out.println(rs.getInt("id") + " | " +
				 * rs.getString("name")+ " | "+ rs.getString("branch")); }
				 * 
				 * System.out.println("Student Information!");
				 */
			 
//			---------------CODE FOR U P D A T E  Q U E R Y--------------------
			
			/*
			 * String query = "update students set name = 'Orton' where id = 103;";
			 * PreparedStatement stmt = c.prepareStatement(query);
			 * 
			 * int num = stmt.executeUpdate();
			 * 
			 * System.out.println(num + " rows affected.");
			 * System.out.println("Students Table modified!");
			 */
			
//			---------------CODE FOR D E L E T E  Q U E R Y--------------------
 
			/*
			 * String query = "delete from students where id = 104;"; PreparedStatement stmt
			 * = c.prepareStatement(query);
			 * 
			 * int num = stmt.executeUpdate();
			 * 
			 * System.out.println(num + " rows affected.");
			 * System.out.println("Student Information deleted!");
			 */
		}else
			System.out.println("Database NOT connected!");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
