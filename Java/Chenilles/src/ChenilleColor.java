
import java.awt.Color;
import java.awt.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houzegdouh
 */
public class ChenilleColor extends Chenille {
    //Création d'une nouvelle couleur à chaque instanciation
    private final Color couleur;
    /**
     * 
     * @param coul couleur de la chenille instanciée
     * @param d méthode dessiner importer avec super
     * @param r rayon 
     * @param nbA nombre d'anneaux d'une chenille
     */
    public ChenilleColor (Color coul, Dessin d, int r, int nbA){
        super(d, r , nbA);
        this.couleur = coul;
    }
    /**
     * 
     * @param g context graphique
     */
    @Override
    public void dessiner(Graphics g){
        // Copier le context graphique
        Graphics gd = g.create();
        // Modifier la copie pour que le changement de couleur n'affecte qu'elle
        gd.setColor(couleur);
        // Dessiner avec la méthode héritée pas avec celle qu'on redéfinie actuellement
        super.dessiner(gd);
        
    }
}
