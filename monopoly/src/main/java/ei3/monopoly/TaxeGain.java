/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.monopoly;

import java.util.Random;

/**
 *les case qui donne de l'argent quand on tombe dessus ou en préléve
 * @author Quent
 */
public class TaxeGain extends Speciale {
    
    private int gain; //positif si gain, négatif si taxe

    public TaxeGain(int gain, String nom) {
        super(nom);
        this.gain = gain;
    }
    
    public TaxeGain(String nom) {
        super(nom);
        Random rand = new Random();
        this.gain = rand.nextInt(20000 + 1)-10000;
    }

    @Override
    public void appliquerEffet(Joueur j) {
        if(this.gain>0){
            System.out.println("vous gagnez "+ gain + "€");
            j.setFortune(j.getFortune()+gain);
        }
        if(this.gain<0){
            System.out.println("vous payez "+ (-1*gain) + "€");
            j.setFortune(Math.max(j.getFortune()+gain,0));  //pas de dette
        }
            
    }
    
}
