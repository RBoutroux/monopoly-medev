/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

/**
 *
 * @author grigm
 */
public class Joueur {
    private String nom; 
    private int fortune; 
    // private Case pos; 
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
    
}
