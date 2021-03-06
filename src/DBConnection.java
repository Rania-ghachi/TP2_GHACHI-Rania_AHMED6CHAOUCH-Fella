import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements InterfaceDBConnexion {
	   
		String BDD = "library_books";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
	    private Connection conn;
	    private static DBConnection db;
	    
	   
	   private DBConnection() {
			}
	   
	   public static DBConnection getInstance(){
			if(db == null){
				db = new DBConnection();
				System.out.println("nouveau");
			}else{
				System.out.println("existe deja");

			}
			return db;
		}
		
	    public Connection getConn() {
			return conn;
		}


		
	
}
