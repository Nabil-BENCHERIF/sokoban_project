package sokoban_projet;
import java.util.ArrayList;
public class Solver implements SolverInterface{
	protected Configuration sokoban ;
	protected static int cpt =0;
	public ArrayList<Direction> nextcoup = new ArrayList<Direction>();
	public Solver() {
		this.sokoban=null;
	}

	public void set(Configuration sokoban) {
		this.sokoban=sokoban;
		
	}


	public Configuration getConfiguration() {
		
		return sokoban;
	}


	public boolean stop() {
        if(((this.sokoban.bougerJoueurVers(Direction.getHaut())) == (this.sokoban.bougerJoueurVers(Direction.getBas()))) && ((this.sokoban.bougerJoueurVers(Direction.getGauche())) == (this.sokoban.bougerJoueurVers(Direction.getDroite()))) && ((this.sokoban.bougerJoueurVers(Direction.getGauche())) == (this.sokoban.bougerJoueurVers(Direction.getHaut()))) && (this.sokoban.bougerJoueurVers(Direction.getGauche())==false)) {
            return true;
        }
        return this.sokoban.victoire(); 
    }

	public int getTotalSteps() {

		return Solver.cpt;
	}


	public void step() {
		double phaut=0.25;
		double pbas=0.25;
		double pgauche=0.25;
		
		Direction d ;
		
		double p=Math.random();
		    if (p<phaut )
		        d=Direction.getHaut();
		    else
		    	if(p<(phaut+pbas))
		    		d=Direction.getBas();
		    	else
		    		if(p<(phaut+pbas+pgauche))
				        d=Direction.getGauche();
		    		else
		    			d=Direction.getDroite();

		
		
		
		if(this.sokoban.bougerJoueurVers(d)); //pour ne pas return un boolean
			Solver.cpt++;
	}
	
	public ArrayList<Direction> getNextCoup() {
		nextcoup.clear();
		ArrayList<Caisse> copy = new ArrayList<Caisse>(this.sokoban.getCaisses());
		if ((this.sokoban.estVide(this.sokoban.getJoueur().getPosition().add(Direction.HAUT))) || (this.sokoban.get(this.sokoban.getJoueur().getPosition().add(Direction.HAUT)) instanceof Caisse)) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).getPosition().equals(this.sokoban.getJoueur().getPosition().add(Direction.HAUT))
						&& (this.sokoban.get(copy.get(i).getPosition().add(Direction.HAUT)).getType()
								.equals(Type.CASE))) {
					nextcoup.add(Direction.HAUT);
				}

			}
		}
		if ((this.sokoban.estVide(this.sokoban.getJoueur().getPosition().add(Direction.BAS))) || (this.sokoban.get(this.sokoban.getJoueur().getPosition().add(Direction.BAS)) instanceof Caisse)) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).getPosition().equals(this.sokoban.getJoueur().getPosition().add(Direction.BAS))
						&& (this.sokoban.get(copy.get(i).getPosition().add(Direction.BAS)).getType()
								.equals(Type.CASE))) {
					nextcoup.add(Direction.BAS);
				}

			}
		}
		if ((this.sokoban.estVide(this.sokoban.getJoueur().getPosition().add(Direction.GAUCHE))) || (this.sokoban.get(this.sokoban.getJoueur().getPosition().add(Direction.GAUCHE)) instanceof Caisse)) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).getPosition().equals(this.sokoban.getJoueur().getPosition().add(Direction.GAUCHE))
						&& (this.sokoban.get(copy.get(i).getPosition().add(Direction.GAUCHE)).getType()
								.equals(Type.CASE))) {
					nextcoup.add(Direction.GAUCHE);
				}

			}
		}
		if ((this.sokoban.estVide(this.sokoban.getJoueur().getPosition().add(Direction.DROITE))) || (this.sokoban.get(this.sokoban.getJoueur().getPosition().add(Direction.DROITE)) instanceof Caisse)) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).getPosition().equals(this.sokoban.getJoueur().getPosition().add(Direction.DROITE))
						&& (this.sokoban.get(copy.get(i).getPosition().add(Direction.DROITE)).getType()
								.equals(Type.CASE))) {
					nextcoup.add(Direction.DROITE);
				}

			}
		}
		return nextcoup;
	}
	
	
	
	
	
}
