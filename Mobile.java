package sokoban_projet;

public abstract class Mobile  extends Element {
	protected Configuration configuration;
	protected Position position;
	public Mobile(Type type ,Configuration c, Position p) {
		super(type);
		this.configuration=c;
		this.position=p;
		
	}
	boolean setPosition(Position p) {
		if (this.getPosition().equals(p))// test si la position actuelle est égal à la modification
			return true;
		this.position = new Position(p);
		if (this.getPosition().equals(p))// retest si la position actuelle est égal à la modification
			return true;
		else
			return false;
	}
	
	public Position getPosition() {
		return this.position;
	}
	public Configuration getConfiguration() {
		return this.configuration ;
	}
	public abstract boolean bougerVers(Direction d);
		
		
	
}