package sokoban_projet;

public abstract class Immobile  extends Element {

	public Immobile(Type type) {
	
		super(type);
	}

	public abstract boolean bougerVers(Direction d);
	
	
}