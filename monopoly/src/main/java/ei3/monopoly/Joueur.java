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
    // private Plateau plateau; 

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
    
    /**
    * Afficher les infos du joueur
    * @author grigm
    */
    @Override
    public void toString(){
        System.out.println("Nom du joueur : " + this.nom + "\nFortune : " + this.fortune); 
    }

    
    
    /**
    * 
    * @author grigm
     * @return count le nombre de compagnies que possèdent le joueur 
    */
    public int nbGares(){
        int count = 0; 
        for (int i = 0; i<40; i++){
            /*if (this.plateau.getplateau().get(i) instanceof Achetable){
              if (this.plateau.getplateau().get(i).getProp().getNom()== this.getNom()) {
                    count ++; 
                }  
            }
          */  
        }
        return count; 
    }
    
    
    /**
     *
     * @author grigm
     * @return count le nombre de compagnies que possèdent le joueur 
     */    
    public int nbCompanies(){
        int count = 0; 
        for (int i = 0; i<40; i++){
            /*if (this.plateau.getplateau().get(i) instanceof Companies){
              if (this.plateau.getplateau().get(i).getgetProp().getNom()== this.getNom()) {
                    count ++; 
                }  
            }
        */    
        }
        return count; 
    }

    /**
    * Modifier le propriétaire de la case a et payer le prix de la case
    * @author grigm
     * @param a élément achetable à acheter 
    */
    public void acheter(Achetable a){
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
    * 
    * @author grigm
    */
    public void avancer(){
         
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
     
    
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }
    
    public void tourDeJeu() {
        // Lancer du dé pour avoir un nombre aléatoire entre 1 et 6
        int de= lanceLeDe();
        
        
    }
        
    
}
