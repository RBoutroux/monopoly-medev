package ei3.monopoly;

public class Constructible extends Achetable {
    private int nbHotel;
    private int nbMaison;
    public Constructible(String nom,int prix,int h, int m){
        super(nom,prix);
        this.nbHotel=h;
        this.nbMaison=m;
    }
    public void construire(int h, int m){
        this.nbHotel=h;
        this.nbMaison=m;
    }
    public int calculerLoyer(){
        if (this.getProp()==null){
            return 0;
        }
        else{
            return this.nbHotel*100+this.nbMaison*10;  //a=100 b=10
        }
    }
    @Override
    public String toString() {
        if (this.getProp() == null) {
            return nom + " (coût : " + this.getPrix() + " €) - sans propriétaire";
        } else {
            return nom + " (coût : " + this.getPrix() + " €) – propriétaire : " + this.getProp().getNom() + ", " +this.nbHotel +", " + this.nbMaison+ ", loyer = " + this.calculerLoyer();
        }
    }


}
