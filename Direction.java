package sokoban_projet;
import java.util.ArrayList;
public class Direction {
	protected int dx;
	protected int dy;

	protected static final Direction HAUT = new Direction(0,-1);
	protected static final Direction BAS = new Direction(0,1);
	protected static final Direction GAUCHE = new Direction(-1,0);
	protected static final Direction DROITE = new Direction(1,0);
	
	protected ArrayList<Direction> DIRECTIONS=new ArrayList<Direction>();
	
	protected Direction(int dx,int dy){
		this.dx=dx;
		this.dy=dy;
		
		}
	public static Direction getHaut(){
		return HAUT ;}
	public static Direction getBas(){
		return BAS ;}
	public static Direction getGauche(){
		return GAUCHE ;}
	public static Direction getDroite(){
		return DROITE ;}
		
	public int getDX(){
		return dx;
		}
	public int getDY(){
		return dy;
		}
	
	public  ArrayList<Direction> getDirections(){
		this.DIRECTIONS.add(Direction.HAUT);
		this.DIRECTIONS.add(Direction.BAS);
		this.DIRECTIONS.add(Direction.GAUCHE);
		this.DIRECTIONS.add(Direction.DROITE);
		return DIRECTIONS ;
	}
}
