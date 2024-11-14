/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ei3.monopoly;

/**
 *
 * @author remib
 */
public class Monopoly {

    public static void main(String[] args) {
        Plateau plat = new Plateau();
        plat.initPlateau();
        Case case0 = plat.getPlateau().get(0);
        for(int i=1; i<=4 ; i++){
            Joueur j= new Joueur("joueur "+i, plat, case0 );
            plat.ajouterJoueur(j);
        }
        plat.tourDuJeu();
    }
}

