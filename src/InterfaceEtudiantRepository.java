
public interface InterfaceEtudiantRepository {
	public abstract void  add(Etudiant e);
	public abstract boolean Exists(int matricule);
	public  abstract boolean Exists(String email);
	
}


