
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
public class Chenille implements IAnimable {

    private final Anneau lesAnneaux[];
    protected Tete teteChenille;
    protected Dessin dessinChenille;

    public Chenille(Dessin d, int r, int nbA) {
        this(d, new Tete(d.getLargeur() / 2, d.getHauteur() / 2, r, 0.0), r, nbA);
    }

    protected Chenille(Dessin d, Tete tete, int r, int nbA) {

        this.dessinChenille = d;
        // crée une tête au centre de la fenêtre et de cap 0
        this.teteChenille = tete;
        int xTete = teteChenille.getX();
        int yTete = teteChenille.getY();

        // 1) créer le tableau
        lesAnneaux = new Anneau[nbA];
        // 2) remplir le tableau en créeant les anneau et en stockant
        //    leur référence dans les éléments du tableau.
        // créé les anneaux, à gauche les uns des autres. Le premier
        // (Anneau n° 0) étant à gauche de la tête
        for (int i = 0; i < lesAnneaux.length; i++) {
            lesAnneaux[i] = new Anneau(xTete - (i + 1) * r, yTete, r);
        }
    }

    @Override
    public void deplacer() {
        if (lesAnneaux.length > 0) {
            // fait avancer les anneaux.
            // le ième anneau prends la place du (i-1)ème anneau, l'anneau 0 prenant la place
            // de la tête
            for (int i = lesAnneaux.length - 1; i > 0; i--) {
                lesAnneaux[i].placerA(lesAnneaux[i - 1].getX(), lesAnneaux[i - 1].getY());
            }

            lesAnneaux[0].placerA(teteChenille.getX(), teteChenille.getY());
        }

        // calcule un nouveau cap qui garanti que la tête reste dans la zone
        // de dessin
        teteChenille.devierCap(-30.0 + Math.random() * 60.0);
        while (!teteChenille.capOK(dessinChenille.getLargeur(), dessinChenille.getHauteur())) {
            teteChenille.devierCap(10);
        }
        // fait avancer la tête
        teteChenille.deplacerSelonCap();
    }

    @Override
    public void dessiner(Graphics g) {
        teteChenille.dessiner(g);
        for (Anneau anneau : lesAnneaux) {
            anneau.dessiner(g);
        }
    }
}
