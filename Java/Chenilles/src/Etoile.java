
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
public class Etoile extends FormeCirculaireReguliere{

// calcul des sommets du polygone régulier
    public Etoile(Color coulT, Color coulR, int posX, int posY, int R, float bold, int nbSommets) {

        super(coulT, coulR, posX, posY, R, bold, 5);
// Etape 2
// construction du chemin reliant les points
        contour = new Path2D.Float();
        contour.moveTo(sommets[0].getX(), sommets[0].getY());
        contour.lineTo(sommets[2].getX(), sommets[2].getY());
        contour.lineTo(sommets[4].getX(), sommets[4].getY());
        contour.lineTo(sommets[1].getX(), sommets[1].getY());
        contour.lineTo(sommets[3].getX(), sommets[3].getY());
        contour.closePath();
      

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
