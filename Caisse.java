package sokoban_projet;

public class Caisse extends Mobile {

	public Caisse(Configuration c, Position p) {
		super(Type.CAISSE,c,p );
	}

	public  boolean bougerVers(Direction d) {
		if(this.getConfiguration().estVide(this.getPosition().add(d))) {
			this.setPosition(this.getPosition().add(d)); //pas compris add/sub 
			return true;
		}
		return false ;
	}

}