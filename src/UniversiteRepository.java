
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements InterfaceUniversiteRepository {
	
	
	
	private Ijournal j ;
	private InterfaceDBConnexion BDD ;
	private Statement stmt ;
	
	public UniversiteRepository(InterfaceDBConnexion BDD , Ijournal j){
		
		this.j = j ;
		this.BDD = BDD;
	
	}
	
@Override	
public Universite GetById(int universityId){
		
	try{
		stmt = BDD.getConn().createStatement();

		j.outPut_Msg("LogBD : début recherche de id université dans la base de donnée");
	
	String sql = "select * from universite where id_universite="+ universityId;
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next()){
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		
		j.outPut_Msg("LogBD : université récupérée");
		
		BDD.getConn().close();
		return u;
	}
	
	}catch(SQLException e){
		e.printStackTrace();
	}
	

	return null;
}


@Override
public int NbrLivreAutorise(int id_univ) {
	// TODO Auto-generated method stub
	Universite Univ =  GetById(id_univ);
	
	if (Univ.getPack() == TypePackage.Standard)
     {
		Package pack = new Standard(null);
        return pack.nbrLivreAutorise;
     }
     else if (Univ.getPack() == TypePackage.Premium)
     {
    	 Package pack = new Premuim(null);
    	 return pack.nbrLivreAutorise;
    	 }     
	
	return 0;
}
		
}

