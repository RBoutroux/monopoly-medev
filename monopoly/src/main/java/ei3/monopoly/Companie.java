package ei3.monopoly;

public class Companie extends Achetable {
    public Companie(String nom, int prix){
        super(nom,prix);
    }
    public int calculerLoyer(){
        if (this.getProp()==null){
            return 0;
        }
        else{
            return 1500*this.getProp().nbCompanies();
        }
    }
}
