
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houzegdouh
 */
public class ChenilleImage extends Chenille {
    /**
     * 
     * @param d feuille de dessin de la chenille
     * @param nbA nombre d'anneaux de la chenille
     * @param img l'image de la tête
     */
    public ChenilleImage(Dessin d, int nbA, BufferedImage img) {
        super(d, new TeteImage(d.getLargeur() /2 , d.getHauteur() /2, 0, img),
                img.getWidth() /2, nbA);
    }
}
