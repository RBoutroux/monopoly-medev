package ei3.monopoly;

public abstract class Case {
    protected String nom;
    final int p; 
    public Case(String nom,int p) {
        this.nom = nom;
        this.p = p;
    }
    public int getPosition(){
        return this.p;
    }

    @Override
    public abstract String toString();
}
