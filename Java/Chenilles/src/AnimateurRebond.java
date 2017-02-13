
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houzegdouh
 */
public class AnimateurRebond implements IAnimateur {
private final int dx, dy;
private final Dessin d;

    public AnimateurRebond(int dx, int dy, Dessin d) {
        this.dx = dx;
        this.dy = dy;
        this.d = d;
    }
//private boolean sortAGauche(Forme f) {
//Rectangle rect = f.getRectEnglobant();
//return rect.getX() < 0;
//}
//private boolean sortADroite(Forme f) {
//Rectangle rect = f.getBounds();
//return rect.getX() + rect.getWidth() > d.getLargeur();
//}
//    

    @Override
    public void deplacer(Forme f){
    
    }
}
