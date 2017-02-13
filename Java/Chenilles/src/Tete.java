
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
public class Tete extends Anneau {

    private double cap;

    /**
     * Constructeur avec cap et rayon
     *
     * @param xInit abscisse
     * @param yInit ordonnée
     * @param rInit rayon
     * @param cInit cap
     */
    public Tete(int xInit, int yInit, int rInit, double cInit) {
        super(xInit, yInit, rInit);
        this.cap = cInit;
    }

    /**
     * constructeur de position
     *
     * @param xInit abscisse
     * @param yInit ordonnée
     */
    public Tete(int xInit, int yInit) {
        this(xInit, yInit, RAYON, 0.0);
    }

    public void deplacerSelonCap() {
        this.x = (int) (this.x + this.r * Math.cos(Math.PI * cap / 180));
        this.y = (int) (this.y + this.r * Math.sin(Math.PI * cap / 180));
    }

    /**
     *
     *
     * @param xMax abscisse bordure
     * @param yMax ordonnée bordure
     * @return
     */
    public boolean capOK(int xMax, int yMax) {
        int x1 = (int) (this.x + this.r * Math.cos(Math.PI * cap / 180));
        int y1 = (int) (this.y + this.r * Math.sin(Math.PI * cap / 180));
        boolean oui = x1 >= this.r && x1 <= (xMax - r) && y1 >= this.r && y1 <= (yMax - r);
        return oui;
    }

    private double normalize(double d) {
        double res = Math.abs(d) % 360;
        if (d < 0) {
            if (res > 180) {
                res = 360 - res;
            } else {
                res = -res;
            }
        } else if (res > 180) {
            res = -(360 - res);
        }
        return res;
    }

    public void devierCap(double deltaCap) {
        this.cap = this.cap + deltaCap;
        this.cap = normalize(this.cap);
    }

    /**
     *
     * @param g
     */
    @Override
    public void dessiner(Graphics g) {
        g.fillOval(this.x - this.r, this.y - this.r, 2 * this.r, 2 * this.r);
    }
}
