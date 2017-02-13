
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.nio.file.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houzegdouh
 */
public abstract class FormeCirculaireReguliere extends FormeCirculaire {

    protected final int nbS;
    protected Point2D.Float[] sommets;
    protected Path2D contour;
// Etape 1
// calcul des sommets du polygone régulier

    protected FormeCirculaireReguliere(Color coulT, Color coulR, int posX, int posY, int R,
            float bold, int nbSommets) {
        super(coulT, coulR, posX, posY, R, bold);
        this.nbS = nbSommets;
        float deltaAngle = 360f / nbSommets;
        float angle = -90;
        sommets = new Point2D.Float[nbSommets];
        for (int i = 0; i < nbSommets; i++) {
            sommets[i] = new Point2D.Float(
                    (float) Math.cos(Math.toRadians(angle)) * R,
                    (float) Math.sin(Math.toRadians(angle)) * R
            );
            angle += deltaAngle;

        }
    }

}
