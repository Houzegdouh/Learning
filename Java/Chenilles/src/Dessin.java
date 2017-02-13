/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Dessin extends JPanel {

    /**
     * stocke la liste des VisageRond ayant été ajoutées à cette zone de dessin.
     */
    protected List<IDessinable> listeDesDessinables = new ArrayList<>();

    /**
     * retourne la largeur de la zone de dessin.
     *
     * @return la largeur.
     */
    public int getLargeur() {
        return getWidth();
    }

    /**
     * retourne la hauteur de la zone de dessin.
     *
     * @return la hauteur.
     */
    public int getHauteur() {
        return getHeight();
    }

    /**
     * ajoute un Anneau à la zone de dessin.
     *
     * @param v
     * @see VisageRond
     */
    public void ajouterObjet(IDessinable v) {

        if (!listeDesDessinables.contains(v)) {
            // l'objet n'est pas déjà dans la liste
            // on le rajoute a la liste des objets du dessin
            listeDesDessinables.add(v);
            // le dessin se réaffiche
            repaint();
        }
    }

    /**
     * temporisation de l'animation.
     *
     * @param duree
     */
    public void pause(int duree) {
        try {
            Thread.sleep(duree);
        } catch (Exception e) {
        }
    }

    /**
     * affiche la zone de dessin et son contenu
     *
     * @param g le contexte graphique
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // on dessine chacun des visages contenus dans la zone de dessin
        listeDesDessinables.stream().forEach((IDessinable v) -> {
            v.dessiner(g);
        });
    }

    public void animer() {
        listeDesDessinables.stream().filter((tmp) -> (tmp instanceof IAnimable)).map((tmp) -> (IAnimable) tmp).forEach((a) -> {
            a.deplacer();
        });

    }
}
