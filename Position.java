package sokoban_projet;

public class Position {

	protected final int x;
	protected final int y;
	// protected static final Position POSITION = new Position ();
	public Position () {
		this((int)(Math.random()*3-1),(int)(Math.random()*3-1));
	}
	public Position(int x ,int y) {
		this.x=x;
		this.y=y;
		
	}

	public Position(Position p) {
		this.x=p.x;
		this.y=p.y;
		
	}
	
	public int getX(){
		return this.x;
		}
	
	public int getY() {
		return this.y;
	}
	
	
	public Position add(Direction d) {
		return new Position(this.x+d.getDX(),this.y+d.getDY());
		
		
	}
	
	
	public Position sub(Direction d) {
		return new Position(this.x-d.getDX(),this.y-d.getDY());
		
		
	}
	
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if (!(o instanceof Position))
			return false ;
		Position p=(Position)o;
		return p.x==this.x && p.y==this.y;
		
		
	}
	
	
	
}

