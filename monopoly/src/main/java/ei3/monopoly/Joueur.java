/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

/**
 *
 * @author grigm
 * @author nekouki
 */
public class Joueur {
    private String nom; 
    private int fortune; 
    private Case pos; 
    private Plateau plateau;
    
    /**
     * constructeur joueur
     * @param nom : nom du joueur
     * @param plateau
     * @param pos : position du joueur
     * @author nekouki
     */
    public Joueur(String nom, Plateau plateau, Case pos) {
        this.nom = nom;
        this.plateau = plateau;
        this.pos = pos;
        this.fortune = 100000; // Fortune initiale de 100000 €
    }
    /**
     * constructeur par defaut
     * @author nekouki
     */
    
    public Joueur() {
        this.nom="Bob";
        this.pos=null;
        this.fortune = 100000; // Fortune initialisée par défaut à 100000 €
    }

    
   
    public String getNom() {
        return nom;
    }

    public int getFortune() {
        return fortune;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }
    
    public Plateau getPlateau() {
        return this.plateau;
    }
    
    public Case getPos(){
        return this.pos; 
    }
    

    
    public void setPos(Case nouvelleposition) {
        this.pos= nouvelleposition;
    }
    
    /**
    /**
    * Afficher les infos du joueur
    * @author grigm
    */
    @Override
    public String toString(){
        return "Nom du joueur : " + this.nom + "\nFortune : " + this.fortune; 
    }

    
    
    /**
    * 
    * @author grigm
     * @return count le nombre de compagnies que possèdent le joueur 
    */
    public int nbGares(){
        int count = 0; 
        for (int i = 0; i<40; i++){
            Case caseTestee = this.plateau.getPlateau().get(i);
            if (caseTestee instanceof Achetable){
                if (((Achetable) caseTestee).getProp().getNom()== this.getNom()) {
                    count ++; 
                }  
            }
           
        }
        return count; 
    
    }
    
    
    /**
    * Modifier le propriétaire de la case a et payer le prix de la case
     *
     * @author grigm
     * @return count le nombre de compagnies que possèdent le joueur 
     */       
    public int nbCompanies(){
        int count = 0; 
        for (int i = 0; i<40; i++){
            if (this.plateau.getPlateau().get(i) instanceof Companie){
              if (((Achetable) this.plateau.getPlateau().get(i)).getProp().getNom()== this.getNom()) {
                    count ++; 
                }  
            }
           
        }
        return count; 
    }

     
   

    /**
    * Modifier le propriétaire de la case a et payer le prix de la case
    * @author grigm
     * @param a élément achetable à acheter 
    */
    public void acheter(Achetable a)throws NoMoreMoney {
         if (this.fortune < a.getPrix()) {
            throw new NoMoreMoney("Fonds insuffisants pour le paiement.");
        }
        a.acheter(this);
         
         //on paie le prix de l'achat 
         this.fortune = this.fortune - a.getPrix(); 
         
    }
    
    
    /**
    * Récupérer le prix de la case qu'on hypothèque
    * @author grigm
     * @param a case à hypotequer
    */
    public void hypotequer(Achetable a){
        //on récupère le montant de la case 
         this.fortune = this.fortune + a.getPrix(); 
          
    }
    
      /**
    * Méthode pour construire une maison ou un immeuble
    * @author grigm
     * @param c case où construire une maison
    */
    public void construire(Constructible c){
       
        // on vérifie si on a assez d'argent 
        if (c.getprixConstruction() > this.fortune){
            System.out.println ("Vous n'avez pas assez d'argent pour construire"); 
        } else {
            // on paie la construction
            this.fortune = this.fortune - c.getprixConstruction(); 
            // on vérifie le nombre de maisons sur la case, moins de 4, on rajoute une maison 
            if (c.getnbMaison()<=4){
                c.setnbMaison(c.getnbMaison()+1) ; 
            } // 4 maisons on met un immeuble et on enlève les maisons
            else {
                 c.setnbMaison(0) ; 
                 c.setnbHotel(c.getnbHotel()+1);  
            }     
        }   
    }

   
    
    
  
  
    // Méthode de paiement d'une somme à un autre joueur
    public void payer(Joueur autreJoueur, int montant) throws NoMoreMoney {
        if (this.fortune < montant) {
            throw new NoMoreMoney("Fonds insuffisants pour le paiement.");
        }
        this.fortune -= montant;
        autreJoueur.fortune += montant;
    }
    
    // Classe d'exception pour gérer le cas de fonds insuffisants
    public static class NoMoreMoney extends Exception {
        public NoMoreMoney(String message) {
            super(message);
        }
    }
     
    /**
     * lancer de dé
     * @return entier entre 1 et 6
     */
    /**
     * lancer de dé
     * @return entier entre 1 et 6
     */
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }
    
    /**
     * @param d: entier issu du dé
     * @author: nekouki
     */
    
    public void avancer(int d) {
        // calcul de la nouvelle position
        int nouvellePosition = (pos.getPosition() + d) % 40;
        // Mettre à jour la position de la case
        Case nouvelle = this.plateau.getPlateau().get(nouvellePosition);
        this.setPos(nouvelle);
        
    }
    
    /**
     * Tour de Jeu
     * @author nekouki
     */
    
    public void tourDeJeu() {
        // Lancer du dé pour avoir un nombre aléatoire entre 1 et 6
        int de= lanceLeDe();
        // Avancer le joueur sur le plateau
        avancer(de);
        // 
        if (pos instanceof Speciale) {
            // Appliquer l'effet de la case spéciale
            ((Speciale) pos).appliquerEffet(this);
            
        } else if (pos instanceof Achetable) {
            Achetable caseAchetable = (Achetable) pos;
            if (de % 2 == 1 && caseAchetable.getProp() == null && fortune >= caseAchetable.getPrix()) {
                try {
                    acheter(caseAchetable);
                } catch (NoMoreMoney e) {
                    System.out.println(e.getMessage());
                }
            } else if (caseAchetable.getProp() != null && caseAchetable.getProp() != this) {
                try {
                    payer(caseAchetable.getProp(), caseAchetable.calculerLoyer());
                } catch (NoMoreMoney e) {
                    System.out.println(nom + " ne peut pas payer le loyer et est éliminé.");
                    plateau.elimination(this);
                }
            }
        
    
        }
    }   
        
       
}
