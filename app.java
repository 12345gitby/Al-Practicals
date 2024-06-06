import java.sql.DriverManager;
import java.sql.*;

public class app {
	public static void main(String args[]) {
		
		
		// 1.Load and register driver as per db requirement
		Connection connection=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Driver loaded successfully.....");
			// establish conn
            String username="jayzzz";
            String pass="00922";
            String url= "jdbc:mysql://localhost:3306/ineuron";


            connection= DriverManager.getConnection(url,pass,username);



		}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			
		
		}
	}
	}
