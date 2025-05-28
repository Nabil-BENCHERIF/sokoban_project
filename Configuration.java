package sokoban_projet;

import java.util.ArrayList;

public class Configuration {
   
	protected ArrayList<Caisse> caisses;
	protected Joueur joueur;
	protected Niveau niveau;
	
	public Configuration(Niveau n,Position pij ) {
		this.niveau=n;
		this.joueur=new Joueur(this, pij);
		this.caisses=new ArrayList<Caisse>();
	}
	
	public Configuration(Configuration c) {
      
        this.niveau=c.getNiveau();
        this.joueur=c.getJoueur();
        this.caisses=c.getCaisses();
    
}
	
	
	public Niveau getNiveau() {
		return this.niveau;
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	
	public ArrayList<Caisse> getCaisses(){
		return  this.caisses;
	}
	
	public int getX() {
		return this.niveau.getX();
	}
	
	public int getY() {
		return this.niveau.getY();
	}
	
	public boolean addCaisse(Position p) {
			
			if(this.estCible(p) || (!(this.estVide(p)) )) //test si il ya un mur ou une cible
				return false;
			this.getCaisses().add(new Caisse(this,p));
			return true;
			}
	

	public boolean estCible(Position p) {
		return this.getNiveau().estCible(p);
		
	}
	

	public boolean estVide(Position p) {
		if(this.get(p).getType()==Type.CAISSE)
			return  false ;
		return this.getNiveau().estVide(p);
		
	}
	
	public Element get(Position p) {//pas compris
		if(this.getJoueur().getPosition().getX()==p.getX() && this.getJoueur().getPosition().getY()==p.getY() )
			return this.getJoueur();
		if(!(this.getNiveau().estVide(p)))
				return this.getNiveau().get(p);
	
		for(Caisse pi : this.getCaisses())
			if((pi.getPosition().getX()==p.getX() && pi.getPosition().getY()==p.getY()))
				return pi ;
		return new Case();
				
			
			
	
}

	public boolean bougerJoueurVers(Direction d) {//cas du sub ou add pas compris
		if(this.get(this.getJoueur().getPosition().add(d)).bougerVers(d) && this.getJoueur().bougerVers(d))
			Joueur.cpt++;
		if(this.get(this.getJoueur().getPosition().add(d)).getType()==Type.CAISSE) {
		
			return this.get(this.getJoueur().getPosition().add(d)).bougerVers(d) && this.getJoueur().bougerVers(d);
	}
				
		return this.getJoueur().bougerVers(d);
	
	
	}
	

	public boolean victoire() {// à completer

        int i=0;

        for(Caisse ci : this.getCaisses()) {
            for(Position cj : this.getNiveau().getCibles()) {
                if((ci.getPosition().getX()==cj.getX() && ci.getPosition().getY()==cj.getY())) {
                    i=1;
                }
            }
            if(i==0) {
                return false;
            }else {

                i=0;
            }

        }
        return true;

    }

	public String toString() { //à completer
		int x=this.getNiveau().getX();
		int y=this.getNiveau().getY();
		String s="";
		Element e ;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				 
				e =this.get(new Position(i,j));
				if(e.getType()==Type.MUR);
					s+="#";
				if(e.getType()==Type.CASE)
					if(this.estCible(new Position(i,j)))
			            s+=".";
			            
			        else
			            s+=" ";
			            
					
				if(e.getType()==Type.JOUEUR)
					if(this.estCible(((Mobile)e).getPosition()))
			            s+="+";
					else
						s+="@";
				if(e.getType()==Type.CAISSE)
					if(this.estCible(((Mobile)e).getPosition()))
			            s+="*";
					else
						s+="$";
				}
			 if(i%y==0)
			    s+="\n";
			        	
					
		
		}
	return s;
	
	}	
}