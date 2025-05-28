package sokoban_projet;

public class Case extends Immobile {

	public Case() {
		
		super(Type.CASE);
		
		}
		 public  boolean bougerVers(Direction d) {
			 return false;
		 }
	}