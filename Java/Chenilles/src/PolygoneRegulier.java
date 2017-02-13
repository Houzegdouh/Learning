
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houzegdouh
 */
public class PolygoneRegulier extends FormeCirculaireReguliere {

// calcul des sommets du polygone régulier
    public PolygoneRegulier(Color coulT, Color coulR, int posX, int posY, int R, float bold, int nbSommets) {

        super(coulT, coulR, posX, posY, R, bold, nbSommets);
        this.contour = new Path2D.Float();
        this.contour.moveTo(sommets[0].getX(), sommets[0].getY());
        for (int i = 0; i < nbSommets; i++) {
            this.contour.lineTo(sommets[i].getX(), sommets[i].getY());
        }
        this.contour.closePath();
    }

    @Override
    public void dessiner(Graphics g) {
    
// dessin à l'aide d'un objet Graphics g
        Graphics2D g2 = (Graphics2D) g.create();   // on crée une copie de g

// Etape 3
// dessin du contour
        g2.setColor(couleurTrait);
        g2.setStroke(new BasicStroke(8.0f));
        g2.translate(this.xhg, this.yhg);  // x et y le centre du cercle définissant l'étoile
        g2.draw(contour);

// Etape 4
// Remplissage de la forme
        g2.setPaint(couleurRemplissage);
        g2.fill(contour);
    }
    
}
