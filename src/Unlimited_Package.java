
public class Unlimited_Package extends AbstractFactory  {
	@Override
	public Package getPackage(TypePackage nom) {
		if(nom.equals(TypePackage.Illimit�)){
			return new Illimit�();
		}
		return null;
	}

}
