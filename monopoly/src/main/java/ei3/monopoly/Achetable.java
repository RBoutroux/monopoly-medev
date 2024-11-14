package ei3.monopoly;

public abstract class Achetable extends Case{
    private int prix;
    private Joueur proprietaire; 
    public Achetable(String nom,int prix, int pos){
        super(nom,pos);
        this.prix=prix;
        this.proprietaire=null; //Initilialize asset with no owners
    }
    public Joueur getProp(){
        return this.proprietaire;
    }
    public void setProp(Joueur j){
        this.proprietaire=j;
    }
    public void acheter(Joueur j) {
        this.proprietaire = j;
    }
    public int getPrix(){
        return this.prix;
    }
    public void setPrix(int p){
        this.prix=p;
    }
    public abstract int calculerLoyer();
    @Override
    public String toString() {
        if (this.proprietaire == null) {
            return nom + " (coût : " + prix + " €) - sans propriétaire";
        } else {
            return nom + " (coût : " + prix + " €) – propriétaire : " + this.proprietaire.getNom() + ", loyer = " + this.calculerLoyer();
        }
    }
}
