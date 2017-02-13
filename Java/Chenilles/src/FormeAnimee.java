
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
public class FormeAnimee implements IAnimable {
    // attributs une forme et un animateur
    protected Forme forme;
    protected IAnimateur animateur;
    // constructeur d'une forme animée qui prend comme paramètre une forme et un animateur
    public FormeAnimee(Forme forme, IAnimateur animateur) {
        this.animateur = animateur;
        this.forme = forme;
    }
    // délégation du la méthode dessiner à la forme
    @Override
    public void dessiner(Graphics G) {
        forme.dessiner(G);
    }
    // déégation de la méthode deplacer à l'animateur
    @Override
    public void deplacer() {
        animateur.deplacer(forme);
    }

}
