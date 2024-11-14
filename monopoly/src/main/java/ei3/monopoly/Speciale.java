/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

/**
 *Toutes les case qui ne sont pas achetable qui ont des effets sur le jeu (prison, cartes chances,...)
 * @author Quent
 */
public abstract class Speciale extends Case {

    public Speciale(String nom, int id) {
        super(nom, id);
    }

    @Override
    public String toString() {
        return this.nom;
    }
    
    public  abstract void appliquerEffet(Joueur j);
}
