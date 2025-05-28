package sokoban_projet;
import java.util.ArrayList;
public class Joueur extends Mobile{
	 public static int cpt =0;
	 protected ArrayList<Direction> histo ;
	

	 public Joueur(Configuration c, Position p) {
		 super(Type.JOUEUR,c,p );
		 this.histo=new ArrayList<Direction>();
		 
	 }
	 public Joueur(Configuration c, Joueur j) {
		 super(j.type,c,j.position );
		 this.histo=new ArrayList<Direction>();
	 }
	 
	 public ArrayList<Direction> getHisto(){
		 return this.histo ;
	 
	 }
	 public  boolean bougerVers(Direction d) {//prendre en compte les caisses
			if(this.getConfiguration().estVide(this.getPosition().add(d))) {
				this.setPosition(this.getPosition().add(d)); //pas compris add/sub 
				if(!(this.getConfiguration().victoire()));
				this.getHisto().add(d);
				return true;
			}
			return false ;
		}

	public int getNbCoups() {
		
		return cpt;
			
	}
	
}