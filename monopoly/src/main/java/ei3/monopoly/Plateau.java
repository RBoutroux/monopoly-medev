*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;


/**
 * Classe Plateau de Jeu
 * @author Kaoutar et Larissa 
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
        int nbAlea, randomise;
        
        Prison p = new Prison("Prison");
        plateau.add(p);
        
        for (int i = 1; i < NB_CASES; i++){
            Case e;
            nbAlea = generateurAleatoire.nextInt(3);
            
            switch (nbAlea){
                case 0:
                    e = new Gare("Gare", 0);
                    plateau.add(e);    
                    break;
                case 1:
                    e = new Companie("Companie",0);
                    plateau.add(e);    
                    break;
                case 2:
                    e = new Constructible("Constructible",0, 0, 0);
                    plateau.add(e);    
                    break;
                case 3: //cree des cases non achetables
                    
                    randomise = generateurAleatoire.nextInt(2);
                    
                    switch(nbAlea){
                        case 0:
                            e = new TaxeGain("TaxeGain");
                            break;
                        case 1:
                            e = new Carte("Carte");
                            break;
                        case 2:
                            e = new Policier("Policier");
                            break;
                    }
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
                Achetable a = (Achetable)e;
                if( a.getProp() == j ){
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
     * @return La case située i cases plus loin
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
        if(j.getFortune()<=0){
             joueurs.remove(j);
             System.out.println(":(.....joueur éliminé");
             j.toString(); 
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
    public void affiche(){
        System.out.println("Plateau :");
        for(int i=0;i<plateau.size();i++){
            plateau.get(i).toString();
        }
        
        System.out.println("=====================================");
        System.out.println("Liste des joueurs :");
        
        for(int i=0;i<joueurs.size();i++){
            System.out.println("---------");
            System.out.println("Joueur "+(i+1));
            Joueur j=joueurs.get(i);
            j.toString();
            System.out.println("liste des cases que le joueur possède : ");
            for (Case c:plateau){
                if (c instanceof Achetable){
                    if (((Achetable) c).getProp()==j) {
                        System.out.println(((Achetable) c).nom);
                    }  
                }
            }
        }
    }
}
