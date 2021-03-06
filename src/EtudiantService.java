import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	
	
	

  private Ijournal j ;
  private InterfaceEtudiantRepository EtudRep;
  private InterfaceUniversiteRepository UnivRep;
	
  public EtudiantService(InterfaceEtudiantRepository EtudRep ,InterfaceUniversiteRepository UnivRep, Ijournal j) {
		super();
		this.EtudRep = EtudRep;
		this.UnivRep = UnivRep;
		this.j = j; 
  }
  
	boolean inscription (Etudiant etud , int ID_univ ) throws SQLException	
	{
          Universite univ = UnivRep.GetById(ID_univ) ;
          j.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    
          if(EtudRep.Existe_Email_Matricule(etud.getMatricule(), etud.getEmail())){
  			return false;
  		}
		
		
          int nbrlivreAutorisé = UnivRep.NbrLivreAutorise(ID_univ);
  		   etud.setNbLivreMensuel_Autorise(nbrlivreAutorisé);
  		                                               
	     
		 EtudRep.add(etud);
		 j.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
		 return true;
	    
		
	}
	
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
