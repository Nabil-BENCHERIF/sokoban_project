package sokoban_projet;

public abstract class Element {
	protected Type type ;//� remettre en protect
	
	public Element (Type type) {
		this.type=type;
		
	}
	
	public Type getType(){
		return this.type;
	}
	
	
	
	
	
	
 public abstract boolean bougerVers(Direction d) ;
		 
		 
		 
	 
	 
	
}
