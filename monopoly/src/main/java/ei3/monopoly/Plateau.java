/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;


/**
 *
 * @author User
 */
public class Plateau {
    ArrayList<Case> plateau; //stocker 40 cases
    LinkedList<Joueur> joueurs; //stocker les joeurs
    
    public static final int NB_CASES = 40;
    
    public final int NB_GARES = 10;
    public final int NB_CONSTRUCTIBLES = 10;
    public final int NB_ACHETABLES = 10;
    public final int NB_NON_ACHETABLES = 10;
    
    public Plateau(){
        plateau = new ArrayList<>();
        joueurs = new LinkedList<>();
    }
    
    /**
    * Initialise le plateau de jeu
    */
    
    //probleme: les cases n'ont pas de nom
    public void initPlateau(){
        
        Random generateurAleatoire = new Random();

        int nbAlea = generateurAleatoire.nextInt(3);
        
        for (int i = 0; i < NB_CASES; i++){
            switch (nbAlea){
                case 0:
                    Case e = new Gare("");
                    plateau.add(e);    
                    break;
                case 1:
                    Case e  = new Companie("");
                    plateau.add(e);    
                    break;
                case 2:
                    Case e = new Constructible("");
                    plateau.add(e);    
                    break;
                case 3:
                    Case e = new NonAchetable("");
                    plateau.add(e);    
                    break;
            }  
             
            setNomCase("file.txt");
        }
        
    }
    
    /**
     * Donne le nom de toutes les cases du jeu d'après un fichier .txt
     * @param nomFichier nom du fichier
     */
    public void setNomCase(String nomFichier){
        //prend un fichier .txt et renomme toutes les cases du jeu
    }
    
    /**
     * Calcule le nombre de gares possedées par un joueur
     * @param j Joueur
     * @return Le nombre de gares possédées par un joueur
     */
    public int nombreGare(Joueur j){
        Iterator<Case> it = plateau.iterator();
        int nbGare = 0;
        
        //Verifie si la case est une gare, et apres verifie si le joueur j est son proprietaire
        while(it.hasNext()){
            Case e = it.next();
            if (e instanceof Gare){
                if( j == Gare.getProprietaire() ){
                    nbGare++;
                }
            }
        }
        
        return nbGare;
    }
    
    /**
     * Avance d cases 
     * @param c Case actuelle
     * @param i Nombre de cases à avancer
     * @return La case située d cases plus loin
    */
    public Case avance(Case c, int i){
        int indexActuel = plateau.indexOf(c);
        int newIndex;
        
        if (indexActuel >= 0){
            newIndex = indexActuel + i;
            
            if(newIndex >= NB_CASES){
               newIndex = newIndex - NB_CASES; 
            }
            return plateau.get(newIndex);
        }
        else {
            System.out.println("Case n'existe pas");
            return null;
        }
    }
    /**
     * éliminer le joueur si sa fortune <=0
     * @param j: le joueur en compte
     */
    public void elimination(Joueur j){
        if(j.getFortune()<=0) joueurs.remove(j);
    }
    
    /**
     * Cette méthode a pour rêle de définir la fin de partie
     * la partie est terminée s'il reste un seule joueur dans la liste des joueurs 
     * 
     * @return vrai si la partie est terminée sion elle retourne faux
     */
    public boolean findePartie(){
            return (1==joueurs.size());
    }
    
    /**
     * cette méthode définit le tour du jeu 
     */
    public void tourDuJeu(){
        
        while(!findePartie()){
            for(Joueur j: joueurs){
                //le joueur joue 
                j.tourDeJeu();
                //on l'elemine si la condition d'élimination est vérifiée 
                elimination(j);
            }
        }
    
    }
    
    /**
     * Cette méthode a pour rêle de définir la fin de partie
     * la partie est terminée s'il reste un seule joueur dans la liste des joueurs 
     * 
     * @return vrai si la partie est terminée sion elle retourne faux
     */
    public boolean findePartie(){
            return (1==joueurs.size());
    }
    /**
     * 
     */
}
