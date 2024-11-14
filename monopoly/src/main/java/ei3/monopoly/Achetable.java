package ei3.monopoly;

public class Achetable extends Case{
    private float prix;
    private Joueur proprietaire; 
    public Achetable(String nom,float prix){
        super(nom);
        this.prix=prix;
        this.proprietaire=null; //Initilialize asset with no owners
    }
    public Joueur getProp(){
        return this.proprietaire;
    }
    public void acheter(Joueur j) {
        this.proprietaire = j;
    }
    public float getPrix(){
        return this.prix;
    }
    public float calculerLoyer(){
        if (this.getProp()==null){
            return 0;
        }
        else{
            return 2500*Integer.parseInt(this.proprietaire.nbGares());
        }
    }
    @Override
    public String toString() {
        if (this.proprietaire == null) {
            return nom + " (coût : " + prix + " €) - sans propriétaire";
        } else {
            return nom + " (coût : " + prix + " €) – propriétaire : " + this.proprietaire.getNom() + ", loyer = " + this.calculerLoyer();
        }
    }
}
