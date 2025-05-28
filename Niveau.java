package sokoban_projet;
import java.util.ArrayList;
public class Niveau {

	protected Immobile [][] grille  ;
	protected ArrayList<Position> cibles ;
	
	public Niveau(int x,int y) {
		this.grille=new Immobile[x][y];
		this.cibles=new ArrayList<Position>();
	}
	
	public int getX() {
		return this.grille.length;
	
}
	public int getY() {
		return this.grille[0].length;
	}
	public boolean addMur(Position p) {
		if(this.estVide(p)) {
			grille[p.getX()][p.getY()]=new Mur();
			return true;
		}
		return false;
		
	}
	
	

	public boolean addCible(Position p) {
		
		
		if(this.estCible(p) || (!(this.estVide(p)) )) //test si il ya un mur ou une cible
			return false;
		this.getCibles().add(new Position(p));
		return true;
		}
	
	public boolean estCible(Position p) {
		
		for (Position pi : this.getCibles()) {
			if((pi.getX()==p.getX() && pi.getY()==p.getY() ))
				return true;
		}//Test si la cible est déjà présente 
		return false ;
	
	}
	public boolean estVide(Position p) {
		 //if(Type.MUR == grille[p.getX()][p.getY()].type)     //test si la case contient un mur
			//return false;
		//return true ;
		
		//return !(Type.MUR.equals(grille[p.getX()][p.getY()].getType())) ;
		
		
		return (!((grille[p.getX()][p.getY()]) instanceof Mur     ));
		
	}
	
	public Immobile get(Position p) {
		return grille[p.getX()][p.getY()];
		
	}
	public Immobile[][] getGrille(){
		return this.grille;
	}
	public ArrayList<Position> getCibles(){
		return this.cibles;
		
	}

}