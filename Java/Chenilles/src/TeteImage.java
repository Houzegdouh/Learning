
import java.awt.Graphics;
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
public class TeteImage extends Tete {

    private final BufferedImage image;

    /**
     *
     * @param xInit position abscisse initiale
     * @param yInit position ordonnée initiale
     * @param cap cap initial de la tête
     * @param img image pour remplacer la tête
     */
    public TeteImage(int xInit, int yInit, int cap, BufferedImage img) {
        super(xInit, yInit, img.getWidth() / 2, cap);
        this.image = img;
    }

    @Override
    public void dessiner(Graphics g) {
        g.drawImage(this.image,
                this.x - r, this.y - r, this.x + r, this.y + r,
                0, 0, 63, 63, null);
    }
}
