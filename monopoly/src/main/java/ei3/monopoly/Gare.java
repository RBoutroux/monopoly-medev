package ei3.monopoly;

public class Gare extends Achetable {
    public Gare(String nom, int prix){
        super(nom,prix);
    }
    public int calculerLoyer(){
        if (this.getProp()==null){
            return 0;
        }
        else{
            return 2500*this.getProp().nbGares();
        }
    }
}
