
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
public class Anneau {

    public final static int RAYON = 5;
    protected int x, y, r;

    /**
     *
     * @param xInit abscisse
     * @param yInit ordonnée
     * @param rInit rayon
     */
    public Anneau(int xInit, int yInit, int rInit) {
        this.x = xInit;
        this.y = yInit;
        this.r = rInit;
    }

    /**
     *
     * @param xInit abscisse
     * @param yInit ordonnée
     */
    public Anneau(int xInit, int yInit) {
        this(xInit, yInit, RAYON);
    }

    /**
     *
     * @return la position abscisse actuelle
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return la position ordonnée actuelle
     */
    public int getY() {
        return this.y;
    }

    /**
     * place l'anneau aux coordonnées x, y
     *
     * @param px abscisse
     * @param py ordonnée
     */
    public void placerA(int px, int py) {
        this.x = px;
        this.y = py;
    }

    /**
     * dessine matériellement
     *
     * @param g objet à dessiner
     */
    public void dessiner(Graphics g) {
        g.drawOval(this.x - this.r, this.y - this.r, 2 * this.r, 2 * this.r);
    }
}
