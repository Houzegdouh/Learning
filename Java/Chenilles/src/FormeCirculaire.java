
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houzegdouh
 */
public abstract class FormeCirculaire extends Forme {
// Etape 1
// calcul des sommets du polygone régulier
    protected int R;
    protected FormeCirculaire(Color coulT, Color coulR, int posX, int posY, int R, float bold) {
        super(coulT, coulR, posX, posY, bold);
        this.R = R;
    }
}
