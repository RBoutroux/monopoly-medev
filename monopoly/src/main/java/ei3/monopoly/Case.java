package ei3.monopoly;

public abstract class Case {
    protected String nom;
    //final int p; // Index of the square Commented following the class diagram
    public Case(String nom) {
        this.nom = nom;
        //this.p = p;
    }

    @Override
    public abstract String toString();
}
