/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

/**
 * la case qui envoie en prison, actuellement etre en prison reviens juste à payer 500 pour sortir et etre déplacer sur la case
 * @author Quent
 */
public class Policier extends Speciale {
    
    public Policier(String nom) {
        super(nom);
    }
    public Policier(){
        super("policier");
    }
    
    @Override
    public void appliquerEffet(Joueur j){
        Case caseArrivee =j.getPlateau().getPlateau().get(10);
        j.setPos(caseArrivee);
        System.out.println("Vous allez en Prison");
        System.out.println("vous payez 500 pour sortir");
        j.setFortune(Math.max(j.getFortune()-500,0));
    }
}
