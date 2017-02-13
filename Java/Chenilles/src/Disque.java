
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
public class Disque extends FormeCirculaire {

    /**
     *
     * @param coulT
     * @param coulR
     * @param posX
     * @param posY
     * @param R
     * @param bold
     */
    public Disque(Color coulT, Color coulR, int posX, int posY, int R, float bold) {
        super(coulT, coulR, posX, posY, R, bold);
    }

    /**
     *
     * @return la position abscisse actuelle
     */
    @Override
    public int getX() {
        return this.xhg;
    }

    /**
     *
     * @return la position ordonnée actuelle
     */
    @Override
    public int getY() {
        return this.yhg;
    }

    /**
     * place l'anneau aux coordonnées x, y
     *
     * @param px abscisse
     * @param py ordonnée
     */
    @Override
    public void placerA(int px, int py) {
        this.xhg = px;
        this.yhg = py;
    }

    /**
     * dessine matériellement
     *
     * @param g objet à dessiner
     */
    @Override
    public void dessiner(Graphics g) {
        g.drawOval(this.xhg - this.R, this.yhg - this.R, 2 * this.R, 2 * this.R);
    }
}
