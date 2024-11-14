/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

import java.util.Random;

/**
 *Les cartes chances et caisse de communaute qui ont un effet aleatoire parmis 
 * -deplacer sur une autre case - donner ou prendre de l'argent -emprisonner
 * @author Quent
 */
public class Carte extends Speciale {
    
    public Carte(String nom) {
        super(nom);
    }
    
    @Override
    public void appliquerEffet(Joueur j){
        Random rand = new Random();
        int choix = rand.nextInt(7);
        switch(choix){
            case 0: //déplacer joueur
            case 1:
            case 2:
                deplacerJoueur(j);
                break;
            case 3: //taxe ou gain
            case 4:
            case 5:
                payerJoueur(j);
                break;
            case 6: //emprisonner
                emprisonnerJoueur(j);
                break;
        }
    }
    
    private void deplacerJoueur(Joueur j){
        Random rand = new Random();
        int indiceCase = rand.nextInt(40);
        Case caseArrivee =j.getPlateau().getPlateau().get(indiceCase);
        System.out.println("vous etes deplacé sur la case "+ caseArrivee.toString());
        if (caseArrivee.getp()<j.getPos().getp()){//il faut verifier si passage par la case départ
            System.out.println("vous passez par la case depart, vous gagnez 200000€");
            }
        j.setPos(caseArrivee);
        if (caseArrivee instanceof Speciale){
            ((Speciale) caseArrivee).appliquerEffet(j);
        }
        
    }
    
    private void payerJoueur(Joueur j){
        Random rand = new Random();
        int gain = rand.nextInt(20 + 1)-10;
        gain = gain*100;
        
        if(gain>=0){
            System.out.println("vous gagnez "+ gain + "€");
            j.setFortune(j.getFortune()+gain);
        }else{
            System.out.println("vous devez payer "+ (-1*gain) + "€");
            j.setFortune(Math.min(j.getFortune()+gain,0));  //pas de dette
        }
    }
    
    private void emprisonnerJoueur(Joueur j){
        Case caseArrivee =j.getPlateau().getPlateau().get(10);
        j.setPos(caseArrivee);
        System.out.println("Vous allez en Prison");
        System.out.println("vous payez 500 pour sortir");
        j.setFortune(Math.max(j.getFortune()-500,0));
    }
}
