/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

/**
 * la case prison n'a aucun effet 
 * @author Quent
 */
public class Prison extends Speciale {
    
    public Prison(String nom) {
        super(nom);
    }
    
    public Prison(){
        super("prison");
    }

    @Override
    public void appliquerEffet(Joueur j) {
        
    }
    
    
}
