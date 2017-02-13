
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houzegdouh
 */
public abstract class Forme implements IDessinable {

    int xhg, yhg;
    protected Color couleurTrait = null, couleurRemplissage = null;

    protected final float bold;

// Etape 1
// calcul des sommets du polygone régulier
    protected Forme(Color coulT, Color coulR, int posX, int posY, float bold) {
        this.xhg = posX;
        this.yhg = posY;
        this.couleurTrait = coulT;
        this.couleurRemplissage = coulR;
        this.bold = bold;
//        this.deltaAngle = 360f / this.nbSommets;
//        this.sommets = new Point2D.Float[nbSommets];
//        for (int i = 0; i < nbSommets; i++) {
//            this.sommets[i] = new Point2D.Float((float) Math.cos(Math.toRadians(angle)) * R,
//                    (float) Math.sin(Math.toRadians(angle)) * R);
//            angle += deltaAngle;
//        }
    }

    protected Forme(int x, int y) {
        this(null, null, x, y, 1.0f); 
    }

    public int getX() {
        return this.xhg;
    }

    public int getY() {
        return this.xhg;
    }

    public void placerA(int x, int y) {
        this.xhg = x;
        this.yhg = y;
    }

    
}
