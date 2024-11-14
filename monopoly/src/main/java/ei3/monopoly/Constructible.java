package ei3.monopoly;

public class Constructible extends Achetable {
    private int nbHotel;
    private int nbMaison;
    private int loyer;
    private int prixConstruction;
    public Constructible(String nom,int prix,int h, int m, int loyer, int prixCons, int pos){
        super(nom,prix,pos);
        this.nbHotel=h;
        this.nbMaison=m;
        this.loyer=loyer;
        this.prixConstruction=prixCons;
    }
    public int getnbHotel(){
        return this.nbHotel;
    }
    public int getnbMaison(){
        return this.nbHotel;
    }
    public int getLoyer(){
        return this.loyer;
    }
    public int getprixConstruction(){
        return this.prixConstruction;
    }
    public void setnbHotel(int h){
        this.nbHotel=h;
    }
    public void setnbMaison(int m){
        this.nbMaison=m;
    }
    public void setLoyer(int l){
        this.loyer=l;
    }
    public void setprixConstruction(int p){
        this.prixConstruction=p;
    }

    public int calculerLoyer(){
        if (this.getProp()==null){
            return 0;
        }
        else{
            return this.loyer+this.nbHotel*100+this.nbMaison*10;  //a=100 b=10
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
